package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.response.pojo.ResponseVersion;

import java.util.List;

public class FetchVersionsForPackageResponse  extends AbstractResponse {

    @JsonProperty
    private List<ResponseVersion> versions;

    public List<ResponseVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ResponseVersion> versions) {
        this.versions = versions;
    }
}
