package pram.techvedika.com.scheduledriderequests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mTimings={"July 28 2018-11:30AM","July 24 2018-10:20AM"};
    private String[] mStartpoint={"1039 E EL Camino Real,SunnyVale,CA 95014","1039 E EL Camino Real,SunnyVale,CA 95014"};
    private String[] mEndpoint={"3705 Tertena pl,Santa clara,CA 95951","3705 Tertena pl,Santa clara,CA 95951"};
    private RecyclerView mScheduledRides;
    private MyAdapter mMyAdapter;
    private List mScheduledList;
    private Mytrips mMyTrips;
    private DividerItemDecoration mDividerItemDecor;
    private  RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScheduledRides=(RecyclerView)findViewById(R.id.recyclerview_mytrips);
        mScheduledList=new ArrayList<Mytrips>();
        mMyTrips=new Mytrips();
        for(int i=0;i<mTimings.length;i++)
        {
            mMyTrips.setTimings(mTimings[i],i);
            mMyTrips.setStartingpoint(mStartpoint[i],i);
            mMyTrips.setEndingpoint(mEndpoint[i],i);
        }
        mScheduledList.add(mMyTrips);
        mDividerItemDecor=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mScheduledRides.addItemDecoration(mDividerItemDecor);
        mMyAdapter=new MyAdapter(this,mScheduledList,mTimings.length);
        mLayoutManager=new LinearLayoutManager(this);
        mScheduledRides.setLayoutManager(mLayoutManager);
        mScheduledRides.setAdapter(mMyAdapter);
    }
}
