package pram.techvedika.com.withdrawl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import static android.widget.LinearLayout.VERTICAL;


public class MainActivity extends AppCompatActivity {
    private String[] mDate={"Date & Time","Aug 04,2018(Sat) 05:40 PM","Aug 03,2018(Fri) 10:10 PM","Aug 02,2018(Thu) 08:00 PM","Aug 01,2018(Wed) 09:45 PM","Jul 31,2018(Tue) 07:32 PM"};
    private String[] mAmount={"Amount","$110.40","$56.40","$78.40","$42.80","$32.20"};
    private RecyclerView mRecyclerView;
    private DividerItemDecoration mItemDecor;
    private MyAdapter mMyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_list);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mMyAdapter=new MyAdapter(getApplicationContext(),mDate,mAmount);
        mRecyclerView.setAdapter(mMyAdapter);
        mItemDecor= new DividerItemDecoration(this, VERTICAL);
        mRecyclerView.addItemDecoration(mItemDecor);

    }
}
