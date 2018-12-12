package com.lynk.project.repoindex.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="author")
public class Author {

    @JsonProperty
    private int id;

    @JsonProperty
    private Version version;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "author_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="version_id")
    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
