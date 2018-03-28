package com.volodymyrbaisa.guardiannewsapp.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.volodymyrbaisa.guardiannewsapp.R;
import com.volodymyrbaisa.guardiannewsapp.data.Fields;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bios on 3/4/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.thumbnail)
    protected ImageView mThumbnail;

    @BindView(R.id.section_name)
    protected TextView mSectionName;

    @BindView(R.id.publication_date)
    protected TextView mPublicationDate;

    @BindView(R.id.title)
    protected TextView mTitle;

    @BindView(R.id.tags_contributor)
    protected TextView mTagsContributor;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Fields item, final OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }
}
