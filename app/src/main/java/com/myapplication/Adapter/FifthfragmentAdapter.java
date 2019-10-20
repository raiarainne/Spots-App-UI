package com.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.myapplication.Activity.MainActivity;
import com.myapplication.Model.Cartmodel;
import com.myapplication.R;


import java.util.ArrayList;


/**
 * Created by aa on 9/14/2016.
 */
public class FifthfragmentAdapter extends BaseAdapter {
    private MainActivity _context;

    private static final int TYPE_INDEX = 0;
    private static final int TYPE_USER = 1;

    private ArrayList<Object> sonses = new ArrayList<>();
    private ArrayList<Integer> tags=new ArrayList<>();







    public FifthfragmentAdapter(MainActivity context, ArrayList<Object> _ratingusers) {

        super();
        this._context = context;
        sonses=_ratingusers;
        for(int i=0; i<sonses.size(); i++){
            tags.add(0);
        }

    }

    public void setUserDatas(ArrayList<Cartmodel> son){



        sonses.clear();
        sonses.addAll(son);

    }

    @Override
    public int getCount() {
        return sonses.size();
    }

    @Override
    public Object getItem(int position) {
        return sonses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        if (getItem(position) instanceof Cartmodel)
            return TYPE_USER;

        return TYPE_INDEX;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {

            case TYPE_INDEX: {
                IndexHolder holder;
                if (convertView == null) {
                    holder = new IndexHolder();

                    LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.fifthfooter, parent, false);

                   // holder.txvIndex = (TextView) convertView.findViewById(R.id.txv_index);

                    convertView.setTag(holder);
                } else {
                    holder = (IndexHolder) convertView.getTag();
                }


            }
            break;
            case TYPE_USER: {
                final CustomHolder holder;
                if (convertView == null) {
                    holder = new CustomHolder();

                    LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    convertView = inflater.inflate(R.layout.fifthlistitem, parent, false);
                    holder.imvimage = (ImageView) convertView.findViewById(R.id.imv_imagefifth);
                    holder.txvname = (TextView) convertView.findViewById(R.id.txv_name);
                    holder.imvplus = (ImageView) convertView.findViewById(R.id.imv_btn_plus_fifth);
                    holder.imvminus = (ImageView) convertView.findViewById(R.id.imv_btn_minus_fifth);
                    holder.txvvalue = (TextView) convertView.findViewById(R.id.txv_value);
                    holder.txvvalueuro = (TextView) convertView.findViewById(R.id.txv_valuseuro);
                    convertView.setTag(holder);
                } else {
                    holder = (CustomHolder) convertView.getTag();
                }


                final Cartmodel trip1 = (Cartmodel) sonses.get(position);

                //  holder.petsphoto.setImageUrl(trip1.getPetsprofileimage(),_imageLoader);

                if(position%2==0){
                    holder.imvimage.setBackgroundResource(R.drawable.man1);
                }else if(position%3==0){
                    holder.imvimage.setBackgroundResource(R.drawable.man2);
                }else {
                    holder.imvimage.setBackgroundResource(R.drawable.man3);
                }

                holder.txvname.setText(trip1.getName());
                holder.txvvalueuro.setText(trip1.getValue()+" \u20ac");
                holder.txvvalue.setText(String.valueOf(tags.get(position)));

                holder.imvplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(tags.get(position)<30){
                            tags.set(position, tags.get(position)+1);
                            holder.txvvalue.setText(String.valueOf(tags.get(position)));
                        }
                    }
                });
                holder.imvminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(tags.get(position)>0){
                            tags.set(position, tags.get(position)-1);
                            holder.txvvalue.setText(String.valueOf(tags.get(position)));
                        }
                    }
                });
            }
            break;
        }

        return convertView;
    }


    public class CustomHolder {
        public ImageView imvimage;
        public TextView txvname;
        public ImageView imvplus;
        public ImageView imvminus;
        public TextView txvvalue;
        public TextView txvvalueuro;



    }
    public class  IndexHolder{

    }





}
