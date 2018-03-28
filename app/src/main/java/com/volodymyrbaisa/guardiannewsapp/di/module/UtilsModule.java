package com.volodymyrbaisa.guardiannewsapp.di.module;

import com.volodymyrbaisa.guardiannewsapp.util.GsonUtils;
import com.volodymyrbaisa.guardiannewsapp.util.HttpUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bios on 3/12/2018.
 */

@Module
public abstract class UtilsModule {
    @Provides
    @Singleton
    public static HttpUtils provideHttpUtils() {
        return new HttpUtils();
    }

    @Provides
    @Singleton
    public static GsonUtils provideGsonUtils(){
        return new GsonUtils();
    }
}
