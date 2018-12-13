package com.lynk.project.repoindex.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="version")
public class Version {

    @JsonProperty
    private int id;

    @JsonProperty
    private Project project;

    @JsonProperty
    private String version;

    @JsonProperty
    private String liscence;

    @JsonProperty
    private String dependsOn;

    @JsonProperty
    private String url;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "version_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="project_id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Column(name = "liscence")
    public String getLiscence() {
        return liscence;
    }

    public void setLiscence(String liscence) {
        this.liscence = liscence;
    }

    @Column(name = "dependsOn")
    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependencyJson) {
        this.dependsOn = dependencyJson;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}