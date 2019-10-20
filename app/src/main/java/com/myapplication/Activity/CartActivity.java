package com.myapplication.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.myapplication.Fragment.CartfirstFragment;
import com.myapplication.Fragment.CartlistfourthFragment;
import com.myapplication.Fragment.CartlistsecondFragment;
import com.myapplication.Fragment.CartthirdFragment;
import com.myapplication.R;

public class CartActivity extends AppCompatActivity {

    ImageView firsttransaction, secondtransaction, thirdtransaction, fourthtransaction;
    ImageView firstwhiteiamge, secondwhiteimage, thirdwhiteimage, fourthwhiteimage;
    ImageView firstcompleteimage, secondcompleteimage, thirdcompleteimage, fourthcompleteimage;
    ImageView firstwhiteline, secondwhiteline, thirdwhiteline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        firsttransaction=(ImageView)findViewById(R.id.imv_firsttransaction);
        firsttransaction.setVisibility(View.VISIBLE);
        secondtransaction=(ImageView)findViewById(R.id.imv_secondtransaction);
        secondtransaction.setVisibility(View.GONE);
        thirdtransaction=(ImageView)findViewById(R.id.imv_thirdtransaction);
        thirdtransaction.setVisibility(View.GONE);
        fourthtransaction=(ImageView)findViewById(R.id.imv_fourthtransaction);
        fourthtransaction.setVisibility(View.GONE);

        firstwhiteiamge=(ImageView)findViewById(R.id.imv_firstwhtecircle);
        firstwhiteiamge.setVisibility(View.VISIBLE);
        secondwhiteimage=(ImageView)findViewById(R.id.imv_secondwhiteimage);
        secondwhiteimage.setVisibility(View.VISIBLE);
        secondwhiteimage.setAlpha((float) 0.65);
        thirdwhiteimage=(ImageView)findViewById(R.id.imv_thirdwhiteimage);
        thirdwhiteimage.setAlpha((float) 0.65);
        fourthwhiteimage=(ImageView)findViewById(R.id.imv_fourthwhiteimage);
        fourthwhiteimage.setAlpha((float) 0.65);


        firstcompleteimage=(ImageView)findViewById(R.id.imv_firstcheck);
        firstcompleteimage.setVisibility(View.GONE);
        secondcompleteimage=(ImageView)findViewById(R.id.imv_secondcheck);
        secondcompleteimage.setVisibility(View.GONE);
        thirdcompleteimage=(ImageView)findViewById(R.id.imv_thirdcomplete);
        thirdcompleteimage.setVisibility(View.GONE);
        fourthcompleteimage=(ImageView)findViewById(R.id.imv_fourthcomplete);
        fourthcompleteimage.setVisibility(View.GONE);

        firstwhiteline=(ImageView)findViewById(R.id.imv_firstwhiteline);
        firstwhiteline.setAlpha((float) 0.5);
        secondwhiteline=(ImageView)findViewById(R.id.imv_secondwhiteline);
        secondwhiteline.setAlpha((float) 0.5);
        thirdwhiteline=(ImageView)findViewById(R.id.imv_thirdwhiteline);
        thirdwhiteline.setAlpha((float) 0.5);











        ViewPager pager = (ViewPager) findViewById(R.id.viewper);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0){
                    firstwhiteline.setAlpha((float) (positionOffset+0.5));
                    secondwhiteimage.setAlpha((float) (positionOffset+0.65));
                }else if(position==1){
                    secondwhiteline.setAlpha((float) (positionOffset+0.5));
                    thirdwhiteimage.setAlpha((float) (positionOffset+0.65));
                }else if(position==2){
                    thirdwhiteline.setAlpha((float) (positionOffset+0.5));
                    fourthwhiteimage.setAlpha((float) (positionOffset+0.65));
                }


                Log.d("position===", String.valueOf(position)+" "+String.valueOf(positionOffset)+" "+String.valueOf(positionOffsetPixels));

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    page1selected();
                }else if(position==1){
                    page2selected();
                }else if(position==2){
                    page3selected();
                }else if(position==3){
                    page4selected();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return CartfirstFragment.newInstance();
                case 1: return CartlistsecondFragment.newInstance();
                case 2: return CartthirdFragment.newInstance();
                case 3: return CartlistfourthFragment.newInstance();
                default: return CartfirstFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public void page1selected(){
        firstwhiteline.setAlpha((float) 0.0);
        firstwhiteiamge.setVisibility(View.VISIBLE);
        firsttransaction.setVisibility(View.VISIBLE);
        firstcompleteimage.setVisibility(View.GONE);
        secondtransaction.setVisibility(View.GONE);
    }

    public void page2selected(){
        firstwhiteline.setAlpha((float) 1.0);
        firstwhiteiamge.setVisibility(View.GONE);
        firsttransaction.setVisibility(View.GONE);
        firstcompleteimage.setVisibility(View.VISIBLE);
        secondtransaction.setVisibility(View.VISIBLE);

        thirdtransaction.setVisibility(View.GONE);
        secondcompleteimage.setVisibility(View.GONE);
        secondwhiteimage.setVisibility(View.VISIBLE);
        secondwhiteimage.setAlpha((float) 1.0);


    }
    public void page3selected(){
        secondwhiteline.setAlpha((float) 1.0);
        secondwhiteimage.setVisibility(View.GONE);
        secondtransaction.setVisibility(View.GONE);
        secondcompleteimage.setVisibility(View.VISIBLE);
        thirdtransaction.setVisibility(View.VISIBLE);

        fourthtransaction.setVisibility(View.GONE);
        thirdcompleteimage.setVisibility(View.GONE);
        thirdwhiteimage.setVisibility(View.VISIBLE);
        thirdwhiteimage.setAlpha((float) 1.0);
    }

    public void  page4selected(){
        thirdwhiteline.setAlpha((float) 1.0);
        thirdwhiteimage.setVisibility(View.GONE);
        thirdtransaction.setVisibility(View.GONE);
        thirdcompleteimage.setVisibility(View.VISIBLE);
        fourthtransaction.setVisibility(View.VISIBLE);


    }
}
