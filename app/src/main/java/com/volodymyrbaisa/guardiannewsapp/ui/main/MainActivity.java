package com.volodymyrbaisa.guardiannewsapp.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.volodymyrbaisa.guardiannewsapp.R;
import com.volodymyrbaisa.guardiannewsapp.service.APIService;
import com.volodymyrbaisa.guardiannewsapp.ui.pref.PrefActivity;
import com.volodymyrbaisa.guardiannewsapp.util.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        OnFragmentInteractionListener, SharedPreferences.OnSharedPreferenceChangeListener {
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.drawer)
    protected DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    protected NavigationView mNavigationView;

    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private int mPageSize;
    private String mApiKey;

    @Inject
    protected MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        loadPref();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        loadPref();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mMainFragment, R.id.fragment_container);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainFragment.setTitle(getString(R.string.world));
        mMainFragment.setRequest(new APIService.Builder().setSection(getString(R.string.world))
                .setPageSize(mPageSize)
                .setApiKey(mApiKey).build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.pref) {
            ActivityUtils.launchActivity(this, PrefActivity.class);

            return true;
        }
        return mActionBarDrawerToggle != null && mActionBarDrawerToggle.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        APIService apiService;
        String title = item.getTitle().toString();
        apiService = new APIService.Builder().setSection(title)
                .setPageSize(mPageSize)
                .setApiKey(mApiKey).build();

        mMainFragment.setTitle(title);
        mMainFragment.setRequest(apiService);

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void loadPref() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPrefs.registerOnSharedPreferenceChangeListener(this);

        mPageSize = sharedPrefs.getInt(
                getString(R.string.number_picker_preference_key),
                Integer.parseInt(getString(R.string.number_picker_preference_default_value)));
        mApiKey = sharedPrefs.getString(getString(R.string.edit_text_preference_key),
                getString(R.string.edit_text_preference_default_value));
    }
}