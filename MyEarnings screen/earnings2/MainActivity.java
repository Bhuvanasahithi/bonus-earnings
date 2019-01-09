package pram.techvedika.com.earnings2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Fragment mTodayFragment,mThisWeekFragment;
    private FrameLayout mFragment_place;
    private TabLayout mTabLayout;
    private TabItem mTabToday,mTabThisweek;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private ImageView mImg_calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTodayFragment=new fragment_today();
        mThisWeekFragment=new fragment_this_week();
        mTabLayout=(TabLayout)findViewById(R.id.layout_tabs);
         mFragmentManager=getSupportFragmentManager();
         mFragmentTransaction=mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_place,mTodayFragment);
        mFragmentTransaction.commit();
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 mFragmentTransaction=mFragmentManager.beginTransaction();
                switch (tab.getPosition())
                {
                    case 0:
                    {
                        mFragmentTransaction.replace(R.id.fragment_place,mTodayFragment);
                        mFragmentTransaction.commit();
                    }
                    break;
                    case 1:
                    {

                        mFragmentTransaction.replace(R.id.fragment_place,mThisWeekFragment);
                        mFragmentTransaction.commit();
                    }
                    break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*action for the image view calendar*/
        final DatePicker mDatepicker=(DatePicker)findViewById(R.id.datepicker);
        mDatepicker.setVisibility(View.GONE);
        mImg_calendar=(ImageView)findViewById(R.id.imgbut_calendar);
        mImg_calendar.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new MyDatePicker();
                dialogFragment.show(getSupportFragmentManager(),"date picker");
            }
        });
    }
}
