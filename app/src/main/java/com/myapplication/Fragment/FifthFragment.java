package com.myapplication.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.myapplication.Activity.MainActivity;
import com.myapplication.Adapter.FifthfragmentAdapter;
import com.myapplication.Model.Cartmodel;
import com.myapplication.R;
import com.myapplication.Utils.ScrollListView;

import java.util.ArrayList;


public class FifthFragment extends Fragment {
    View view;
    MainActivity mainActivity;
    ArrayList<Cartmodel>cartmodels=new ArrayList<>();
    ArrayList<Object>fifthmodels=new ArrayList<>();
    FifthfragmentAdapter fifthfragmentAdapter;
    ScrollListView cartlist;
    LinearLayout lytbottom, lytbotomnot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fifth, container, false);
        cartmodels.clear();

        for(int i=0; i<10; i++){
            if(i<9){
                Cartmodel cartmodel=new Cartmodel();
                if(i%2==0){
                cartmodel.setName("QUALITY       PROTECT 1000");
                    cartmodel.setValue("59,70");
                }else {
                    cartmodel.setName("QUALITY    PARTNER PLUS");
                    cartmodel.setValue("21,90");
                }
                fifthmodels.add(cartmodel);
            }else {
                fifthmodels.add("index");
            }
        }
        cartlist=(ScrollListView) view.findViewById(R.id.lst_card);

        fifthfragmentAdapter=new FifthfragmentAdapter(mainActivity, fifthmodels);
        cartlist.setAdapter(fifthfragmentAdapter);
        lytbotomnot=(LinearLayout)view.findViewById(R.id.lyt_bottomnot);
        lytbotomnot.setVisibility(View.VISIBLE);
        lytbottom=(LinearLayout)view.findViewById(R.id.lyt_bottom);
        lytbottom.setVisibility(View.GONE);

        cartlist.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("scrolll=====", String.valueOf(i)+" "+String.valueOf(i1)+" "+String.valueOf(i2));
                if(i>=8){
                    if(lytbottom.getVisibility()==View.GONE){
                        lytbottom.setVisibility(View.VISIBLE);
                        lytbotomnot.setVisibility(View.GONE);
                    }
                }else {
                    if(lytbotomnot.getVisibility()==View.GONE){
                        lytbotomnot.setVisibility(View.VISIBLE);
                        lytbottom.setVisibility(View.GONE);
                    }
                }

            }
        });







        return view ;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }


}
