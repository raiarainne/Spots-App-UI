package com.myapplication.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapplication.Activity.CartActivity;
import com.myapplication.Activity.MainActivity;
import com.myapplication.R;

import java.util.Calendar;


public class CartlistsecondFragment extends Fragment implements View.OnClickListener {

    View view;
    CartActivity mainActivity;
    LinearLayout lytbtn;

    TextView firstdate1, firstdate2, firstdate3, seconddate1, seconddat2, seconddate3;

    int i=0;  //

    public static CartlistsecondFragment newInstance() {
        CartlistsecondFragment f = new CartlistsecondFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cartlistsecond, container, false);
        lytbtn=(LinearLayout)view.findViewById(R.id.lyt_clickbutton);
        lytbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        firstdate1=(TextView)view.findViewById(R.id.txv_firstdate1);
        firstdate1.setOnClickListener(this);
        firstdate2=(TextView)view.findViewById(R.id.txv_firstdate2);
        firstdate2.setOnClickListener(this);
        firstdate3=(TextView)view.findViewById(R.id.txv_firstdate3);
        firstdate3.setOnClickListener(this);

        seconddate1=(TextView)view.findViewById(R.id.txv_seconddate1);
        seconddate1.setOnClickListener(this);
        seconddat2=(TextView)view.findViewById(R.id.txv_seconddate2);
        seconddat2.setOnClickListener(this);
        seconddate3=(TextView)view.findViewById(R.id.txv_seconddate3);
        seconddate3.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txv_firstdate1:
                i=1;
                SelectDateFragment fragment = new SelectDateFragment();
                fragment.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
            case R.id.txv_firstdate2:
                i=2;
                SelectDateFragment fragment2 = new SelectDateFragment();
                fragment2.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
            case R.id.txv_firstdate3:
                i=3;
                SelectDateFragment fragment3 = new SelectDateFragment();
                fragment3.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
            case R.id.txv_seconddate1:
                i=4;
                SelectDateFragment fragment4 = new SelectDateFragment();
                fragment4.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
            case R.id.txv_seconddate2:
                i=5;
                SelectDateFragment fragment5 = new SelectDateFragment();
                fragment5.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
            case R.id.txv_seconddate3:
                i=6;
                SelectDateFragment fragment6 = new SelectDateFragment();
                fragment6.show(mainActivity.getFragmentManager(), "DatePicker");
                break;
        }

    }


    public class SelectDateFragment extends android.app.DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm + 1, dd);
        }

        public void populateSetDate(int year, int month, int day) {
            //  date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
            String  date=String.valueOf(day)+"."+String.valueOf(month)+"."+String.valueOf(year);
            if(i==1){
                firstdate1.setText(date);
            }else if(i==2){
                firstdate2.setText(date);
            }else if(i==3){
                firstdate3.setText(date);
            }else if(i==4){
                seconddate1.setText(date);
            }else if(i==5){
                seconddat2.setText(date);
            }else if(i==6){
                seconddate3.setText(date);
            }

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mainActivity = (CartActivity)context;

    }
}
