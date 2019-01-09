package pram.techvedika.com.driverprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private String[] mDriverDocuments={"Background Check","Insurance verification","Vehicle Inspection","Credit Check","Languages","Random Drug Testing","Rating","Driver new or actual number of rides"};
    private RecyclerView mRecyclerview_documents;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mMyRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview_documents=(RecyclerView)findViewById(R.id.recyclerview_driver_documents);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerview_documents.setLayoutManager(mLayoutManager);
        mMyRecyclerViewAdapter=new MyRecyclerViewAdapter(this,mDriverDocuments);
        mRecyclerview_documents.setAdapter(mMyRecyclerViewAdapter);
    }
}
