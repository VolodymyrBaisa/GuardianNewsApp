package com.volodymyrbaisa.guardiannewsapp.data.source;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.volodymyrbaisa.guardiannewsapp.data.Article;
import com.volodymyrbaisa.guardiannewsapp.util.GsonUtils;
import com.volodymyrbaisa.guardiannewsapp.util.HttpUtils;
import com.volodymyrbaisa.guardiannewsapp.util.StreamUtils;
import com.volodymyrbaisa.guardiannewsapp.util.UrlUtils;

import java.io.InputStream;

/**
 * Created by Bios on 3/4/2018.
 */

public class SourceTaskLoader extends AsyncTaskLoader<Article> {
    private String mUrl;
    private HttpUtils mHttpUtils;
    private GsonUtils<Article> mGsonUtils;

    public SourceTaskLoader(Context context, HttpUtils httpUtils, GsonUtils<Article> gsonUtils) {
        super(context);
        mHttpUtils = httpUtils;
        mGsonUtils = gsonUtils;
    }

    @Override
    public Article loadInBackground() {
        InputStream stream = mHttpUtils.makeHttpRequest(UrlUtils.createUrl(mUrl));
        String json = StreamUtils.readFromStream(stream);
        mHttpUtils.close();
        return mGsonUtils.extractFeatureFromJson(json, Article.class);
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
