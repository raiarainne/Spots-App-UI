package com.myapplication.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.myapplication.Activity.MainActivity;
import com.myapplication.Adapter.StartViewPagerAdapter;
import com.myapplication.Adapter.ViewPagerAdapter;
import com.myapplication.R;
import com.myapplication.Utils.DrawFromBackTransformer;
import com.myapplication.Utils.ScaleCircleNavigator;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;


public class SartscreenFragment extends Fragment implements View.OnClickListener{

    ViewPager viewPager,viewPager1;

    FragmentPagerAdapter adapterViewPager;

    StartViewPagerAdapter adapter;
    public  ImageView previewimage;

    public  static NestedScrollView scrollView;

    public static CollapsingToolbarLayout collapsingToolbarLayout;
    public static AppBarLayout lytappbar;


    ImageView imvForMeNormal, imvForMeSelected, imvForUsNormal, imvForUsSelected;
    ImageView imvOptionIndividualOff, imvOptionAdvantageOff;
    Boolean isEnableoption=true;
    MainActivity mainActivity;
    ImageView imvsub;

    LinearLayout lyttitletext;
    FrameLayout frmcolapse;

    TextView txvDay;

    int valDay;
    View view;
    Toolbar toolbar;


    public static SartscreenFragment newInstance(int page) {
        SartscreenFragment fragmentFirst = new SartscreenFragment();
        Bundle args = new Bundle();
        args.putInt("subInt", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_sartscreen, container, false);
        valDay = 1;

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        adapterViewPager = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int currentPageNum = viewPager.getCurrentItem();

                setFragmentTabVisible(currentPageNum);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager1=(ViewPager)view.findViewById(R.id.view_pager1);
        adapter=new StartViewPagerAdapter(getChildFragmentManager());
        viewPager1.setAdapter(adapter);
        viewPager1.setPageTransformer(true, new DrawFromBackTransformer());
        MagicIndicator magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator4);
        ScaleCircleNavigator scaleCircleNavigator = new ScaleCircleNavigator(mainActivity);
        scaleCircleNavigator.setCircleCount(2);
        scaleCircleNavigator.setNormalCircleColor(Color.GRAY);
        scaleCircleNavigator.setSelectedCircleColor(Color.WHITE);
        magicIndicator.setNavigator(scaleCircleNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager1);

        imvForMeNormal= (ImageView) view.findViewById(R.id.imv_for_me_normal);
        imvForMeSelected= (ImageView) view.findViewById(R.id.imv_for_me_selected);
        imvForUsNormal= (ImageView) view.findViewById(R.id.imv_for_us_normal);
        imvForUsSelected= (ImageView) view.findViewById(R.id.imv_for_us_selected);

        imvForMeNormal.setOnClickListener(this);
        imvForUsNormal.setOnClickListener(this);

