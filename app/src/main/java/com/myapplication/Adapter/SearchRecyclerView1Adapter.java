package com.myapplication.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Activity.MainActivity;
import com.myapplication.R;

import java.util.ArrayList;

/**
 * Created by ToSuccess on 11/16/2016.
 */

public class SearchRecyclerView1Adapter extends RecyclerView.Adapter<SearchRecyclerView1Adapter.ImageHolder>{

    MainActivity _activity;
    ArrayList<Integer> _images = new ArrayList<>();
    ArrayList<Integer> _images2 = new ArrayList<>();

    View view ;

    public SearchRecyclerView1Adapter(MainActivity activity , ArrayList<Integer> images){

        this._activity = activity ;
        this._images = images ;
        /*this._images2 = images2 ;*/
        /*_images.add(R.drawable.img2);*/
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sereadh_recycl_image,viewGroup, false);
        ImageHolder viewHolder = new ImageHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageHolder viewHolder, final int position) {


        Integer imageHolder = _images.get(position);

        viewHolder.imvPhoto.setImageResource(_images.get(position));
        /*viewHolder.imvPhoto2.setImageResource(_images2.get(position));*/
        //if(_images.size()==8){
        viewHolder.txvTitle.setText("IM SEPTEMBER FINET DER 23.TE SCHWERIN TRAITHLON STATT.BBIS...");
      //  }

        /*viewHolder.imvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              *//*  Intent intent = new Intent(_activity , FavDetailsPagerActivity.class);
                intent.putExtra("images", _images);
                intent.putExtra("position", position);
                _activity.startActivity(intent);

                Activity activity = (Activity)_activity ;
                activity.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);*//*

                _activity.showFragment();

            }
        });*/
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
            imvPhoto = (ImageView) view.findViewById(R.id.imv_img_hom2);
            /*imvPhoto2 = (ImageView) view.findViewById(R.id.imv_img_hom2);*/
            txvTitle = (TextView)view.findViewById(R.id.txv_bundle2);
        }
    }
}
