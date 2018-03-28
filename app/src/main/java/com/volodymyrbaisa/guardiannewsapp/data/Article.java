package com.volodymyrbaisa.guardiannewsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bios on 3/14/2018.
 */

public class Article {
    @SerializedName("response")
    private Response mResponse;

    public Article(Response response) {
        this.mResponse = response;
    }

    public Response getResponse() {
        return mResponse;
    }
}
