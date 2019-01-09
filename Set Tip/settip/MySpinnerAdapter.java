package pram.techvedika.com.settip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MySpinnerAdapter extends BaseAdapter {
    Context context;
    String[] percentages;
    MySpinnerAdapter(Context context,String[] percentages)
    {
        this.context=context;
        this.percentages=percentages;
    }
    @Override
    public int getCount() {
        return percentages.length;
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
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        convertView=layoutInflater.inflate(R.layout.spinnerlayout,null);
        TextView textView=(TextView)convertView.findViewById(R.id.txt_spinner);
        textView.setText(percentages[position]+"");
        return convertView;
    }
}
