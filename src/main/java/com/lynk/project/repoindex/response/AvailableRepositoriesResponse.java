package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.pojo.Repository;

import java.util.List;

public class AvailableRepositoriesResponse extends AbstractResponse{

    @JsonProperty
    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
