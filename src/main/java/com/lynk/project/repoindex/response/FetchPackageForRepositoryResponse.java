package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.response.pojo.ResponseProject;

import java.util.List;

public class FetchPackageForRepositoryResponse extends AbstractResponse {

    @JsonProperty
    private List<ResponseProject> projects;

    public List<ResponseProject> getProjects() {
        return projects;
    }

    public void setProjects(List<ResponseProject> projects) {
        this.projects = projects;
    }

}
