package com.lynk.project.repoindex.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchPackageDetailsRequest {

    @JsonProperty
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
