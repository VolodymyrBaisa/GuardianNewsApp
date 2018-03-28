package com.volodymyrbaisa.guardiannewsapp.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by Bios on 3/5/2018.
 */

public class StreamUtils {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();

    private StreamUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static String readFromStream(InputStream inputStream) {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e){
                Log.e(LOG_TAG, "Problem read stream.", e);
            }
        }
        return output.toString();
    }
}
