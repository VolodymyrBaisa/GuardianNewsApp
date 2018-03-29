package com.volodymyrbaisa.guardiannewsapp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.volodymyrbaisa.guardiannewsapp.R;
import com.volodymyrbaisa.guardiannewsapp.data.Article;
import com.volodymyrbaisa.guardiannewsapp.data.Fields;
import com.volodymyrbaisa.guardiannewsapp.service.APIService;
import com.volodymyrbaisa.guardiannewsapp.ui.main.adapter.OnItemClickListener;
import com.volodymyrbaisa.guardiannewsapp.ui.main.adapter.RecyclerAdapter;
import com.volodymyrbaisa.guardiannewsapp.util.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * Created by Bios on 3/4/2018.
 */

public class MainFragment extends DaggerFragment implements MainContact.View {
    private static final String API_SERVICE_KEY = "api_service_key";

    @BindView(R.id.article_item_list)
    protected RecyclerView mArticleItemList;
    @BindView(R.id.progress_bar)
    protected ProgressBar mProgress;
    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    private APIService mApiService;

    @Inject
    protected MainContact.Presenter mPresenter;
    @Inject
    protected RecyclerAdapter mRecyclerAdapter;

    private OnFragmentInteractionListener mListener;

    @Inject
    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        mPresenter.takeView(this);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(API_SERVICE_KEY, mApiService);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mApiService = (APIService)savedInstanceState.getSerializable(API_SERVICE_KEY);
        }
        showArticleItemList();
        setSwipeRefreshLayout();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void showArticleItemList() {
        mArticleItemList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mArticleItemList.setLayoutManager(linearLayoutManager);
        mRecyclerAdapter.setOnClickItemListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Fields item) {
                ActivityUtils.openWebPage(getContext(), item.getShortUrl());
            }
        });
        mArticleItemList.setAdapter(mRecyclerAdapter);
        mArticleItemList.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                if(mApiService != null) {
                    mApiService.setPage(mApiService.getPage() + 1);
                    mPresenter.executeRequest(mApiService.toString());
                }
            }
        });
    }

    private void setSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                clear();
                mPresenter.executeRequest(mApiService.toString());
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public void setArticleData(Article article) {
        mRecyclerAdapter.setArticleData(article);
    }

    @Override
    public void showLoadingProgress(boolean show) {
        if (show) mProgress.setVisibility(View.VISIBLE);
        else mProgress.setVisibility(View.GONE);
    }

    public void setRequest(APIService apiService) {
        mApiService = apiService;
        clear();
        mPresenter.executeRequest(apiService.toString());
    }

    public void setTitle(String title) {
        if (mListener != null) {
            mListener.onFragmentInteraction(title);
        }
    }

    private void clear(){
        if(mArticleItemList != null) {
            mArticleItemList.scrollToPosition(0);
        }
        mApiService.setPage(1);
        mRecyclerAdapter.clear();
    }

    @Override
    public void initLoader(int id, Bundle args,
                           LoaderManager.LoaderCallbacks callback) {
        getLoaderManager().destroyLoader(id);
        getLoaderManager().initLoader(id, args, callback);
    }
}