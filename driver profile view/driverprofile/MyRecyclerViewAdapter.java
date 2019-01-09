package pram.techvedika.com.driverprofile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    String[] mDriverDocuments;
    LayoutInflater mLayoutInflater;
    MyRecyclerViewAdapter(Context context,String[] mDriverDocuments)
    {
        this.context=context;
        this.mDriverDocuments=mDriverDocuments;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater=LayoutInflater.from(parent.getContext());
        View view=mLayoutInflater.inflate(R.layout.driverdocuments,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mtxt_driver_documents.setText(mDriverDocuments[position]);
    }

    @Override
    public int getItemCount() {
        return mDriverDocuments.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtxt_driver_documents;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxt_driver_documents=(TextView)itemView.findViewById(R.id.txt_driver_documents);
        }
    }
}
