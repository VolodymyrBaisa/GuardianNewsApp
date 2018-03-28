package com.volodymyrbaisa.guardiannewsapp.di.module;

import com.volodymyrbaisa.guardiannewsapp.di.scope.ActivityScoped;
import com.volodymyrbaisa.guardiannewsapp.ui.main.MainActivity;
import com.volodymyrbaisa.guardiannewsapp.ui.main.MainModule;
import com.volodymyrbaisa.guardiannewsapp.ui.pref.PrefActivity;
import com.volodymyrbaisa.guardiannewsapp.ui.pref.PrefModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Bios on 3/4/2018.
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {PrefModule.class})
    abstract PrefActivity prefActivity();
}
