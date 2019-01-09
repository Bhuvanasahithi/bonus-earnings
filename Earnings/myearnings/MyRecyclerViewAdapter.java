package pram.techvedika.com.myearnings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>
{
    Context mContext;
    String[] mTripdistance,mTriptime,mRidetip,mPramfee,mYourearnings;
    MyRecyclerViewAdapter(Context mContext, String[] mTripdistance,String[] mTriptime,String[] mRidetip,String[] mPramfee,String[] mYourearnings)
    {
        this.mContext=mContext;
        this.mTripdistance=mTripdistance;
        this.mTriptime=mTriptime;
        this.mRidetip=mRidetip;
        this.mPramfee=mPramfee;
        this.mYourearnings=mYourearnings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
        View mView=mLayoutInflater.inflate(R.layout.layout_earningdetails,parent,false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(position==0)
        {
            holder.mtxt_trip_distance.setTextSize(10);
            holder.mtxt_trip_time.setTextSize(10);
            holder.mtxt_ride_tip.setTextSize(10);
            holder.mtxt_pram_fee.setTextSize(10);
            holder.mtxt_your_earnings.setTextSize(10);
        }
        holder.mtxt_trip_distance.setText(mTripdistance[position]);
        holder.mtxt_trip_time.setText(mTriptime[position]);
        holder.mtxt_ride_tip.setText(mRidetip[position]);
        holder.mtxt_pram_fee.setText(mPramfee[position]);
        holder.mtxt_your_earnings.setText(mYourearnings[position]);
    }

    @Override
    public int getItemCount() {
        return mTripdistance.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtxt_trip_distance,mtxt_trip_time,mtxt_ride_tip,mtxt_pram_fee,mtxt_your_earnings;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxt_trip_distance=(TextView)itemView.findViewById(R.id.txt_trip_distance);
            mtxt_trip_time=(TextView)itemView.findViewById(R.id.txt_trip_time);
            mtxt_ride_tip=(TextView)itemView.findViewById(R.id.txt_ride_tip);
            mtxt_pram_fee=(TextView)itemView.findViewById(R.id.txt_pram_fee);
            mtxt_your_earnings=(TextView)itemView.findViewById(R.id.txt_your_earnings);
        }
    }
}
