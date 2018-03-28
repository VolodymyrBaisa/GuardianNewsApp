package com.volodymyrbaisa.guardiannewsapp.ui.pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.volodymyrbaisa.guardiannewsapp.R;
import com.volodymyrbaisa.guardiannewsapp.custom.NumberPickerPreference;

import javax.inject.Inject;

/**
 * Created by Volodymyr on 3/23/2018.
 */

public class PrefFragment extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    @Inject
    public PrefFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Preference apiKey = findPreference(getString(R.string.edit_text_preference_key));
        bindPreferenceSummaryToValue(apiKey);

        Preference pageSize = findPreference(getString(R.string.number_picker_preference_key));
        bindPreferenceSummaryToValue(pageSize);
    }

    private void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());

        if (preference instanceof EditTextPreference) {
            String preferenceString = preferences.getString(preference.getKey(), getString(R.string.edit_text_preference_default_value));
            onPreferenceChange(preference, preferenceString);
        }

        if (preference instanceof NumberPickerPreference) {
            int defaultValue = Integer.parseInt(getString(R.string.number_picker_preference_default_value));
            int preferencesInt = preferences.getInt(preference.getKey(), defaultValue);
            onPreferenceChange(preference, preferencesInt);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String stringValue = newValue.toString();
        preference.setSummary(stringValue);
        return true;
    }
}
