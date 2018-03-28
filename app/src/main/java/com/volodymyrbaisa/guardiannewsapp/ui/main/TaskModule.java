package com.volodymyrbaisa.guardiannewsapp.ui.main;

import com.volodymyrbaisa.guardiannewsapp.data.source.DownloadImageTask;
import com.volodymyrbaisa.guardiannewsapp.di.scope.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Volodymyr on 3/16/2018.
 */

@Module
public class TaskModule {

    @FragmentScoped
    @Provides
    public DownloadImageTask provideDownloadImageTask() {
        return new DownloadImageTask();
    }
}
