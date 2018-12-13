package com.lynk.project.repoindex.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRepositoryResponse extends AbstractResponse{

    @JsonProperty
    private int packageCountBefore;

    @JsonProperty
    private int packageCountNow;

    public int getPackageCountBefore() {
        return packageCountBefore;
    }

    public void setPackageCountBefore(int packageCountBefore) {
        this.packageCountBefore = packageCountBefore;
    }

    public int getPackageCountNow() {
        return packageCountNow;
    }

    public void setPackageCountNow(int packageCountNow) {
        this.packageCountNow = packageCountNow;
    }
}
