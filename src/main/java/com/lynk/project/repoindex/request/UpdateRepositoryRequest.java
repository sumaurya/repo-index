package com.lynk.project.repoindex.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRepositoryRequest {

    @JsonProperty
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
