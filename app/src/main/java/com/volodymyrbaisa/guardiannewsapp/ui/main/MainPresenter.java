package com.volodymyrbaisa.guardiannewsapp.ui.main;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.volodymyrbaisa.guardiannewsapp.data.Article;
import com.volodymyrbaisa.guardiannewsapp.data.source.SourceTaskLoader;

import javax.inject.Inject;

/**
 * Created by Bios on 3/4/2018.
 */

public class MainPresenter implements MainContact.Presenter, LoaderManager.LoaderCallbacks<Article> {
    private static final int TASK_QUERY = 0;
    private static final String TASK_QUERY_KEY = "task_key";

    private MainContact.View mView;
    @Inject
    protected SourceTaskLoader mSourceTaskLoader;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void takeView(MainContact.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public Loader<Article> onCreateLoader(int id, Bundle args) {
        mSourceTaskLoader.setUrl(args.getString(TASK_QUERY_KEY));
        mSourceTaskLoader.forceLoad();
        return mSourceTaskLoader;
    }

    @Override
    public void onLoadFinished(Loader<Article> loader, Article data) {
        if(data != null) {
            mView.setArticleData(data);
            mView.showLoadingProgress(false);
        } else {
            mView.showLoadingProgress(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<Article> loader) {
        mView.showLoadingProgress(true);
    }

    @Override
    public void executeRequest(String url) {
        if (url == null || url.isEmpty()) {
            mView.showLoadingProgress(true);
            return;
        }

        mView.showLoadingProgress(true);
        Bundle bundle = new Bundle();
        bundle.putString(TASK_QUERY_KEY, url);
        mView.initLoader(TASK_QUERY, bundle, this);
    }
}