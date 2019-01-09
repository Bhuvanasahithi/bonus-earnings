package pram.techvedika.com.bonusearnings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    Context mContext;
    String[] mBonus;
    LayoutInflater mLayoutInflater;
    CustomAdapter(Context mContext,String[] mBonus)
    {
        this.mContext=mContext;
        this.mBonus=mBonus;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mBonus.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView=mLayoutInflater.inflate(R.layout.earnings_list_view_layout,null);
        final LinearLayout mLinearbonus=(LinearLayout)mView.findViewById(R.id.layout_bonus);
        TextView bonusinfo=(TextView)mView.findViewById(R.id.txt_bonus_information);
        final ImageButton mExpand=(ImageButton)mView.findViewById(R.id.imgbut_right_arrow);
        bonusinfo.setText(mBonus[position]);
        mLinearbonus.setVisibility(View.GONE);
        mExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLinearbonus.getVisibility()==View.GONE)
                {
                    mLinearbonus.setVisibility(View.VISIBLE);
                    mExpand.setImageResource(R.drawable.ic_keyboard_arrow_down);
                 }
                else
                {
                    mLinearbonus.setVisibility(View.GONE);
                    mExpand.setImageResource(R.drawable.ic_keyboard_arrow_right);
                }
            }
        });
        return mView;
    }
}
