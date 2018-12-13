package com.lynk.project.repoindex.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private Repository repository;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @ManyToOne(cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    @JoinColumn(name="repository_id")
    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "project_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
