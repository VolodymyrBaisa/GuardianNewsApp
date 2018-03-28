package com.volodymyrbaisa.guardiannewsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bios on 3/7/2018.
 */

public class Tag {
    @SerializedName("webTitle")
    private String mContributor;

    public Tag(String contributor) {
        this.mContributor = contributor;
    }

    public String getContributor() {
        return mContributor;
    }
}
