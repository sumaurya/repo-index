package com.lynk.project.repoindex.response.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAuthor {

    @JsonProperty
    private int id;

    @JsonProperty
    private int versionId;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    public ResponseAuthor(int id, int versionId, String name, String email) {
        this.id = id;
        this.versionId = versionId;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
