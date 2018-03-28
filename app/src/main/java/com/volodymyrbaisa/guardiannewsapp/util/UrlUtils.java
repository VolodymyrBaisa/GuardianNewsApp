package com.volodymyrbaisa.guardiannewsapp.util;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bios on 3/6/2018.
 */

public class UrlUtils {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();

    private UrlUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }
}
