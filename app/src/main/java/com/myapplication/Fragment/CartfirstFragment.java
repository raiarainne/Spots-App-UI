package com.myapplication.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioGroup;

import com.myapplication.Activity.CartActivity;
import com.myapplication.R;

import java.util.Calendar;


public class CartfirstFragment extends Fragment {

    View view;
    ViewPager viewPager;
    RadioGroup radioGroup;

    public static CartfirstFragment newInstance() {
        CartfirstFragment f = new CartfirstFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cartfirst, container, false);
        viewPager=(ViewPager)view.findViewById(R.id.viewper12);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
        radioGroup=(RadioGroup)view.findViewById(R.id.radioGroup1);
        radioGroup.check(R.id.radio_invitation);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_invitation:
                        viewPager.setCurrentItem(0,true);
                        break;
                    case R.id.radio_new_connection:
                        viewPager.setCurrentItem(1,true);
                        break;

                    default:
                        break;
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    radioGroup.check(R.id.radio_invitation);
                }else {
                    radioGroup.check(R.id.radio_new_connection);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return Cartfirstsub1Fragment.newInstance();
                case 1: return Cartfirstsub2Fragment.newInstance();

                default: return Cartfirstsub1Fragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }




}
