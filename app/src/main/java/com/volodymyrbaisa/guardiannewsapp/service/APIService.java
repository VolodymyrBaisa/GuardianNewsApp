package com.volodymyrbaisa.guardiannewsapp.service;

import java.io.Serializable;

/**
 * Created by Volodymyr on 3/18/2018.
 */

public class APIService implements Serializable {
    public static final String URL_ENDPOINT = "http://content.guardianapis.com/search?q=";
    public static final String URL_TAGS = "&tags=news";
    public static final String URL_PAGE = "&page=";
    public static final String URL_PAGE_SIZE = "&page-size=";
    public static final String URL_END = "&use-date=published&order-by=newest&show-tags=contributor&show-fields=thumbnail,short-url";
    public static final String URL_API_KEY = "&api-key=";
    public static final String URL_SECTION = "&section=";

    private int mPage = 1, mPageSize = 10;
    private String mQuery, mSection, mApiKey;

    public APIService(int page, int pageSize, String query, String section, String apiKey) {
        this.mPage = page;
        this.mPageSize = pageSize;
        this.mQuery = query;
        this.mSection = section;
        this.mApiKey = apiKey;
    }

    public int getPage() {
        return mPage;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public String getQuery() {
        return mQuery;
    }

    public String getSection() {
        return mSection;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public static class Builder {
        private int mPage = 1, mPageSize = 10;
        private String mQuery = "", mSection = "", mApiKey = "";

        public Builder setQuery(String query) {
            mQuery = query;
            return this;
        }

        public Builder setPage(int page) {
            mPage = page;
            return this;
        }

        public Builder setPageSize(int pageSize){
            mPageSize = pageSize;
            return this;
        }

        public Builder setSection(String section) {
            mSection = section;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            mApiKey = apiKey;
            return this;
        }

        public APIService build() {
            return new APIService(mPage, mPageSize, mQuery, mSection, mApiKey);
        }
    }

    private APIService() {
    }

    @Override
    public String toString() {
        return URL_ENDPOINT + (mQuery.isEmpty() ? "" : mQuery)
                + (mSection.isEmpty() ? "" : URL_SECTION + mSection.toLowerCase())
                + (mPage == 0 ? "" : URL_PAGE + mPage)
                + URL_PAGE_SIZE + mPageSize
                + URL_TAGS
                + URL_END
                + URL_API_KEY + mApiKey;
    }
}
