package com.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.Activity.MainActivity;
import com.myapplication.R;
import com.myapplication.Utils.LVRingProgress;


public class ContactoverviewFragment extends Fragment implements View.OnClickListener{

    LinearLayout alert1, alert2, alert3, alert4, alert5;
    TextView ale1, ale2, ale3, ale4, ale5;
    TextView down1, down2, down3, down4, down5;
    TextView tei1, tei2, tei3, tei4, tei5;
    TextView info1, info2, info3,info4, info5;
    MainActivity mainActivity;
    ScrollView scrollView;
    RelativeLayout scroll;

    LVRingProgress mLVRingProgress1,mLVRingProgress2,mLVRingProgress3,mLVRingProgress4,mLVRingProgress5,mLVRingProgress6;

    View view;

    public static ContactoverviewFragment newInstance(int page) {
        ContactoverviewFragment fragmentFirst = new ContactoverviewFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_contactoverview, container, false);
        alert1=(LinearLayout)view.findViewById(R.id.alert_1);

        alert2=(LinearLayout)view.findViewById(R.id.alert_2);
        alert3=(LinearLayout)view.findViewById(R.id.alert_3);
        alert4=(LinearLayout)view.findViewById(R.id.alert_4);
        alert5=(LinearLayout)view.findViewById(R.id.alert_5);
        alert2.setVisibility(View.GONE);
        alert1.setVisibility(View.GONE);
        alert3.setVisibility(View.GONE);
        alert4.setVisibility(View.GONE);
        alert5.setVisibility(View.GONE);

        ale1=(TextView)view.findViewById(R.id.txvalleinfos_1);
        ale2=(TextView)view.findViewById(R.id.txvalleinfos_2);
        ale3=(TextView)view.findViewById(R.id.txvalleinfos_3);
        ale4=(TextView)view.findViewById(R.id.txvalleinfos_4);
        ale5=(TextView)view.findViewById(R.id.txvalleinfos_5);
        ale1.setOnClickListener(this);
        ale2.setOnClickListener(this);
        ale3.setOnClickListener(this);
        ale4.setOnClickListener(this);
        ale5.setOnClickListener(this);

        down1=(TextView)view.findViewById(R.id.txv_downloads_1);
        down2=(TextView)view.findViewById(R.id.txv_downloads_2);
        down3=(TextView)view.findViewById(R.id.txv_downloads_3);
        down4=(TextView)view.findViewById(R.id.txv_downloads_4);
        down5=(TextView)view.findViewById(R.id.txv_downloads_5);
        down1.setOnClickListener(this);
        down2.setOnClickListener(this);
        down3.setOnClickListener(this);
        down4.setOnClickListener(this);
        down5.setOnClickListener(this);

        tei1=(TextView)view.findViewById(R.id.txv_teilen_1);
        tei1.setOnClickListener(this);
        tei2=(TextView)view.findViewById(R.id.txv_teilen_2);
        tei3=(TextView)view.findViewById(R.id.txv_teilen_3);
        tei4=(TextView)view.findViewById(R.id.txv_teilen_4);
        tei5=(TextView)view.findViewById(R.id.txv_teilen_5);
        tei2.setOnClickListener(this);
        tei3.setOnClickListener(this);
        tei4.setOnClickListener(this);
        tei5.setOnClickListener(this);

        info1=(TextView)view.findViewById(R.id.txv_info_1);
        info1.setOnClickListener(this);
        info2=(TextView)view.findViewById(R.id.txv_info_2);
        info2.setOnClickListener(this);
        info3=(TextView)view.findViewById(R.id.txv_info_3);
        info3.setOnClickListener(this);
        info4=(TextView)view.findViewById(R.id.txv_info_4);
        info4.setOnClickListener(this);
        info5=(TextView)view.findViewById(R.id.txv_info_5);
        info5.setOnClickListener(this);


        mLVRingProgress1 = (LVRingProgress) view.findViewById(R.id.lv_ringp1);
        mLVRingProgress1.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress1.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress1.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress1.setPorBarEndColor(getResources().getColor(R.color.endprogress));
        mLVRingProgress1.setProgress(80);

