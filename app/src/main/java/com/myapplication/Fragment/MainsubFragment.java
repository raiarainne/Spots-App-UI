package com.myapplication.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.myapplication.Activity.MainActivity;
import com.myapplication.Adapter.HomeRecyclerViewAdapter;
import com.myapplication.R;

import java.util.ArrayList;

import static android.R.attr.scrollY;


public class MainsubFragment extends Fragment {
    View view;
    MainActivity mainActivity;
    ScrollView subscrolview;
    HomeRecyclerViewAdapter homeRecyclerViewAdapter, homeRecyclerViewAdapter1;
    RecyclerView recyclerView, recyclerView1;

    ArrayList<Integer> _imgs = new ArrayList<>();
    ArrayList<Integer> _imgs1 = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mainsub, container, false);
        subscrolview=(ScrollView) view.findViewById(R.id.scr_subscroll);

        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);


        _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man2);
        _imgs1.add(R.drawable.man3); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man2);

        recyclerView=(RecyclerView)view.findViewById(R.id.rev_image);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(mainActivity, _imgs);
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        recyclerView1=(RecyclerView)view.findViewById(R.id.rev_image1);
        LinearLayoutManager linearLayoutManager1= new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        homeRecyclerViewAdapter1 = new HomeRecyclerViewAdapter(mainActivity, _imgs1);
        recyclerView1.setAdapter(homeRecyclerViewAdapter1);

        subscrolview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                // Disallow the touch request for parent scroll on touch of child view
                // view.getParent().requestDisallowInterceptTouchEvent(true);
               /* if(scrollY>=800){

                    Toast.makeText(mainActivity, "false", Toast.LENGTH_SHORT).show();
                    scrview.setEnableScrolling(false);

                }else {
                    scrview.setEnableScrolling(true);

                }*/
                if(scrollY<=800){
                   // scrview.setEnableScrolling(true);
                }
                return false;
            }
        });

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }

}
