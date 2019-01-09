package pram.techvedika.com.myearnings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecyclerViewWeekAdapter extends RecyclerView.Adapter<MyRecyclerViewWeekAdapter.MyViewHolderWeek>{
    Context context;
    String[] mWeekTripDate,mWeekTripsNumber,mWeekTripHours,mWeekTripEarnings;
    MyRecyclerViewWeekAdapter(Context context,String[] mWeekTripDate,String[] mWeekTripsNumber,String[] mWeekTripHours,String[] mWeekTripEarnings)
    {
        this.context=context;
        this.mWeekTripDate=mWeekTripDate;
        this.mWeekTripsNumber=mWeekTripsNumber;
        this.mWeekTripHours=mWeekTripHours;
        this.mWeekTripEarnings=mWeekTripEarnings;
    }

    @NonNull
    @Override
    public MyViewHolderWeek onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
        View mView=mLayoutInflater.inflate(R.layout.layout_earningdetails_week,parent,false);
        return new MyRecyclerViewWeekAdapter.MyViewHolderWeek(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderWeek holder, int position) {

        holder.mTxt_week_trips_date.setText(mWeekTripDate[position]);
        holder.mTxt_week_trips_number.setText(mWeekTripsNumber[position]);
        holder.mTxt_week_trips_hours.setText(mWeekTripHours[position]);
        holder.mTxt_week_trips_earnings.setText(mWeekTripEarnings[position]);
    }

    @Override
    public int getItemCount() {
        return mWeekTripDate.length;
    }

    class MyViewHolderWeek extends RecyclerView.ViewHolder
    {
        TextView mTxt_week_trips_date,mTxt_week_trips_number,mTxt_week_trips_hours,mTxt_week_trips_earnings;
        public MyViewHolderWeek(@NonNull View itemView) {
            super(itemView);
            mTxt_week_trips_date=(TextView)itemView.findViewById(R.id.txt_trip_date_week);
            mTxt_week_trips_number=(TextView)itemView.findViewById(R.id.txt_trips_week);
            mTxt_week_trips_hours=(TextView)itemView.findViewById(R.id.txt_trips_hours_week);
            mTxt_week_trips_earnings=(TextView)itemView.findViewById(R.id.txt_trips_earnings_week);
        }
    }
}
