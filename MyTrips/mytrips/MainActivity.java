package pram.techvedika.com.mytrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerview_mytrips;
    MyReCyclerViewAdapter mMyRecyclerviewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    DividerItemDecoration mDividerItemDecoration;
    List mList;
    Mytrips mMytrips;
    String[] mTimings={"July 28 2018-11:30AM","July 24 2018-10:20AM","July 13 2018-02:36PM","Aug 25 2018-10:30PM","June 24 2018-10:20AM"};
    String[] mStartpoint={"1039 E EL Camino Real,SunnyVale,CA 95014","1039 E EL Camino Real,SunnyVale,CA 95014","1039 E EL Camino Real,SunnyVale,CA 95014","1039 E EL Camino Real,SunnyVale,CA 95014","1039 E EL Camino Real,SunnyVale,CA 95014"};
    String[] mEndpoint={"3705 Tertena pl,Santa clara,CA 95951","3705 Tertena pl,Santa clara,CA 95951","3705 Tertena pl,Santa clara,CA 95951","3705 Tertena pl,Santa clara,CA 95951","3705 Tertena pl,Santa clara,CA 95951"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating the array list
        mList=new ArrayList<Mytrips>();
        //setting the data inside the mytrips object
        mMytrips=new Mytrips();
        //for loop for inserting the data
        for(int i=0;i<mTimings.length;i++) {
            mMytrips.setTimings(mTimings[i],i);
            mMytrips.setStartingpoint(mStartpoint[i],i);
            mMytrips.setEndingpoint(mEndpoint[i],i);
        }
        mList.add(mMytrips);
        mRecyclerview_mytrips=(RecyclerView)findViewById(R.id.recyclerview_mytrips);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerview_mytrips.setLayoutManager(mLayoutManager);
        mMyRecyclerviewAdapter=new MyReCyclerViewAdapter(this,mList,mTimings.length);
        mRecyclerview_mytrips.setAdapter(mMyRecyclerviewAdapter);
        mDividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mRecyclerview_mytrips.addItemDecoration(mDividerItemDecoration);
    }
}
