package com.volodymyrbaisa.guardiannewsapp.ui.main;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;

import com.volodymyrbaisa.guardiannewsapp.base.BasePresenter;
import com.volodymyrbaisa.guardiannewsapp.base.BaseView;
import com.volodymyrbaisa.guardiannewsapp.data.Article;

/**
 * Created by Bios on 3/4/2018.
 */

public interface MainContact {
    interface View extends BaseView<Presenter> {
        void setArticleData(Article article);

        void showLoadingProgress(boolean show);

        void initLoader(int id, Bundle args,
                        LoaderManager.LoaderCallbacks callback);
    }

    interface Presenter extends BasePresenter<View> {
        void executeRequest(String url);
    }
}
