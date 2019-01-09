package pram.techvedika.com.earnings2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class fragment_this_week extends Fragment {
    String[] mWeekTripDate={"Date\t\t\t","Aug 04,2018(Sat)","Aug 03,2018(Fri)","Aug 02,2018(Thu)","Aug 01,2018(Wed)","July 31,2018(Tue)"};
    String[] mWeekTripsNumber={"Trips","12","6","8","10","2"};
    String[] mWeekTripHours={"Hours","9h 50m","7h 26m","5h 10m","4h 20m","4h 20m"};
    String[] mWeekTripEarnings={"Earnings","$110.40","$56.40","$78.40","$42.80","$32.20"};
    private RecyclerView mRecyclerView_this_week;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecoration;
    private MyRecyclerViewWeekAdapter mMyRecyclerViewWeekAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1= inflater.inflate(R.layout.fragment_fragment_this_week, container, false);
        mRecyclerView_this_week=(RecyclerView)view1.findViewById(R.id.recyclerview_trip_details_week);
        mMyRecyclerViewWeekAdapter=new MyRecyclerViewWeekAdapter(getContext(),mWeekTripDate,mWeekTripsNumber,mWeekTripHours,mWeekTripEarnings);
        mRecyclerView_this_week.setAdapter(mMyRecyclerViewWeekAdapter);
        mLayoutManager=new LinearLayoutManager(getContext());
        mItemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        mRecyclerView_this_week.addItemDecoration(mItemDecoration);
        mRecyclerView_this_week.setLayoutManager(mLayoutManager);
        return view1;
    }








}
