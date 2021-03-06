package edu.galileo.android.androidtwitterclient.main.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

/**
 * Created by nacheteam on 17/06/16.
 */
public class MainSectionPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private Fragment[] fragments;

    public MainSectionPagerAdapter(FragmentManager fm, String[] titles, Fragment[] fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles[position];
    }

    @Override
    public int getCount()
    {
        return this.fragments.length;
    }

}
