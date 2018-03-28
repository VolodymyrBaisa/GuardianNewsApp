package com.volodymyrbaisa.guardiannewsapp.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Bios on 3/4/2018.
 */

@Module
public abstract class ApplicationModule {
    @Binds
    abstract Context bindContext(Application application);
}
