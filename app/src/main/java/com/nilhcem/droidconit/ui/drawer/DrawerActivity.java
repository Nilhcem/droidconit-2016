package com.nilhcem.droidconit.ui.drawer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nilhcem.droidconit.R;
import com.nilhcem.droidconit.ui.BaseActivity;

import butterknife.Bind;

public class DrawerActivity extends BaseActivity<DrawerPresenter> implements DrawerActivityView {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.drawer_layout) DrawerLayout drawer;
    @Bind(R.id.drawer_navigation) NavigationView navigationView;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected DrawerPresenter newPresenter() {
        return new DrawerPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            presenter.onNavigationItemSelected(item.getItemId());
            return true;
        });
    }

    @Override
    protected void onDestroy() {
        drawer.removeDrawerListener(actionBarDrawerToggle);
        super.onDestroy();
    }

    @Override
    public void updateToolbarTitle(@StringRes int resId) {
        getSupportActionBar().setTitle(resId);
    }

    @Override
    public boolean isNavigationDrawerOpen() {
        return drawer.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void closeNavigationDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.drawer_fragments_container, fragment)
                .commit();
    }

    @Override
    public void selectDrawerMenuItem(@IdRes int id) {
        navigationView.setCheckedItem(id);
    }

    @Override
    public void hideTabLayout() {
        tabLayout.setVisibility(View.GONE);
    }

    public void setupTabLayoutWithViewPager(ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.VISIBLE);
    }
}
