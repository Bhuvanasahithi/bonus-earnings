package pram.techvedika.com.helpscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    Context context;
    String[] questions,answers;
    LayoutInflater mLayoutInflater;
    MyRecyclerViewAdapter(Context context,String[] questions,String[] answers )
    {
        this.context=context;
        this.questions=questions;
        this.answers=answers;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mLayoutInflater=LayoutInflater.from(parent.getContext());
        View view=mLayoutInflater.inflate(R.layout.recyclerview_data,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.mtxt_questions.setText(questions[position]);
        holder.mtxt_answers.setText(answers[position]);
        holder.mLayout_answers.setVisibility(View.GONE);
        holder.mImg_right_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.mLayout_answers.getVisibility()==View.GONE)
                {
                    holder.mLayout_answers.setVisibility(View.VISIBLE);

                    holder.mImg_right_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down);
                }
                else
                {
                    holder.mLayout_answers.setVisibility(View.GONE);
                    holder.mImg_right_arrow.setImageResource(R.drawable.ic_keyboard_arrow_right);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return questions.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtxt_questions,mtxt_answers;
        RelativeLayout mLayout_answers;
        ImageButton mImg_right_arrow;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxt_questions=(TextView)itemView.findViewById(R.id.txt_questions);
            mtxt_answers=(TextView)itemView.findViewById(R.id.txt_answers);
            mLayout_answers=(RelativeLayout)itemView.findViewById(R.id.layout_answers);
            mImg_right_arrow=(ImageButton)itemView.findViewById(R.id.imgbut_right_arow);
        }
    }
}
