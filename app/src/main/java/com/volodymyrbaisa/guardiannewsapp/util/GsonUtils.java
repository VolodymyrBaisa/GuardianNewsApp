package com.volodymyrbaisa.guardiannewsapp.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by Bios on 3/5/2018.
 */

public class GsonUtils<T> {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();

    public T extractFeatureFromJson(String json, Class<T> classOfT) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            return new Gson().fromJson(json, classOfT);
        } catch (JsonSyntaxException e) {
            Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
        }
        return null;
    }
}
