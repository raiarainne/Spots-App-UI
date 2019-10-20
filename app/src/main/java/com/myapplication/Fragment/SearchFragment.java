package com.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.myapplication.Activity.MainActivity;
import com.myapplication.Adapter.SearchRecyclerView1Adapter;
import com.myapplication.Adapter.SearchRecyclerViewAdapter;
import com.myapplication.R;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    RecyclerView recyclerView, recyclerView1;
    SearchRecyclerViewAdapter homeRecyclerViewAdapter, homeRecyclerViewAdapter1;
    ArrayList<Integer> _imgs = new ArrayList<>();
    ArrayList<Integer> _imgs1 = new ArrayList<>();
    SearchRecyclerView1Adapter searchRecyclerView1Adapter;
    EditText etxsearch;
    LinearLayout lytlist1, lytlist2;
    ImageView imvback;

    MainActivity mainActivity;

    ImageView imvsearch;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_search, container, false);

        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);
        _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer); _imgs.add(R.drawable.swimmer);


        _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man2);
        _imgs1.add(R.drawable.man3); _imgs1.add(R.drawable.man1); _imgs1.add(R.drawable.image); _imgs1.add(R.drawable.man2);

        recyclerView=(RecyclerView)view.findViewById(R.id.rev_image9);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        homeRecyclerViewAdapter = new SearchRecyclerViewAdapter(mainActivity, _imgs);
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        recyclerView1=(RecyclerView)view.findViewById(R.id.rev_image10);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        searchRecyclerView1Adapter=new SearchRecyclerView1Adapter(mainActivity, _imgs1);
        recyclerView1.setAdapter(searchRecyclerView1Adapter);

        lytlist1=(LinearLayout)view.findViewById(R.id.lyt_list1);
        lytlist1.setVisibility(View.VISIBLE);
        lytlist2=(LinearLayout)view.findViewById(R.id.lyt_list2);
        lytlist2.setVisibility(View.GONE);

        etxsearch=(EditText)view.findViewById(R.id.etx_search);
        imvsearch=(ImageView)view.findViewById(R.id.imv_search);
        imvsearch.setVisibility(View.VISIBLE);
        etxsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               /* if(etxsearch.getText().toString().length()>0){
                    lytlist1.setVisibility(View.GONE);
                    lytlist2.setVisibility(View.VISIBLE);

                }else {
                    lytlist2.setVisibility(View.GONE);
                    lytlist1.setVisibility(View.VISIBLE);

                }
*/

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(etxsearch.getText().toString().length()>0){
                    lytlist1.setVisibility(View.GONE);
                    lytlist2.setVisibility(View.VISIBLE);
                    imvsearch.setVisibility(View.GONE);

                }else {
                    lytlist2.setVisibility(View.GONE);
                    lytlist1.setVisibility(View.VISIBLE);
                    imvsearch.setVisibility(View.VISIBLE);

                }
            }
        });

        imvback=(ImageView)view.findViewById(R.id.imv_back);
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent=new Intent(mainActivity, ProductdetailviewActivity.class);
                startActivity(intent);
                finish();*/
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
