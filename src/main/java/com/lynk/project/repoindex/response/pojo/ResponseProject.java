package com.lynk.project.repoindex.response.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseProject {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private int repositoryId;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    public ResponseProject(Integer id, int repositoryId, String title, String description) {
        this.id = id;
        this.repositoryId = repositoryId;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(int repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
