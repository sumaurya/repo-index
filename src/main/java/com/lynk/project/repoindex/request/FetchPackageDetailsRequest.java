package com.lynk.project.repoindex.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchPackageDetailsRequest {

    @JsonProperty
    private int repositoryId;

    public int getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(int repositoryId) {
        this.repositoryId = repositoryId;
    }
}
