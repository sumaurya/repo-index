package com.lynk.project.repoindex.response.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseVersion {

    @JsonProperty
    private int id;

    @JsonProperty
    private int projectId;

    @JsonProperty
    private String version;

    @JsonProperty
    private String liscence;

    @JsonProperty
    private String dependsOn;

    @JsonProperty
    private String url;

    public ResponseVersion(int id, int projectId, String version, String liscence, String dependsOn, String url) {
        this.id = id;
        this.projectId = projectId;
        this.version = version;
        this.liscence = liscence;
        this.dependsOn = dependsOn;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLiscence() {
        return liscence;
    }

    public void setLiscence(String liscence) {
        this.liscence = liscence;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependsOn) {
        this.dependsOn = dependsOn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}