        ImageView imv1 = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_normal);
        imv1.setOnClickListener(this);
        ImageView imv2 = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_normal);
        imv2.setOnClickListener(this);
        ImageView imv3 = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_normal);
        imv3.setOnClickListener(this);

        imvOptionIndividualOff = (ImageView) view.findViewById(R.id.imv_option_individual_off);
        imvOptionIndividualOff.setOnClickListener(this);
        imvOptionIndividualOff.setImageResource(R.mipmap.ic_option_on);


        imvOptionAdvantageOff = (ImageView) view.findViewById(R.id.imv_option_advantage_off);
        imvOptionAdvantageOff.setOnClickListener(this);
        imvOptionAdvantageOff.setImageResource(R.mipmap.ic_option_off);


        ImageView imvBtnPlus = (ImageView) view.findViewById(R.id.imv_btn_plus);
        imvBtnPlus.setOnClickListener(this);

        ImageView imvBtnMinus = (ImageView) view.findViewById(R.id.imv_btn_minus);
        imvBtnMinus.setOnClickListener(this);

        txvDay = (TextView) view.findViewById(R.id.txv_day);

        previewimage=(ImageView)view.findViewById(R.id.imv_preve);
        previewimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.viewPager.setCurrentItem(0,true);
            }
        });

        lyttitletext=(LinearLayout)view.findViewById(R.id.lyt_titletext);
        lyttitletext.setVisibility(View.INVISIBLE);



        scrollView=(NestedScrollView)view.findViewById(R.id.scr_view_1);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY>0){
                    lyttitletext.setVisibility(View.VISIBLE);

                }else {
                    lyttitletext.setVisibility(View.INVISIBLE);
                }
                Log.d("scrolx====", String.valueOf(scrollX));
                Log.d("scroly====", String.valueOf(scrollY));
                Log.d("scrolx1====", String.valueOf(oldScrollX));
                Log.d("scroly1====", String.valueOf(oldScrollY));
            }
        });

        imvsub=(ImageView)view.findViewById(R.id.imv_sub);


        collapsingToolbarLayout=(CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);
        lytappbar=(AppBarLayout)view.findViewById(R.id.lyt_appbar);

        frmcolapse=(FrameLayout)view.findViewById(R.id.frm_colaps);
        frmcolapse.setAlpha(1);
        lytappbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                float alhap=(float) 1-(float)Math.abs(verticalOffset)/1000;
                Log.d("value===", String.valueOf(alhap));
                frmcolapse.setAlpha(alhap);

            }
        });





        return view;
    }
    public void setFragmentTabVisible(int pageNum) {

        ImageView imv;
        TextView txv;

        switch (pageNum) {

            case 0:

                /* tab background image */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_normal);
                imv.setVisibility(View.VISIBLE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_selected);
                imv.setVisibility(View.GONE);

                /* star */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_normal);
                imv.setVisibility(View.VISIBLE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView)view.findViewById(R.id.imv_fragment_star_2_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_selected);
                imv.setVisibility(View.GONE);

                /* text level */

                txv = (TextView) view.findViewById(R.id.txv_level_1_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_level_1_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_selected);
                txv.setVisibility(View.GONE);

                /* text price */

                txv = (TextView) view.findViewById(R.id.txv_price_1_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_price_1_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_price_3_selected);
                txv.setVisibility(View.GONE);

                /* text per day */

                txv = (TextView) view.findViewById(R.id.txv_perday_1_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_perday_1_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_perday_3_selected);
                txv.setVisibility(View.GONE);

                break;

            case 1:

                /* tab background image */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_normal);
                imv.setVisibility(View.VISIBLE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_selected);
                imv.setVisibility(View.GONE);

                /* star */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_1_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_normal);
                imv.setVisibility(View.VISIBLE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_1_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_selected);
                imv.setVisibility(View.GONE);

                 /* text level */

                txv = (TextView) view.findViewById(R.id.txv_level_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_level_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_selected);
                txv.setVisibility(View.GONE);

                /* text price */

                txv = (TextView) view.findViewById(R.id.txv_price_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_price_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_price_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_3_selected);
                txv.setVisibility(View.GONE);

                /* text per day */

                txv = (TextView) view.findViewById(R.id.txv_perday_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_normal);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_perday_3_normal);
                txv.setVisibility(View.VISIBLE);

                txv = (TextView) view.findViewById(R.id.txv_perday_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_selected);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_3_selected);
                txv.setVisibility(View.GONE);

                break;

            case 2:

                /* tab background image */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_normal);
                imv.setVisibility(View.GONE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_tab_3_selected);
                imv.setVisibility(View.VISIBLE);

                /* star */

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_1_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_normal);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_normal);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_normal);
                imv.setVisibility(View.GONE);

                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_1_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_1_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_2_2_selected);
                imv.setVisibility(View.GONE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_1_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_2_selected);
                imv.setVisibility(View.VISIBLE);
                imv = (ImageView) view.findViewById(R.id.imv_fragment_star_3_3_selected);
                imv.setVisibility(View.VISIBLE);

                 /* text level */

                txv = (TextView) view.findViewById(R.id.txv_level_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_normal);
                txv.setVisibility(View.GONE);

                txv = (TextView) view.findViewById(R.id.txv_level_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_level_3_selected);
                txv.setVisibility(View.VISIBLE);

                /* text price */

                txv = (TextView) view.findViewById(R.id.txv_price_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_price_3_normal);
                txv.setVisibility(View.GONE);

                txv = (TextView) view.findViewById(R.id.txv_price_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_price_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView)view.findViewById(R.id.txv_price_3_selected);
                txv.setVisibility(View.VISIBLE);

                /* text per day */

                txv = (TextView)view. findViewById(R.id.txv_perday_1_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_normal);
                txv.setVisibility(View.VISIBLE);
                txv = (TextView) view.findViewById(R.id.txv_perday_3_normal);
                txv.setVisibility(View.GONE);

                txv = (TextView) view.findViewById(R.id.txv_perday_1_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView) view.findViewById(R.id.txv_perday_2_selected);
                txv.setVisibility(View.GONE);
                txv = (TextView)view.findViewById(R.id.txv_perday_3_selected);
                txv.setVisibility(View.VISIBLE);

                break;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imv_for_me_normal:
                imvForMeNormal.setVisibility(View.GONE);
                imvForUsNormal.setVisibility(View.VISIBLE);
                imvForMeSelected.setVisibility(View.VISIBLE);
                imvForUsSelected.setVisibility(View.GONE);
                break;

            case R.id.imv_for_us_normal:
                imvForMeNormal.setVisibility(View.VISIBLE);
                imvForUsNormal.setVisibility(View.GONE);
                imvForMeSelected.setVisibility(View.GONE);
                imvForUsSelected.setVisibility(View.VISIBLE);
                break;

            case R.id.imv_fragment_tab_1_normal:
                viewPager.setCurrentItem(0);
                break;

            case R.id.imv_fragment_tab_2_normal:
                viewPager.setCurrentItem(1);
                break;

            case R.id.imv_fragment_tab_3_normal:
                viewPager.setCurrentItem(2);
                break;
            case R.id.imv_option_advantage_off:
                if(isEnableoption==true){
                    imvOptionIndividualOff.setImageResource(R.mipmap.ic_option_off);
                    imvOptionAdvantageOff.setImageResource(R.mipmap.ic_option_on);
                }
                isEnableoption=false;
                break;
            case R.id.imv_option_individual_off:
                if(isEnableoption==false){
                    imvOptionIndividualOff.setImageResource(R.mipmap.ic_option_on);
                    imvOptionAdvantageOff.setImageResource(R.mipmap.ic_option_off);
                }
                isEnableoption=true;
                break;
            case R.id.imv_btn_minus:
                if(isEnableoption==true && valDay>0){
                    valDay-=1;
                    txvDay.setText(String.valueOf(valDay));
                }
                break;
            case R.id.imv_btn_plus:
                if(isEnableoption==true && valDay<30){
                    valDay+=1;
                    txvDay.setText(String.valueOf(valDay));
                }else if(isEnableoption==true && valDay==30){
                    isEnableoption=false;
                    imvOptionIndividualOff.setImageResource(R.mipmap.ic_option_off);
                    imvOptionAdvantageOff.setImageResource(R.mipmap.ic_option_on);
                }

                break;


        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (MainActivity)context;

    }


}
