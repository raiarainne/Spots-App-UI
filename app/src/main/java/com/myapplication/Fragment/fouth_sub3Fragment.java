package com.myapplication.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.myapplication.Activity.MainActivity;
import com.myapplication.R;


public class fouth_sub3Fragment extends Fragment implements View.OnClickListener {
    MainActivity mainActivity;
    View view;
    ImageView imvbar;
    LinearLayout lytscropart;
    FrameLayout.LayoutParams lp;



    // First Item===============
    LinearLayout lytfirstitem, lytfirstitemsubitem, firstitemalert;
    ImageView seconddot;
    // Second Item=================
    LinearLayout lytseconditem, lytseconditemsubitem, seconditemalert;
    ImageView firstdot;

    // Third Item=================
    LinearLayout lytthirditem, lytthirditemsubitem, thirditemalert;
    ImageView thirddot;

    // fourth Item=================
    LinearLayout lytfourthitem, lytfourthitemsubitem, fourthitemalert;
    ImageView fourthdot;

    // Fifth Item=================
    LinearLayout lytfifthitem, lytfifthitemsubitem, fifthitemalert;
    ImageView fifthdot;

    // Six item ================
    LinearLayout lytsixitem, lytsixitemsubitem, sixitemalert;
    ImageView sixdot;

    // ============ last second Item=============
    LinearLayout lastseconditem, lastsecondsubitem;

