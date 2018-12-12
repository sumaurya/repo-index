package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.pojo.Author;
import com.lynk.project.repoindex.pojo.Project;
import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.pojo.Version;

import java.util.List;
import java.util.Map;

public class FetchPackageDetailsResponse extends AbstractResponse {

    @JsonProperty
    private Repository repository;

    @JsonProperty
    private Map<Project, Map<Version, List<Author>>> response;

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Map<Project, Map<Version, List<Author>>> getResponse() {
        return response;
    }

    public void setResponse(Map<Project, Map<Version, List<Author>>> response) {
        this.response = response;
    }
}
