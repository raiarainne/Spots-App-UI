package com.myapplication.Activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.myapplication.Adapter.MainViewPager1Adapter;
import com.myapplication.Adapter.MainViewPagerAdapter;
import com.myapplication.Fragment.FifthFragment;
import com.myapplication.Fragment.FourthFragment;
import com.myapplication.Fragment.MainFragment;
import com.myapplication.Fragment.SartscreenFragment;
import com.myapplication.Fragment.SearchFragment;
import com.myapplication.Fragment.StartrealscreenFragment;
import com.myapplication.R;
import com.myapplication.Utils.DrawFromBackTransformer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.myapplication.Fragment.MainFragment.mLVRingProgress;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public  ViewPager viewPager, viewPager1;
    MainViewPagerAdapter mainViewPagerAdapter;
    MainViewPager1Adapter mainViewPager1Adapter;

    FrameLayout  frm1, frm2, frm3, frm4, frm5;
    ImageView imv1, imv2, imv3, imv4, imv5;
    FrameLayout lytcontainer;

    final Handler mHandler = new Handler();
    Timer mTimer = new Timer();
    int timestamp=0;

    Fragment fragment = null;
    Class fragmentClass = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager=(ViewPager)findViewById(R.id.view_pager3);
        mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.setPageTransformer(true, new DrawFromBackTransformer());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    SartscreenFragment.lytappbar.setExpanded(true);
                    SartscreenFragment.scrollView.scrollTo(100,0);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager1=(ViewPager)findViewById(R.id.view_pager4);
        mainViewPager1Adapter=new MainViewPager1Adapter(getSupportFragmentManager());
        viewPager1.setAdapter(mainViewPager1Adapter);
        viewPager1.setPageTransformer(true, new DrawFromBackTransformer());
        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    MainFragment.appBarLayout.setExpanded(true);
                    MainFragment.scrollView1.scrollTo(100,0);

                    mTimer.cancel();
                    mTimer = null;

                }else if(position==1){

                  timestamp=0;

                    if (mTimer != null) {
                        mTimer.cancel();
                        mTimer = null;
                    }

                    mTimer = new Timer();
                    MyTimerTask task = new MyTimerTask();
                    mTimer.schedule(task, 0, 3000);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        lytcontainer=(FrameLayout)findViewById(R.id.frm_container);

        viewPager.setVisibility(View.VISIBLE);
        lytcontainer.setVisibility(View.GONE);
        viewPager1.setVisibility(View.GONE);





        frm1=(FrameLayout)findViewById(R.id.lyt_start1);
        frm1.setOnClickListener(this);
        frm2=(FrameLayout)findViewById(R.id.lyt_start2);
        frm2.setOnClickListener(this);
        frm3=(FrameLayout)findViewById(R.id.lyt_start3);
        frm3.setOnClickListener(this);
        frm4=(FrameLayout)findViewById(R.id.lyt_start4);
        frm5=(FrameLayout)findViewById(R.id.lyt_start5);
        frm4.setOnClickListener(this);
        frm5.setOnClickListener(this);

        imv1=(ImageView)findViewById(R.id.imv_start1);
        imv2=(ImageView)findViewById(R.id.imv_start2);
        imv3=(ImageView)findViewById(R.id.imv_start3);
        imv4=(ImageView)findViewById(R.id.imv_start4);
        imv5=(ImageView)findViewById(R.id.imv_start5);
        imv1.setVisibility(View.GONE);
        imv2.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.VISIBLE);
        imv4.setVisibility(View.VISIBLE);
        imv5.setVisibility(View.VISIBLE);







    }

    public void setstatus(){
        MainFragment.mLVRingProgress.setProgress(timestamp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.lyt_start1:
                viewPager.setVisibility(View.VISIBLE);
                viewPager.setAdapter(mainViewPagerAdapter);
                viewPager.setPageTransformer(true, new DrawFromBackTransformer());
                lytcontainer.setVisibility(View.GONE);
                viewPager1.setVisibility(View.GONE);
                tap1();
                break;
            case R.id.lyt_start2:
                viewPager.setVisibility(View.GONE);
                lytcontainer.setVisibility(View.GONE);
                viewPager1.setVisibility(View.VISIBLE);
                viewPager1.setCurrentItem(0,true);
                tap2();
                break;
            case R.id.lyt_start3:

                viewPager.setVisibility(View.GONE);
                lytcontainer.setVisibility(View.VISIBLE);
                viewPager1.setVisibility(View.GONE);
                beginTransction(new SearchFragment());
                tap3();
                break;
            case R.id.lyt_start4:
                viewPager.setVisibility(View.GONE);
                lytcontainer.setVisibility(View.VISIBLE);
                viewPager1.setVisibility(View.GONE);
                beginTransction(new FourthFragment());
                tap4();
                break;
            case R.id.lyt_start5:
                viewPager.setVisibility(View.GONE);
                lytcontainer.setVisibility(View.VISIBLE);
                viewPager1.setVisibility(View.GONE);
                beginTransction(new FifthFragment());
                tap5();
                break;
        }
    }

    public void tap1(){
        imv1.setVisibility(View.GONE);
        imv2.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.VISIBLE);
        imv4.setVisibility(View.VISIBLE);
        imv5.setVisibility(View.VISIBLE);
    }
    public void tap2(){
        imv2.setVisibility(View.GONE);
        imv1.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.VISIBLE);
        imv4.setVisibility(View.VISIBLE);
        imv5.setVisibility(View.VISIBLE);
    }
    public void tap3(){
        imv1.setVisibility(View.VISIBLE);
        imv2.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.GONE);
        imv4.setVisibility(View.VISIBLE);
        imv5.setVisibility(View.VISIBLE);
    }
    public void tap4(){
        imv1.setVisibility(View.VISIBLE);
        imv2.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.VISIBLE);
        imv4.setVisibility(View.GONE);
        imv5.setVisibility(View.VISIBLE);
    }
    public void tap5(){
        imv1.setVisibility(View.VISIBLE);
        imv2.setVisibility(View.VISIBLE);
        imv3.setVisibility(View.VISIBLE);
        imv4.setVisibility(View.VISIBLE);
        imv5.setVisibility(View.GONE);
    }

    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {


                    setstatus();
                    timestamp+=5;
                }
            });
        }
    }

    public void beginTransction(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frm_container, fragment);
        // transaction.addToBackStack(null);
        transaction.commit();

    }
}
