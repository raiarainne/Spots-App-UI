package com.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myapplication.Fragment.PriceFirstFragment;
import com.myapplication.Fragment.PriceSecondFragment;
import com.myapplication.Fragment.PriceThirdFragment;
import com.myapplication.Fragment.Start1Fragment;
import com.myapplication.Fragment.Start2Fragment;


public class StartViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public StartViewPagerAdapter(FragmentManager fragmentManager) {
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
                return Start1Fragment.newInstance(0);
            case 1:
                return Start2Fragment.newInstance(1);

            default:
                return null;
        }
    }

}