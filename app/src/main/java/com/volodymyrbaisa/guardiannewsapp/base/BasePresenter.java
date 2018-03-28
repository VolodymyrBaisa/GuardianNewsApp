package com.volodymyrbaisa.guardiannewsapp.base;

/**
 * Created by Bios on 3/4/2018.
 */

public interface BasePresenter<T> {
    void takeView(T view);

    void dropView();
}
