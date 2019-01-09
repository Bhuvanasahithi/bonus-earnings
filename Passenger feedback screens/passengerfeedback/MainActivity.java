package pram.techvedika.com.passengerfeedback;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBut_submit;
    private Dialog mFeedbackDialog;
    private Window mWindow;
    private WindowManager.LayoutParams mWindowLayoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBut_submit=(Button)findViewById(R.id.but_submit);
        mFeedbackDialog=new Dialog(this);
        mBut_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFeedbackDialog.setContentView(R.layout.dialog_feedback);
                //getting window parameters
                mWindow=mFeedbackDialog.getWindow();mWindowLayoutParams=mWindow.getAttributes();
                mWindowLayoutParams.y=-130;
                mWindow.setAttributes(mWindowLayoutParams);
                mFeedbackDialog.show();
            }
        });
    }
}
