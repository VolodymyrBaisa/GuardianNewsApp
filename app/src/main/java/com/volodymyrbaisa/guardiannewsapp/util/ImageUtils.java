package com.volodymyrbaisa.guardiannewsapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Bios on 3/13/2018.
 */

public class ImageUtils {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();

    private ImageUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static Bitmap getBitmap(URL url) {
        try {
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem decoding into existing bitmap.", e);
        }
        return null;
    }
}
