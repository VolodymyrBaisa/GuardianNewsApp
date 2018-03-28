package com.volodymyrbaisa.guardiannewsapp.ui.main.adapter;

import com.volodymyrbaisa.guardiannewsapp.data.source.DownloadImageTask;
import com.volodymyrbaisa.guardiannewsapp.di.scope.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bios on 3/12/2018.
 */
@Module
public abstract class AdapterModule {
    @FragmentScoped
    @Provides
    static RecyclerAdapter getRecyclerAdapter(DownloadImageTask downloadImageTask) {
        return new RecyclerAdapter(downloadImageTask);
    }
}
