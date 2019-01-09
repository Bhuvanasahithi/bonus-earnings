package pram.techvedika.com.mytrips;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyReCyclerViewAdapter extends RecyclerView.Adapter<MyReCyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List mList;
    Mytrips mmytrips1;
    int length;
    MyReCyclerViewAdapter(Context mContext,List mList,int length)
    {
        this.mContext=mContext;
        this.mList=mList;
        this.length=length;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
        View mView=mLayoutInflater.inflate(R.layout.layout_recyclerview,parent,false);
        return new MyViewHolder(mView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Iterator<Mytrips> iter = mList.iterator();
        /*holder.mTxt_progress.setVisibility(View.GONE);
        holder.mTxt_amount_days_left.setVisibility(View.GONE);
        holder.mTxt_leftForRide.setVisibility(View.GONE);*/
        while(iter.hasNext())
        {
            mmytrips1 = iter.next();
            holder.mTxt_timings.setText(mmytrips1.getTimings(position));
            holder.mTxt_startpoint.setText(mmytrips1.getStartingpoint(position));
            holder.mTxt_endpoint.setText(mmytrips1.getEndingpoint(position));
            if(holder.getAdapterPosition()==0)
            {
                holder.mTxt_progress.setVisibility(View.VISIBLE);
                holder.mTxt_progress.setTextSize(10);
                holder.mTxt_amount_days_left.setVisibility(View.GONE);
                holder.mTxt_leftForRide.setVisibility(View.GONE);
            }
            if(holder.getAdapterPosition()==1)
            {
                holder.mTxt_progress.setText("$150.00");
                holder.mTxt_progress.setTextColor(Color.BLACK);
                holder.mTxt_progress.setBackgroundColor(Color.WHITE);
                holder.mTxt_amount_days_left.setText("40mi-56m");
                holder.mTxt_leftForRide.setVisibility(View.GONE);
            }
            if(holder.getAdapterPosition()==2)
            {
                holder.mTxt_progress.setText("$76.00");
                holder.mTxt_progress.setTextColor(Color.BLACK);
                holder.mTxt_progress.setBackgroundColor(Color.WHITE);
                holder.mTxt_amount_days_left.setText("40mi-56m");
                holder.mTxt_leftForRide.setVisibility(View.GONE);
            }
            if(holder.getAdapterPosition()==3)
            {
                holder.itemView.setBackgroundColor(Color.parseColor("#DAF1F7"));
                holder.mTxt_progress.setText("Accepted");
                holder.mTxt_progress.setTextSize(10);
                holder.mTxt_amount_days_left.setText("18 Days");
                holder.mTxt_leftForRide.setText("Left to start ride");
                holder.mTxt_scheduledride.setText("Scheduled Ride");
            }
            if(holder.getAdapterPosition()==4)
            {
                holder.mTxt_progress.setText("$80.00");
                holder.mTxt_progress.setTextColor(Color.BLACK);
                holder.mTxt_progress.setBackgroundColor(Color.WHITE);
                holder.mTxt_amount_days_left.setText("40mi-56m");
                holder.mTxt_leftForRide.setVisibility(View.GONE);

            }


        }


    }

    @Override
    public int getItemCount() {
        return length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
            TextView mTxt_timings,mTxt_startpoint,mTxt_endpoint,mTxt_progress,mTxt_amount_days_left,mTxt_leftForRide,mTxt_scheduledride;
            public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxt_timings=(TextView)itemView.findViewById(R.id.txt_timings);
            mTxt_startpoint=(TextView)itemView.findViewById(R.id.txt_startpoint);
            mTxt_endpoint=(TextView)itemView.findViewById(R.id.txt_endpoint);
            mTxt_progress=(TextView)itemView.findViewById(R.id.txt_progress);
            mTxt_amount_days_left=(TextView)itemView.findViewById(R.id.txt_trip_totalamount_daysleft);
            mTxt_leftForRide=(TextView)itemView.findViewById(R.id.txt_left_to_start_ride);
            mTxt_scheduledride=(TextView)itemView.findViewById(R.id.txt_scheduledride);
        }
    }
}