        mLVRingProgress2 = (LVRingProgress) view.findViewById(R.id.lv_ringp2);
        mLVRingProgress2.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress2.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress2.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress2.setPorBarEndColor(getResources().getColor(R.color.endprogress));
        mLVRingProgress2.setProgress(60);

        mLVRingProgress3 = (LVRingProgress) view.findViewById(R.id.lv_ringp3);
        mLVRingProgress3.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress3.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress3.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress3.setPorBarEndColor(getResources().getColor(R.color.endprogress));
        mLVRingProgress3.setProgress(40);

        mLVRingProgress4 = (LVRingProgress) view.findViewById(R.id.lv_ringp4);
        mLVRingProgress4.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress4.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress4.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress4.setPorBarEndColor(getResources().getColor(R.color.endprogress));
        mLVRingProgress4.setProgress(80);


        mLVRingProgress6 = (LVRingProgress) view.findViewById(R.id.lv_ringp6);
        mLVRingProgress6.setViewColor(getResources().getColor(R.color.progressback));
        mLVRingProgress6.setTextColor(getResources().getColor(R.color.textcolor));
        mLVRingProgress6.setPorBarStartColor(getResources().getColor(R.color.startprogress));
        mLVRingProgress6.setPorBarEndColor(getResources().getColor(R.color.endprogress));
        mLVRingProgress6.setProgress(70);



        scrollView=(ScrollView)view.findViewById(R.id.src_view);
        scroll=(RelativeLayout)view.findViewById(R.id.rtv_scroll);
        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert2.setVisibility(View.GONE);
                alert1.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
            }
        });

        mainActivity.viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(mainActivity.viewPager1.getCurrentItem()==0){
                    scrollView.setVisibility(View.VISIBLE);
                }else {
                    scrollView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert2.setVisibility(View.GONE);
                alert1.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
            }
        });*/


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txvalleinfos_1:
                alllayoutgone();
                break;
            case R.id.txvalleinfos_2:
                alllayoutgone();
                break;
            case R.id.txvalleinfos_3:
                alllayoutgone();
                break;
            case R.id.txvalleinfos_4:
                alllayoutgone();
                break;
            case R.id.txvalleinfos_5:
                alllayoutgone();
                break;
            case R.id.txv_downloads_1:
                alllayoutgone();
                break;
            case R.id.txv_downloads_2:
                alllayoutgone();
                break;
            case R.id.txv_downloads_3:
                alllayoutgone();
                break;
            case R.id.txv_downloads_4:
                alllayoutgone();
                break;
            case R.id.txv_downloads_5:
                alllayoutgone();
                break;
            case R.id.txv_teilen_1:
                alllayoutgone();
                break;
            case R.id.txv_teilen_2:
                alllayoutgone();
                break;
            case R.id.txv_teilen_3:
                alllayoutgone();
                break;
            case R.id.txv_teilen_4:
                alllayoutgone();
                break;
            case R.id.txv_teilen_5:
                alllayoutgone();
                break;

            case R.id.txv_info_1:
                alert1.setVisibility(View.VISIBLE);
                alert2.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
                break;
            case R.id.txv_info_2:
                alert2.setVisibility(View.VISIBLE);
                alert1.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
                break;
            case R.id.txv_info_3:
                alert3.setVisibility(View.VISIBLE);
                alert2.setVisibility(View.GONE);
                alert1.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
                break;
            case R.id.txv_info_4:
                alert4.setVisibility(View.VISIBLE);
                alert2.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert1.setVisibility(View.GONE);
                alert5.setVisibility(View.GONE);
                break;
            case R.id.txv_info_5:
                alert5.setVisibility(View.VISIBLE);
                alert2.setVisibility(View.GONE);
                alert3.setVisibility(View.GONE);
                alert4.setVisibility(View.GONE);
                alert1.setVisibility(View.GONE);
                break;

        }

    }
    public void alllayoutgone(){
        alert1.setVisibility(View.GONE);
        alert2.setVisibility(View.GONE);
        alert3.setVisibility(View.GONE);
        alert4.setVisibility(View.GONE);
        alert5.setVisibility(View.GONE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }
}
