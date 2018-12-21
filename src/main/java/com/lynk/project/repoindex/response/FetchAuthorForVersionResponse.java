package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lynk.project.repoindex.response.pojo.ResponseAuthor;

import java.util.List;

public class FetchAuthorForVersionResponse extends AbstractResponse  {

    @JsonProperty
    private List<ResponseAuthor> authors;

    public List<ResponseAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<ResponseAuthor> authors) {
        this.authors = authors;
    }
}
