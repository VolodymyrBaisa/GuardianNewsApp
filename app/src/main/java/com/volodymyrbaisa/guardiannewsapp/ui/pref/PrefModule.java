package com.volodymyrbaisa.guardiannewsapp.ui.pref;

import com.volodymyrbaisa.guardiannewsapp.di.scope.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Volodymyr on 3/25/2018.
 * This is a Dagger module.
 */

@Module
public abstract class PrefModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract PrefFragment prefFragment();
}
