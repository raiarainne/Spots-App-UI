package com.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.myapplication.Fragment.PriceFirstFragment;
import com.myapplication.Fragment.PriceSecondFragment;
import com.myapplication.Fragment.PriceThirdFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
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
                return PriceFirstFragment.newInstance(0);
            case 1:
                return PriceSecondFragment.newInstance(1);
            case 2:
                return PriceThirdFragment.newInstance(2);
            default:
                return null;
        }
    }

}