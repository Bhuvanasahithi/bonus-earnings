package pram.techvedika.com.myearnings;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    String[] mTripdistance={"Trip Distance","8.5 mi","6.6 mi","2.4 mi","12.1 mi","26.6 mi"};
    String[] mTriptime={"Trip Time","18 min","26 min","6 min","26 min","57 min"};
    String[] mRidetip={"Ride & tip","$23 + $11","$18 + $10","$8 + $0","$31 + $0","$80 + $21"};
    String[] mPramfee={"Pram Fee","$4.60","$3.60","$1.60","$6.20","$16.00"};
    String[] mYourearnings={"Your Earnings","$29.40","$24.40","$6.40","$24.80","$85.00"};
    //arrays related to the week trip earnings
    String[] mWeekTripDate={"Date\t\t\t","Aug 04,2018(Sat)","Aug 03,2018(Fri)","Aug 02,2018(Thu)","Aug 01,2018(Wed)","July 31,2018(Tue)"};
    String[] mWeekTripsNumber={"Trips","12","6","8","10","2"};
    String[] mWeekTripHours={"Hours","9h 50m","7h 26m","5h 10m","4h 20m","4h 20m"};
    String[] mWeekTripEarnings={"Earnings","$110.40","$56.40","$78.40","$42.80","$32.20"};
    RecyclerView mRecyclerView_earningdetails,mRecyclerView_earning_details_week;
    MyRecyclerViewAdapter mMyRecyclerViewAdapter;
    MyRecyclerViewWeekAdapter mMyRecyclerViewWeekAdapter;
    RecyclerView.ItemDecoration mItemDecoration;
    //Buttons
    private Button mToday,mThisWeek;
    //Relative layouts
    RelativeLayout mLayoutToday,mLayoutThisWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView_earningdetails=(RecyclerView)findViewById(R.id.recyclerview_trip_details);
        mMyRecyclerViewAdapter=new MyRecyclerViewAdapter(this,mTripdistance,mTriptime,mRidetip,mPramfee,mYourearnings);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager1=new LinearLayoutManager(this);
        mRecyclerView_earningdetails.setLayoutManager(mLayoutManager);
       mRecyclerView_earningdetails.setAdapter(mMyRecyclerViewAdapter);
       mItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
       mRecyclerView_earningdetails.addItemDecoration(mItemDecoration);
       //recycler view for week details
        mRecyclerView_earning_details_week=(RecyclerView)findViewById(R.id.recyclerview_trip_details_week);
        mMyRecyclerViewWeekAdapter=new MyRecyclerViewWeekAdapter(this,mWeekTripDate,mWeekTripsNumber,mWeekTripHours,mWeekTripEarnings);
        mRecyclerView_earning_details_week.setAdapter(mMyRecyclerViewWeekAdapter);
        mRecyclerView_earning_details_week.setLayoutManager(mLayoutManager1);
        mRecyclerView_earning_details_week.addItemDecoration(mItemDecoration);
        //actions for the buttons today and this week
        mToday=(Button)findViewById(R.id.but_today);
        mThisWeek=(Button)findViewById(R.id.but_ThisWeek);
        mLayoutToday=(RelativeLayout)findViewById(R.id.layout_today);
        mLayoutThisWeek=(RelativeLayout)findViewById(R.id.layout_this_week);
        mLayoutToday.setVisibility(View.VISIBLE);
        mLayoutThisWeek.setVisibility(View.GONE);
        mToday.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                mToday.setBackground(getResources().getDrawable(R.drawable.button_bottom_style));
                mLayoutToday.setVisibility(View.VISIBLE);
                mLayoutThisWeek.setVisibility(View.GONE);
                mThisWeek.setBackgroundResource(0);

            }
        });
        mThisWeek.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                mThisWeek.setBackground(getResources().getDrawable(R.drawable.button_bottom_style));
                mLayoutThisWeek.setVisibility(View.VISIBLE);
                mLayoutToday.setVisibility(View.GONE);
                mToday.setBackgroundResource(0);
            }
        });
    }
}
