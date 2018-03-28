package com.volodymyrbaisa.guardiannewsapp.di.component;

import android.app.Application;

import com.volodymyrbaisa.guardiannewsapp.GuardianNewsApp;
import com.volodymyrbaisa.guardiannewsapp.di.module.ActivityBindingModule;
import com.volodymyrbaisa.guardiannewsapp.di.module.ApplicationModule;
import com.volodymyrbaisa.guardiannewsapp.di.module.TaskModule;
import com.volodymyrbaisa.guardiannewsapp.di.module.UtilsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Bios on 3/4/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class,
        UtilsModule.class, TaskModule.class})
public interface AppComponent extends AndroidInjector<GuardianNewsApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
