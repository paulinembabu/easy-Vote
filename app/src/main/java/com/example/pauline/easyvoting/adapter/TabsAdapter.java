package com.example.pauline.easyvoting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by pauline on 4/18/17.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> titles;
    public TabsAdapter(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;


    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
