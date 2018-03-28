package com.volodymyrbaisa.guardiannewsapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Bios on 1/22/2018.
 */

public class ActivityUtils {
    private ActivityUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                  @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

    public static void addFragmentToActivity(@NonNull android.app.FragmentManager fragmentManager,
                                             @NonNull android.app.Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

    public static void openWebPage(Context context, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(i);
    }

    public static void launchActivity(@NonNull Activity activity, Class clasz) {
        Intent i = new Intent(activity, clasz);
        activity.startActivity(i);
    }
}
