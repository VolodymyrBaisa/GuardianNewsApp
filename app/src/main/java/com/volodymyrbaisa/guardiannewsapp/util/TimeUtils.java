package com.volodymyrbaisa.guardiannewsapp.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.annotation.Nonnull;

/**
 * Created by Volodymyr on 3/17/2018.
 */

public class TimeUtils {
    public static final String LOG_TAG = HttpUtils.class.getSimpleName();

    private TimeUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static String formatPublishTime(@Nonnull String time) {
        if (time.isEmpty()) {
            return "N.A.";
        }

        SimpleDateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        SimpleDateFormat newTime = new SimpleDateFormat("yyyy.MM.dd / HH:mm", Locale.US);

        try {
            time = newTime.format(currentTime.parse(time));
        } catch (ParseException e) {
            time = "N.A.";
            Log.e(LOG_TAG, "Error while parsing the published date", e);
        }
        return time;
    }

    public static String getCurentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance();
        return sdf.format(calendar.getTime());
    }
}
