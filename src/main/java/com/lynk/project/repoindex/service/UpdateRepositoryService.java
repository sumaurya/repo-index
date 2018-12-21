package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.repository.AuthorRepository;
import com.lynk.project.repoindex.repository.ProjectRepository;
import com.lynk.project.repoindex.repository.RepoRepository;
import com.lynk.project.repoindex.repository.VersionRepository;
import com.lynk.project.repoindex.request.UpdateRepositoryRequest;
import com.lynk.project.repoindex.response.UpdateRepositoryResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UpdateRepositoryService {

    Set<String> links = new HashSet<>();

    Set<String> packageLinks = new HashSet<>();

    @Autowired
    private RepoRepository repoRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public UpdateRepositoryResponse handleRequest(UpdateRepositoryRequest request) {
        UpdateRepositoryResponse updateRepositoryResponse = new UpdateRepositoryResponse();
        try {
            Repository repository = repoRepository.findById(request.getId()).orElse(null);
            if(repository == null)
                throw new Exception("invalid repository id.");

            startCrawling(repository.getUrl());

            List<String> urlFromDB = versionRepository.findAllUrl();
            updateRepositoryResponse.setPackageCountBefore(urlFromDB.size());

            for(String url : urlFromDB)
                if(packageLinks.contains(url))
                    packageLinks.remove(url);

            updateRepositoryResponse.setPackageCountNow(urlFromDB.size() + packageLinks.size());
            List<Set<String>> urlThreadSet = new ArrayList<>();
            for(int i = 0; i < 10; i++)
                urlThreadSet.add(new HashSet<>());
            int i = 0;
            for(String urlToUpdate : packageLinks) {
                int index = i % 10;
                urlThreadSet.get(index).add(urlToUpdate);
                i++;
            }

            for(Set<String> packageToUpdate : urlThreadSet)
                new Thread(new RepositoryUpdaterThread(packageToUpdate, repository, authorRepository)).start();

            updateRepositoryResponse.setStatus("repository update is in progress. Please check back later.");
        } catch (Exception e) {
            updateRepositoryResponse.setStatus("repository update failed..." + e);
        }
        return updateRepositoryResponse;
    }

    private void startCrawling(String url) throws Exception {
        if (!links.contains(url)) {
            if (links.add(url)) {
                System.out.println(url);

                if(url.contains(".tar.gz")) {
                    packageLinks.add(url);
                } else if(url.contains(".png") || url.contains(".jpg") || url.contains(".tgz") || url.contains(".zip") || url.contains(".hqx") || url.contains("Archive")
                        || url.contains(".rds")) {

                } else if(url.toLowerCase().contains(".html") || url.equalsIgnoreCase("http://ftp.iitm.ac.in/cran/src/contrib/")){
                    Document document = Jsoup.connect(url).get();
                    Elements linksOnPage = document.select("a[href]");

                    for (Element page : linksOnPage) {
                        String tempUrl = page.attr("abs:href");
                        startCrawling(tempUrl);
                    }
                }
            }
        }
    }
}