package pram.techvedika.com.scheduledriderequests;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    List mScheduledList;
    Mytrips mytrips;
    int length;
    MyAdapter(Context context,List mScheduledList,int length)
    {
        this.context=context;
        this.mScheduledList=mScheduledList;
        this.length=length;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInlater=LayoutInflater.from(parent.getContext());
        View mRecyclerView=mLayoutInlater.inflate(R.layout.layout_recyclerview,parent,false);
        return new MyViewHolder(mRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Iterator<Mytrips> mIterator=mScheduledList.iterator();
        while (mIterator.hasNext())
        {
            mytrips=mIterator.next();
            holder.txt_mTimings.setText(mytrips.getTimings(position));
            holder.txt_mStartPoint.setText(mytrips.getStartingpoint(position));
            holder.txt_mEndPoint.setText(mytrips.getEndingpoint(position));
        }
        if(holder.getAdapterPosition()==0)
        {
            holder.mButAccept.setVisibility(View.VISIBLE);
            holder.mButDecline.setVisibility(View.VISIBLE);
            holder.mImgDeclined.setVisibility(View.GONE);
        }
        if(holder.getAdapterPosition()==1)
        {
            holder.mButAccept.setVisibility(View.GONE);
            holder.mButDecline.setVisibility(View.GONE);
            holder.mImgDeclined.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_mTimings,txt_mStartPoint,txt_mEndPoint;
        Button mButAccept,mButDecline;
        ImageView mImgDeclined;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_mTimings=(TextView)itemView.findViewById(R.id.txt_timings);
            txt_mStartPoint=(TextView)itemView.findViewById(R.id.txt_startpoint);
            txt_mEndPoint=(TextView)itemView.findViewById(R.id.txt_endpoint);
            mButAccept=(Button)itemView.findViewById(R.id.but_accept);
            mButDecline=(Button)itemView.findViewById(R.id.but_decline);
            mImgDeclined=(ImageView)itemView.findViewById(R.id.img_declined);
        }
    }
}
