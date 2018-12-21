package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.pojo.Author;
import com.lynk.project.repoindex.pojo.Project;
import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.pojo.Version;
import com.lynk.project.repoindex.repository.AuthorRepository;
import com.lynk.project.repoindex.repository.ProjectRepository;
import com.lynk.project.repoindex.repository.RepoRepository;
import com.lynk.project.repoindex.repository.VersionRepository;
import com.lynk.project.repoindex.response.FetchAuthorForVersionResponse;
import com.lynk.project.repoindex.response.FetchPackageForRepositoryResponse;
import com.lynk.project.repoindex.response.FetchVersionsForPackageResponse;
import com.lynk.project.repoindex.response.pojo.ResponseAuthor;
import com.lynk.project.repoindex.response.pojo.ResponseProject;
import com.lynk.project.repoindex.response.pojo.ResponseVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingPageService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RepoRepository repoRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public FetchPackageForRepositoryResponse handleFetchPackageForRepository(String repoId) {
        FetchPackageForRepositoryResponse fetchPackageForRepositoryResponse = new FetchPackageForRepositoryResponse();
        try {
            Repository repository = repoRepository.findById(Integer.parseInt(repoId)).orElse(null);
            if(repository == null)
                throw new Exception("invalid repo id...");

            List<Project> projects = projectRepository.findByRepositoryId(repository.getId());
            List<ResponseProject> projectList = new ArrayList<>();
            for(Project project : projects) {
                ResponseProject responseProject = new ResponseProject(project.getId(), project.getRepository().getId(),
                        project.getDescription(), project.getTitle());
                projectList.add(responseProject);
            }

            fetchPackageForRepositoryResponse.setProjects(projectList);
            fetchPackageForRepositoryResponse.setStatus("Success");
        } catch (Exception e) {
            fetchPackageForRepositoryResponse.setStatus("Failure");
        }
        return fetchPackageForRepositoryResponse;
    }

    public FetchAuthorForVersionResponse handleFetchAuthorForVersion(String versionId) {
        FetchAuthorForVersionResponse fetchAuthorForVersionResponse = new FetchAuthorForVersionResponse();
        try {
            Version version = versionRepository.findById(Integer.parseInt(versionId)).orElse(null);
            if(version == null)
                throw new Exception("invalid repo id...");

            List<Author> authors = authorRepository.findByVersionId(version.getId());
            List<ResponseAuthor> authorList = new ArrayList<>();
            for(Author author : authors) {
                ResponseAuthor responseAuthor = new ResponseAuthor(author.getId(), author.getVersion().getId(),
                        author.getName(), author.getEmail());
                authorList.add(responseAuthor);
            }

            fetchAuthorForVersionResponse.setAuthors(authorList);
            fetchAuthorForVersionResponse.setStatus("Success");
        } catch (Exception e) {
            fetchAuthorForVersionResponse.setStatus("Failure");
        }
        return fetchAuthorForVersionResponse;
    }

    public FetchVersionsForPackageResponse handleFetchVersionsForPackage(String packageId) {
        FetchVersionsForPackageResponse fetchVersionsForPackageResponse = new FetchVersionsForPackageResponse();
        try {
            Project project = projectRepository.findById(Integer.parseInt(packageId)).orElse(null);
            if(project == null)
                throw new Exception("invalid repo id...");

            List<Version> versions = versionRepository.findByProjectId(project.getId());
            List<ResponseVersion> versionList = new ArrayList<>();
            for(Version version : versions) {
                ResponseVersion responseVersion = new ResponseVersion(version.getId(), version.getProject().getId(), version.getVersion(),
                        version.getLiscence(), version.getDependsOn(), version.getUrl());
                versionList.add(responseVersion);
            }

            fetchVersionsForPackageResponse.setVersions(versionList);
            fetchVersionsForPackageResponse.setStatus("Success");
        } catch (Exception e) {
            fetchVersionsForPackageResponse.setStatus("Failure");
        }
        return fetchVersionsForPackageResponse;
    }
}
