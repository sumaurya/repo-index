package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.pojo.Project;

import java.util.List;

public class FetchByProjectTitlePatternResponse extends AbstractResponse{

    @JsonProperty
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
