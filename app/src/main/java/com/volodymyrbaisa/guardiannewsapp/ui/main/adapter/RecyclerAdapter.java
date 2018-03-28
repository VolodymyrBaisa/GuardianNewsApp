package com.volodymyrbaisa.guardiannewsapp.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.volodymyrbaisa.guardiannewsapp.R;
import com.volodymyrbaisa.guardiannewsapp.data.Article;
import com.volodymyrbaisa.guardiannewsapp.data.Result;
import com.volodymyrbaisa.guardiannewsapp.data.Tag;
import com.volodymyrbaisa.guardiannewsapp.data.source.DownloadImageTask;
import com.volodymyrbaisa.guardiannewsapp.util.TimeUtils;
import com.volodymyrbaisa.guardiannewsapp.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Bios on 3/4/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Result> results = new ArrayList<>();

    protected DownloadImageTask mDownloadImageTask;
    private OnItemClickListener mListener;

    @Inject
    public RecyclerAdapter(DownloadImageTask downloadImageTask) {
        mDownloadImageTask = downloadImageTask;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = results.get(position);
        holder.mTitle.setText(result.getTitle());
        holder.mPublicationDate.setText(TimeUtils.formatPublishTime(result.getPublicationDate()));
        holder.mSectionName.setText(result.getSectionName());

        for (Tag tag : result.getTags()) {
            holder.mTagsContributor.setText(tag.getContributor());
        }

        String imageUrl = result.getFields().getThumbnail();
        if (imageUrl != null) {
            mDownloadImageTask.setPlaceholder(R.drawable.placeholder);
            mDownloadImageTask.downloadImage(holder.mThumbnail, UrlUtils.createUrl(imageUrl));
        } else {
            holder.mThumbnail.setImageResource(R.drawable.placeholder);
        }
        holder.bind(result.getFields(), mListener);
    }

    @Override
    public int getItemCount() {
            if (results != null) return results.size();
        return 0;
    }

    public void setArticleData(Article response) {
        if(response != null) {
            results.addAll(response.getResponse().getResults());
            notifyDataSetChanged();
        }
    }

    public void clear() {
        results.clear();
    }

    public void setOnClickItemListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
