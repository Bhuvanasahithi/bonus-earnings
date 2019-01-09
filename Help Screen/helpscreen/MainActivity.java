package pram.techvedika.com.helpscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    private String[] questions={"Lorem Ipsum is simply dummy text?","Lorem Ipsum is simply dummy text?","Lorem Ipsum is simply dummy text?","Lorem Ipsum is simply dummy text?","Lorem Ipsum is simply dummy text?"};
    private String[] answers={"Lorem Ipsum is simply dummy text of printing and type setting industry.Lorem ipsum has been the industry standard ever since the 1500's","Lorem Ipsum is simply dummy text of printing and type setting industry.Lorem ipsum has been the industry standard ever since the 1500's","Lorem Ipsum is simply dummy text of printing and type setting industry.Lorem ipsum has been the industry standard ever since the 1500's","Lorem Ipsum is simply dummy text of printing and type setting industry.Lorem ipsum has been the industry standard ever since the 1500's","Lorem Ipsum is simply dummy text of printing and type setting industry.Lorem ipsum has been the industry standard ever since the 1500's"};
    private RecyclerView mRecyclerviewQuestions;
    private MyRecyclerViewAdapter mMyRecyclerViewAdapter;
    private Button mButContact;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.ItemDecoration mItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerviewQuestions=(RecyclerView)findViewById(R.id.recyclerview_questions);
        mMyRecyclerViewAdapter=new MyRecyclerViewAdapter(this,questions,answers);
        mRecyclerviewQuestions.setAdapter(mMyRecyclerViewAdapter);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerviewQuestions.setLayoutManager(mLayoutManager);
        mItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        mRecyclerviewQuestions.addItemDecoration(mItemDecoration);
        //button action
        mButContact=(Button)findViewById(R.id.btn_contact);
        mButContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Contact.class);
                startActivity(i);
            }
        });
    }
}
