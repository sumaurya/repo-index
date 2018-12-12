package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractResponse {

    @JsonProperty
    protected String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
