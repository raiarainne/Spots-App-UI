package com.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.myapplication.Fragment.SartscreenFragment;
import com.myapplication.Fragment.Start1Fragment;
import com.myapplication.Fragment.Start2Fragment;
import com.myapplication.Fragment.StartrealscreenFragment;
import com.myapplication.Fragment.StartrealssubFragment;


public class MainViewPagerAdapter extends FragmentStatePagerAdapter{

    private static int NUM_ITEMS = 2;

    public MainViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return StartrealscreenFragment.newInstance(0);
            case 1:
                return SartscreenFragment.newInstance(1);


            default:
                return null;
        }
    }

}