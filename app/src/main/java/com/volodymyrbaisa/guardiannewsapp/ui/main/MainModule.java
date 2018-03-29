package com.volodymyrbaisa.guardiannewsapp.ui.main;

import com.volodymyrbaisa.guardiannewsapp.di.scope.ActivityScoped;
import com.volodymyrbaisa.guardiannewsapp.di.scope.FragmentScoped;
import com.volodymyrbaisa.guardiannewsapp.ui.main.adapter.AdapterModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Bios on 3/4/2018.
 * This is a Dagger module.
 */
@Module
public abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = {TaskModule.class, AdapterModule.class})
    abstract MainFragment mainFragment();

    @ActivityScoped
    @Binds
    abstract MainContact.Presenter fragmentPresenter(MainPresenter presenter);
}
