package com.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myapplication.Fragment.Start1Fragment;
import com.myapplication.Fragment.Start2Fragment;
import com.myapplication.Fragment.StartrealssubFragment;


public class StartrealViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 8;

    public StartrealViewPagerAdapter(FragmentManager fragmentManager) {
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
                return StartrealssubFragment.newInstance(0);
            case 1:
                return StartrealssubFragment.newInstance(1);
            case 2:
                return StartrealssubFragment.newInstance(2);
            case 3:
                return StartrealssubFragment.newInstance(3);
            case 4:
                return StartrealssubFragment.newInstance(4);
            case 5:
                return StartrealssubFragment.newInstance(5);
            case 6:
                return StartrealssubFragment.newInstance(6);
            case 7:
                return StartrealssubFragment.newInstance(7);

            default:
                return null;
        }
    }

}