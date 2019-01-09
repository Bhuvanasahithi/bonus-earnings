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



public class fragment_today extends Fragment {
    private RecyclerView mRecyclerview_today;
    private MyRecyclerViewAdapter mMyRecyclerView_adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mItemDecor;
    String[] mTripdistance={"Trip Distance","8.5 mi","6.6 mi","2.4 mi","12.1 mi","26.6 mi"};
    String[] mTriptime={"Trip Time","18 min","26 min","6 min","26 min","57 min"};
    String[] mRidetip={"Ride & tip","$23 + $11","$18 + $10","$8 + $0","$31 + $0","$80 + $21"};
    String[] mPramfee={"Pram Fee","$4.60","$3.60","$1.60","$6.20","$16.00"};
    String[] mYourearnings={"Your Earnings","$29.40","$24.40","$6.40","$24.80","$85.00"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_today, container, false);
        mRecyclerview_today=(RecyclerView)view.findViewById(R.id.recyclerview_trip_details);
        mItemDecor=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        mRecyclerview_today.addItemDecoration(mItemDecor);
        mLayoutManager=new LinearLayoutManager(getContext());
        mRecyclerview_today.setLayoutManager(mLayoutManager);
        mMyRecyclerView_adapter=new MyRecyclerViewAdapter(getContext(),mTripdistance,mTriptime,mRidetip,mPramfee,mYourearnings);
        mRecyclerview_today.setAdapter(mMyRecyclerView_adapter);
        return view;
    }








}
