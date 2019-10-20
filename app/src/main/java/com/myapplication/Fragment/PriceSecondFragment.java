package com.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapplication.R;


public class PriceSecondFragment extends Fragment {


    public static PriceSecondFragment newInstance(int page) {
        PriceSecondFragment fragmentSecond = new PriceSecondFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_second, container, false);
    }


}
