package com.volodymyrbaisa.guardiannewsapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bios on 3/7/2018.
 */

public class Response {
    @SerializedName("pageSize")
    private Integer mPageSize;
    @SerializedName("currentPage")
    private Integer mCurrentPage;
    @SerializedName("results")
    private List<Result> mResults;

    public Response(Integer pageSize, Integer currentPage, List<Result> results) {
        this.mPageSize = pageSize;
        this.mCurrentPage = currentPage;
        this.mResults = results;
    }

    public Integer getPageSize() {
        return mPageSize;
    }

    public Integer getCurrentPage() {
        return mCurrentPage;
    }

    public List<Result> getResults() {
        return mResults;
    }
}
