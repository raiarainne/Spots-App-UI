package com.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myapplication.Fragment.ContactoverviewFragment;
import com.myapplication.Fragment.MainFragment;
import com.myapplication.Fragment.SartscreenFragment;
import com.myapplication.Fragment.StartrealscreenFragment;



public class MainViewPager1Adapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public MainViewPager1Adapter(FragmentManager fragmentManager) {
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
                return ContactoverviewFragment.newInstance(0);
            case 1:
                return MainFragment.newInstance(1);


            default:
                return null;
        }
    }

}