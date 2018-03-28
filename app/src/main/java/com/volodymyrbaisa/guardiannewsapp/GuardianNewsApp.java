package com.volodymyrbaisa.guardiannewsapp;

import com.volodymyrbaisa.guardiannewsapp.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Bios on 3/4/2018.
 */

public class GuardianNewsApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
