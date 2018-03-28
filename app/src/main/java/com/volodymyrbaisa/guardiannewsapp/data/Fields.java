package com.volodymyrbaisa.guardiannewsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bios on 3/7/2018.
 */

public class Fields {
    @SerializedName("thumbnail")
    private String mThumbnail;
    @SerializedName("shortUrl")
    private String mShortUrl;

    public Fields(String thumbnail, String shortUrl) {
        this.mThumbnail = thumbnail;
        this.mShortUrl = shortUrl;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getShortUrl() {
        return mShortUrl;
    }
}
