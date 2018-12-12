package com.lynk.project.repoindex.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRepositoryRequest {

    @JsonProperty
    private String name;

    @JsonProperty
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
