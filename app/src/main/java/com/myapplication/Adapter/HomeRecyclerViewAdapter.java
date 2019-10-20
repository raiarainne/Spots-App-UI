package com.myapplication.Adapter;


import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.myapplication.Activity.MainActivity;
import com.myapplication.R;

import java.util.ArrayList;

/**
 * Created by ToSuccess on 11/16/2016.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ImageHolder>{

    MainActivity _activity;
    ArrayList<Integer> _images = new ArrayList<>();
    ArrayList<Integer> _images2 = new ArrayList<>();

    View view ;

    public HomeRecyclerViewAdapter(MainActivity activity , ArrayList<Integer> images){

        this._activity = activity ;
        this._images = images ;
        /*this._images2 = images2 ;*/
        /*_images.add(R.drawable.img2);*/
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_recycl_image,viewGroup, false);
        ImageHolder viewHolder = new ImageHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageHolder viewHolder, final int position) {


        Integer imageHolder = _images.get(position);

        viewHolder.imvPhoto.setImageResource(_images.get(position));
        /*viewHolder.imvPhoto2.setImageResource(_images2.get(position));*/
        if(_images.size()==8){
        viewHolder.txvTitle.setText("BUNDLENAME");
        }

        viewHolder.imvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.viewPager.setCurrentItem(1);
            }
        });
        viewHolder.imvPhoto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                View view1 = _activity.getLayoutInflater().inflate(R.layout.customdialog_layout, null);
                final AlertDialog dialog = new AlertDialog.Builder(_activity)
                        .setView(view1)
                        .create();

                   ImageView editText = (ImageView) view1.findViewById(R.id.imv_image);
                editText.setBackgroundResource(_images.get(position));
                LinearLayout lytfirst=(LinearLayout)view1.findViewById(R.id.lyt_first);
                lytfirst.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                LinearLayout lytsecond=(LinearLayout)view1.findViewById(R.id.lyt_second);
                lytsecond.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                LinearLayout lytthird=(LinearLayout)view1.findViewById(R.id.lyt_third);
                lytthird.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                LinearLayout lytfourth=(LinearLayout)view1.findViewById(R.id.lyt_fourth);
                lytfourth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        _activity.viewPager.setCurrentItem(1);
                        dialog.dismiss();
                    }
                });

                dialog.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        return (null!= _images ? _images.size():0);
        /*return _images.size();*/
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        ImageView imvPhoto ;
        ImageView imvPhoto2;
        TextView txvTitle ;

        public ImageHolder(View view) {
            super(view);
            imvPhoto = (ImageView) view.findViewById(R.id.imv_img_hom);
            /*imvPhoto2 = (ImageView) view.findViewById(R.id.imv_img_hom2);*/
            txvTitle = (TextView)view.findViewById(R.id.txv_bundle);
        }
    }
}
