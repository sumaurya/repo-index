package com.lynk.project.repoindex.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchByProjectTitlePatternRequest {

    @JsonProperty
    private String patternString;

    public String getPatternString() {
        return patternString;
    }

    public void setPatternString(String patternString) {
        this.patternString = patternString;
    }
}
