package pram.techvedika.com.withdrawl;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    Context mContext;
    String[] mDate;
    String[] mAmount;
    MyAdapter(Context mContext,String[] mDate,String[] mAmount)
    {
        this.mContext=mContext;
        this.mDate=mDate;
        this.mAmount=mAmount;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater=LayoutInflater.from(parent.getContext());
        View mView1=mLayoutInflater.inflate(R.layout.recycler_view_details,parent,false);
        return new MyHolder(mView1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        if(position==0)
        {
            holder.mTxt_date.setTextSize(14);
            holder.mTxt_amount.setTextSize(14);
            holder.mTxt_date.setTextColor(Color.GRAY);
            holder.mTxt_amount.setTextColor(Color.GRAY);
        }
        holder.mTxt_date.setText(mDate[position]);
        holder.mTxt_amount.setText(mAmount[position]);
    }

    @Override
    public int getItemCount() {
        return mDate.length;
    }

    class MyHolder extends RecyclerView.ViewHolder
    {
        TextView mTxt_date,mTxt_amount;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTxt_date=(TextView)itemView.findViewById(R.id.txt_date);
            mTxt_amount=(TextView)itemView.findViewById(R.id.txt_amount);
         }
    }
}
