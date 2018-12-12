package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.pojo.Repository;

import java.util.List;

public class AvailableRepositoriesResponse extends AbstractResponse{

    @JsonProperty
    private List<Repository> repoRepositories;

    public List<Repository> getRepoRepositories() {
        return repoRepositories;
    }

    public void setRepoRepositories(List<Repository> repoRepositories) {
        this.repoRepositories = repoRepositories;
    }
}
