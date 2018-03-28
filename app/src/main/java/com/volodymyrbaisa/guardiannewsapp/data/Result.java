package com.volodymyrbaisa.guardiannewsapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bios on 3/7/2018.
 */

public class Result {
    @SerializedName("webTitle")
    private String mTitle;
    @SerializedName("sectionName")
    private String mSectionName;
    @SerializedName("webPublicationDate")
    private String mPublicationDate;
    @SerializedName("tags")
    private List<Tag> mTags = null;
    @SerializedName("fields")
    private Fields mFields;

    public Result(String title, String sectionName, String publicationDate, List<Tag> tags, Fields fields) {
        this.mTitle = title;
        this.mSectionName = sectionName;
        this.mPublicationDate = publicationDate;
        this.mTags = tags;
        this.mFields = fields;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public List<Tag> getTags() {
        return mTags;
    }

    public Fields getFields() {
        return mFields;
    }
}
