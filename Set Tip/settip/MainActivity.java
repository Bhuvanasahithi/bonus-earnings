package pram.techvedika.com.settip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] percentages=new String[100];
    Spinner spinner;
    MySpinnerAdapter mySpinnerAdapter;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner_percentile);
        for(int i=0;i<100;i++)
        {
           String num=String.format("%02d",i);
           percentages[i]=num;
        }
        mySpinnerAdapter=new MySpinnerAdapter(this,percentages);
        spinner.setAdapter(mySpinnerAdapter);
    }
}
