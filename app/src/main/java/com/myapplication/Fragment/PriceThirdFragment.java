package com.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapplication.R;


public class PriceThirdFragment extends Fragment {


    public static PriceThirdFragment newInstance(int page) {
        PriceThirdFragment fragmentThird = new PriceThirdFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentThird.setArguments(args);
        return fragmentThird;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_third, container, false);
    }


}
