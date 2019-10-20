package com.myapplication.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.myapplication.Activity.MainActivity;
import com.myapplication.Fragment.MainsubFragment;
import com.myapplication.R;
import com.telenav.expandablepager.adapter.ExpandablePagerAdapter;


import java.util.List;

public class BookAdapter extends ExpandablePagerAdapter<String> {
    public BookAdapter(List<String> items) {
        super(items);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ViewGroup rootView = (ViewGroup) LayoutInflater.from(container.getContext()).inflate(R.layout.page, container, false);
      //  rootView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
       // ((TextView) rootView.findViewById(R.id.text)).setText(items.get(position).getDescription());
        FrameLayout frmcontainer;
        frmcontainer=(FrameLayout)rootView.findViewById(R.id.frm_contain_1);

       /* FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainsubFragment fragment = new MainsubFragment();
        fragmentTransaction.add(R.id.frm_contain_1, fragment);
        fragmentTransaction.commit();*/


        return attach(container, rootView, position);
    }




}
