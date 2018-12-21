package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.pojo.Author;
import com.lynk.project.repoindex.pojo.Project;
import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.pojo.Version;
import com.lynk.project.repoindex.repository.AuthorRepository;
import org.codehaus.plexus.archiver.tar.TarGZipUnArchiver;
import org.codehaus.plexus.logging.console.ConsoleLoggerManager;
import org.codehaus.plexus.util.FileUtils;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

public class RepositoryUpdaterThread implements Runnable{

    private Set<String> packageToUpdate;

    private Repository repository;

    private AuthorRepository authorRepository;

    public RepositoryUpdaterThread(Set<String> packageToUpdate, Repository repository, AuthorRepository authorRepository) {
        this.packageToUpdate = packageToUpdate;
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    private void downloadTar(String url, String destinationFile) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Exception while downloading the package.");
        }
    }

    private void decompress(File sourceFile, File destDir) throws IOException {
        final TarGZipUnArchiver ua = new TarGZipUnArchiver();
        ConsoleLoggerManager manager = new ConsoleLoggerManager();
        manager.initialize();

        ua.enableLogging(manager.getLoggerForComponent("logging "));

        ua.setSourceFile(sourceFile);
        destDir.mkdirs();
        ua.setDestDirectory(destDir);
        ua.extract();
    }

    @Override
    public void run() {
        for(String url : packageToUpdate) {
            String packageFileName = url.substring(url.lastIndexOf('/') + 1);
            try {
                downloadTar(url, packageFileName);
                decompress(new File(packageFileName), new File("."));

                File file = new File(packageFileName);
                String tarAbsolutePath = file.getAbsolutePath();
                String parentFolder = tarAbsolutePath.substring(0, tarAbsolutePath.indexOf("_"));

                processData(url, parentFolder);

                FileUtils.deleteDirectory(new File(parentFolder));
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processData(String url, String parentFolder) throws IOException {
        String descAbsolutePath = parentFolder + "/DESCRIPTION";
        Properties p = new Properties();
        p.load(new FileInputStream(descAbsolutePath));

        String projectTitle = p.getProperty("Title");
        String projectDescription = p.getProperty("Description");
        String dependsOn = p.getProperty("Depends");
        String versionText = p.getProperty("Version");
        String licenseText = p.getProperty("License");
        String maintainer = p.getProperty("Maintainer");
        String authorContact = p.getProperty("Author");

        Project project = new Project();
        project.setRepository(repository);
        project.setTitle(projectTitle != null ? projectTitle : null);
        project.setDescription(projectDescription != null ? projectDescription : null);

        Version version = new Version();
        version.setDependsOn(dependsOn != null ? dependsOn : null);
        version.setProject(project);
        version.setVersion(versionText != null ? versionText : null);
        version.setLiscence(licenseText != null ? licenseText : null);
        version.setUrl(url);

        Author author = new Author();
        author.setVersion(version);
        author.setEmail(maintainer != null ? maintainer : null);
        author.setName(authorContact != null ? authorContact : null);

        authorRepository.save(author);
    }
}
