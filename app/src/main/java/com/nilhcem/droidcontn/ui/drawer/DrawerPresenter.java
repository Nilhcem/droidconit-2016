package com.nilhcem.droidcontn.ui.drawer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import com.nilhcem.droidcontn.R;
import com.nilhcem.droidcontn.ui.BaseActivityPresenter;
import com.nilhcem.droidcontn.ui.schedule.ScheduleFragment;
import com.nilhcem.droidcontn.ui.settings.SettingsFragment;
import com.nilhcem.droidcontn.ui.speakers.SpeakersFragment;
import com.nilhcem.droidcontn.ui.venue.VenueFragment;

import icepick.State;

public class DrawerPresenter extends BaseActivityPresenter<DrawerActivityView> {

    public DrawerPresenter(DrawerActivityView view) {
        super(view);
    }

    @State @StringRes int mToolbarTitle;

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            onNavigationItemSelected(R.id.drawer_nav_schedule);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mView.updateToolbarTitle(mToolbarTitle);
    }

    @Override
    public void onNavigationItemSelected(@IdRes int itemId) {
        switch (itemId) {
            case R.id.drawer_nav_schedule:
                mView.showFragment(new ScheduleFragment());
                mToolbarTitle = R.string.drawer_nav_schedule;
                break;
            case R.id.drawer_nav_speakers:
                mView.showFragment(new SpeakersFragment());
                mToolbarTitle = R.string.drawer_nav_speakers;
                break;
            case R.id.drawer_nav_venue:
                mView.showFragment(new VenueFragment());
                mToolbarTitle = R.string.drawer_nav_venue;
                break;
            case R.id.drawer_nav_settings:
                mView.showFragment(new SettingsFragment());
                mToolbarTitle = R.string.drawer_nav_settings;
                break;
            default:
                throw new IllegalArgumentException();
        }
        mView.updateToolbarTitle(mToolbarTitle);
        mView.closeNavigationDrawer();
    }

    @Override
    public boolean onBackPressed() {
        if (mView.isNavigationDrawerOpen()) {
            mView.closeNavigationDrawer();
            return true;
        }
        return false;
    }
}