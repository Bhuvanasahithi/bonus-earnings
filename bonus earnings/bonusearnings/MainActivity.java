package pram.techvedika.com.bonusearnings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] mBonus={"Sign-Up Bonus","Hourly gurantees for pilot","Completed trips Bonuses"};
    private CustomAdapter mCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.listview_bonus_list);
        mCustomAdapter=new CustomAdapter(this,mBonus);
        mListView.setAdapter(mCustomAdapter);
    }
}