    //========== last Item============
    LinearLayout lytlastitem, lytlastsubitem;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_fouth_sub3, container, false);

        imvbar=(ImageView)view.findViewById(R.id.imv_bar);





        lp = new FrameLayout.LayoutParams((int) dptopixel(2), FrameLayout.LayoutParams.MATCH_PARENT);
       // lp.setMargins(left, top, right, bottom);
       // lp.setMarginEnd(20);
        lp.setMargins(dptopixel(25), dptopixel(90), 0, dptopixel(33));
        imvbar.setLayoutParams(lp);
       // getResources().getDisplayMetrics().density;

        lytscropart=(LinearLayout)view.findViewById(R.id.lyt_scrolpart);
        lytscropart.setOnClickListener(this);


        //============= First item=================
        lytfirstitem=(LinearLayout)view.findViewById(R.id.lyt_firstitem);
        lytfirstitem.setOnClickListener(this);
        lytfirstitemsubitem=(LinearLayout)view.findViewById(R.id.lyt_firstitem_subitem);
        lytfirstitemsubitem.setVisibility(View.GONE);
        firstitemalert=(LinearLayout)view.findViewById(R.id.firstitem_alert);
        firstitemalert.setOnClickListener(this);
        firstitemalert.setVisibility(View.GONE);
        firstdot=(ImageView)view.findViewById(R.id.firstdot);
        firstdot.setOnClickListener(this);

        //==================== Second Item============================
        lytseconditem=(LinearLayout)view.findViewById(R.id.lyt_seconditem);
        lytseconditem.setOnClickListener(this);
        lytseconditemsubitem=(LinearLayout)view.findViewById(R.id.lyt_seconditem_subitem);
        lytseconditemsubitem.setVisibility(View.GONE);
        seconditemalert=(LinearLayout)view.findViewById(R.id.seconditem_alert);
        seconditemalert.setOnClickListener(this);
        seconditemalert.setVisibility(View.GONE);
        seconddot=(ImageView)view.findViewById(R.id.seconddot);
        seconddot.setOnClickListener(this);

        //==================== Third Item============================
        lytthirditem=(LinearLayout)view.findViewById(R.id.lyt_thirditem);
        lytthirditem.setOnClickListener(this);
        lytthirditemsubitem=(LinearLayout)view.findViewById(R.id.lyt_thirditem_subitem);
        lytthirditemsubitem.setVisibility(View.GONE);
        thirditemalert=(LinearLayout)view.findViewById(R.id.thirditem_alert);
        thirditemalert.setOnClickListener(this);
        thirditemalert.setVisibility(View.GONE);
        thirddot=(ImageView)view.findViewById(R.id.thirddot);
        thirddot.setOnClickListener(this);

        //==================== Fourth Item============================
        lytfourthitem=(LinearLayout)view.findViewById(R.id.lyt_fourthitem);
        lytfourthitem.setOnClickListener(this);
        lytfourthitemsubitem=(LinearLayout)view.findViewById(R.id.lyt_fourthitem_subitem);
        lytfourthitemsubitem.setVisibility(View.GONE);
        fourthitemalert=(LinearLayout)view.findViewById(R.id.fourthitem_alert);
        fourthitemalert.setOnClickListener(this);
        fourthitemalert.setVisibility(View.GONE);
        fourthdot=(ImageView)view.findViewById(R.id.fourthdot);
        fourthdot.setOnClickListener(this);

        //==================== Fifth Item============================
        lytfifthitem=(LinearLayout)view.findViewById(R.id.lyt_fifthitem);
        lytfifthitem.setOnClickListener(this);
        lytfifthitemsubitem=(LinearLayout)view.findViewById(R.id.lyt_fifthitem_subitem);
        lytfifthitemsubitem.setVisibility(View.GONE);
        fifthitemalert=(LinearLayout)view.findViewById(R.id.fifthitem_alert);
        fifthitemalert.setOnClickListener(this);
        fifthitemalert.setVisibility(View.GONE);
        fifthdot=(ImageView)view.findViewById(R.id.fifthdot);
        fifthdot.setOnClickListener(this);

        //=================== Six item===================
        lytsixitem=(LinearLayout)view.findViewById(R.id.lyt_sixitem);
        lytsixitem.setOnClickListener(this);
        lytsixitemsubitem=(LinearLayout)view.findViewById(R.id.lyt_sixitem_subitem);
        lytsixitemsubitem.setVisibility(View.GONE);
        sixitemalert=(LinearLayout)view.findViewById(R.id.sixitem_alert);
        sixitemalert.setOnClickListener(this);
        sixitemalert.setVisibility(View.GONE);
        sixdot=(ImageView)view.findViewById(R.id.sixdot);
        sixdot.setOnClickListener(this);

        //==========  last second item=================
        lastseconditem=(LinearLayout)view.findViewById(R.id.lyt_lastseconditem);
        lastseconditem.setOnClickListener(this);
        lastsecondsubitem=(LinearLayout)view.findViewById(R.id.lyt_lastsecond_subitem);
        lastsecondsubitem.setVisibility(View.GONE);

        // =================== last item==================
        lytlastitem=(LinearLayout)view.findViewById(R.id.lyt_lastitem);
        lytlastitem.setOnClickListener(this);
        lytlastsubitem=(LinearLayout)view.findViewById(R.id.lyt_lastitem_subitem);
        lytlastsubitem.setVisibility(View.GONE);


        return view;
    }

    public int dptopixel(int dp){
        Resources r = mainActivity.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
        return px;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.lyt_scrolpart:
                firstitemalert.setVisibility(View.GONE);
                seconditemalert.setVisibility(View.GONE);
                thirditemalert.setVisibility(View.GONE);
                fourthitemalert.setVisibility(View.GONE);
                fifthitemalert.setVisibility(View.GONE);
                sixitemalert.setVisibility(View.GONE);

                break;

            /* =============================     First item=======================*/
            case R.id.lyt_firstitem:
                if(lytfirstitemsubitem.getVisibility()==View.GONE){
                    lytfirstitemsubitem.setVisibility(View.VISIBLE);
                }else if(lytfirstitemsubitem.getVisibility()==View.VISIBLE){
                    lytfirstitemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.firstitem_alert:
                if(firstitemalert.getVisibility()==View.VISIBLE){
                    firstitemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.firstdot:
                firstitemalert.setVisibility(View.VISIBLE);
                break;

            /*======================= Second item==================*/
            case R.id.lyt_seconditem:
                if(lytseconditemsubitem.getVisibility()==View.GONE){
                    lytseconditemsubitem.setVisibility(View.VISIBLE);
                }else if(lytseconditemsubitem.getVisibility()==View.VISIBLE){
                    lytseconditemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.seconditem_alert:
                if(seconditemalert.getVisibility()==View.VISIBLE){
                    seconditemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.seconddot:
                seconditemalert.setVisibility(View.VISIBLE);
                break;

            /*============= Third Item ==================*/
            case R.id.lyt_thirditem:
                if(lytthirditemsubitem.getVisibility()==View.GONE){
                    lytthirditemsubitem.setVisibility(View.VISIBLE);
                }else if(lytthirditemsubitem.getVisibility()==View.VISIBLE){
                    lytthirditemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.thirditem_alert:
                if(thirditemalert.getVisibility()==View.VISIBLE){
                    thirditemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.thirddot:
                thirditemalert.setVisibility(View.VISIBLE);
                break;

            /*============= Fourth Item ==================*/
            case R.id.lyt_fourthitem:
                if(lytfourthitemsubitem.getVisibility()==View.GONE){
                    lytfourthitemsubitem.setVisibility(View.VISIBLE);
                }else if(lytfourthitemsubitem.getVisibility()==View.VISIBLE){
                    lytfourthitemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.fourthitem_alert:
                if(fourthitemalert.getVisibility()==View.VISIBLE){
                    fourthitemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.fourthdot:
                fourthitemalert.setVisibility(View.VISIBLE);
                break;

            /*============= Fifth Item ==================*/
            case R.id.lyt_fifthitem:
                if(lytfifthitemsubitem.getVisibility()==View.GONE){
                    lytfifthitemsubitem.setVisibility(View.VISIBLE);
                }else if(lytfifthitemsubitem.getVisibility()==View.VISIBLE){
                    lytfifthitemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.fifthitem_alert:
                if(fifthitemalert.getVisibility()==View.VISIBLE){
                    fifthitemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.fifthdot:
                fifthitemalert.setVisibility(View.VISIBLE);
                break;

            /*================= Six item ===================*/
            case R.id.lyt_sixitem:
                if(lytsixitemsubitem.getVisibility()==View.GONE){
                    lytsixitemsubitem.setVisibility(View.VISIBLE);
                }else if(lytsixitemsubitem.getVisibility()==View.VISIBLE){
                    lytsixitemsubitem.setVisibility(View.GONE);
                }
                break;
            case R.id.sixitem_alert:
                if(sixitemalert.getVisibility()==View.VISIBLE){
                    sixitemalert.setVisibility(View.GONE);
                }
                break;
            case R.id.sixdot:
                sixitemalert.setVisibility(View.VISIBLE);
                break;


            /*=================== Last second item====================*/
            case R.id.lyt_lastseconditem:
                if(lastsecondsubitem.getVisibility()==View.VISIBLE){
                    lastsecondsubitem.setVisibility(View.GONE);
                }else if(lastsecondsubitem.getVisibility()==View.GONE){
                    lastsecondsubitem.setVisibility(View.VISIBLE);
                }
                break;


            /*======================= Last Item=====================*/
            case R.id.lyt_lastitem:
                if(lytlastsubitem.getVisibility()==View.GONE){
                    lytlastsubitem.setVisibility(View.VISIBLE);
                    lp.setMargins(dptopixel(25), dptopixel(90), 0, dptopixel(200));
                    imvbar.setLayoutParams(lp);
                }else if(lytlastsubitem.getVisibility()==View.VISIBLE){
                    lytlastsubitem.setVisibility(View.GONE);
                    lp.setMargins(dptopixel(25), dptopixel(90), 0, dptopixel(33));
                    imvbar.setLayoutParams(lp);
                }
                break;

        }
    }
}
