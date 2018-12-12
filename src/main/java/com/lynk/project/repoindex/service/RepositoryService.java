package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.repository.RepoRepository;
import com.lynk.project.repoindex.request.AddRepositoryRequest;
import com.lynk.project.repoindex.response.AddRepositoryResponse;
import com.lynk.project.repoindex.response.AvailableRepositoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryService {

    @Autowired
    private RepoRepository repoRepository;

    public AvailableRepositoriesResponse handeleAvailableRepositories() {
        AvailableRepositoriesResponse availableRepositoriesResponse = new AvailableRepositoriesResponse();
        try {
            List<Repository> repositories = new ArrayList<>();
            repoRepository.findAll().forEach(repositories::add);
            availableRepositoriesResponse.setRepoRepositories(repositories);
            availableRepositoriesResponse.setStatus("Success");
        } catch (Exception e) {
            availableRepositoriesResponse.setStatus("Failure");
        }
        return availableRepositoriesResponse;
    }

    public AddRepositoryResponse handleAddRepository(AddRepositoryRequest request) {
        AddRepositoryResponse addRepositoryResponse = new AddRepositoryResponse();
        try {
            Repository repository = new Repository();
            repository.setName(request.getName());
            repository.setUrl(request.getUrl());
            repoRepository.save(repository);
            addRepositoryResponse.setStatus("Success");
        } catch (Exception e) {
            addRepositoryResponse.setStatus("Failure");
        }
        return addRepositoryResponse;
    }
}
