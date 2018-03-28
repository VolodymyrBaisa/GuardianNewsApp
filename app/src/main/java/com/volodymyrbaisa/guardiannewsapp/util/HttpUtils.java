package com.volodymyrbaisa.guardiannewsapp.util;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Bios on 3/4/2018.
 */

public class HttpUtils {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();
    private HttpURLConnection urlConnection = null;
    private InputStream inputStream = null;


    public InputStream makeHttpRequest(URL url) {
        if (url == null) {
            return null;
        }

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem return input stream.", e);
        }
        return inputStream;
    }

    public void close(){
        try {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e){
            Log.e(LOG_TAG, "Problem close stream or disconnect connection.", e);
        }
    }
}
