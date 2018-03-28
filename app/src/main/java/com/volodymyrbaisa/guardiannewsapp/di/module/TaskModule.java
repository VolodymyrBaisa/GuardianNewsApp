package com.volodymyrbaisa.guardiannewsapp.di.module;

import android.app.Application;

import com.volodymyrbaisa.guardiannewsapp.data.source.SourceTaskLoader;
import com.volodymyrbaisa.guardiannewsapp.util.GsonUtils;
import com.volodymyrbaisa.guardiannewsapp.util.HttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bios on 3/11/2018.
 */

@Module
public abstract class TaskModule {
    @Provides
    @Singleton
    public static SourceTaskLoader provideTaskLoader(Application application, HttpUtils httpUtils, GsonUtils gsonUtils) {
        return new SourceTaskLoader(application, httpUtils, gsonUtils);
    }
}
