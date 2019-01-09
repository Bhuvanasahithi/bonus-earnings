package pram.techvedika.com.changepassword;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.xml.sax.Parser;

import static pram.techvedika.com.changepassword.R.drawable.ic_visibility_off;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText mPassword,mConfirmPassword;
    private TextInputLayout mEtLayout_password,mEtLayout_confirmpassword;
    private RelativeLayout mRelativeLayout,mRelativelayoutPassword;
    private ImageView mImageExpand,mImgNewPassword,mImgNewConfirmPassword,mImgNewPasswordVisible,mImgNewConfirmPasswordVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*mPassword=(TextInputEditText)findViewById(R.id.ed_new_password);
        mConfirmPassword=(TextInputEditText)findViewById(R.id.ed_new_confirm_password) ;*/
        mRelativeLayout=(RelativeLayout)findViewById(R.id.layout_changepassword);
        mRelativelayoutPassword=(RelativeLayout)findViewById(R.id.layout_password_change_options) ;
        mRelativelayoutPassword.setVisibility(View.GONE);
        mImageExpand = (ImageView)findViewById(R.id.img_expand) ;
        /*mImgNewPassword=(ImageView)findViewById(R.id.img_new_password) ;
        mImgNewConfirmPassword=(ImageView)findViewById(R.id.img_new_confirm_password);
        mImgNewPasswordVisible=(ImageView)findViewById(R.id.img_new_password_visible);
        mImgNewConfirmPasswordVisible=(ImageView)findViewById(R.id.img_new_confirm_password_visible);
        mImgNewPasswordVisible.setVisibility(View.GONE);
        mImgNewConfirmPasswordVisible.setVisibility(View.GONE);*/
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mRelativelayoutPassword.getVisibility()==View.GONE)
                {
                    mImageExpand.setImageResource(R.drawable.ic_keyboard_arrow_down);
                    mRelativelayoutPassword.setVisibility(View.VISIBLE);

                }
                else
                {
                    mImageExpand.setImageResource(R.drawable.ic_keyboard_arrow_right);
                    mRelativelayoutPassword.setVisibility(View.GONE);

                }
            }
        });
        //onclick listener methods for the visibility buttons

        /*mImgNewPassword.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                    if (mImgNewPassword.getVisibility() == View.VISIBLE) {
                        mImgNewPassword.setVisibility(View.GONE);
                        mImgNewPasswordVisible.setVisibility(View.VISIBLE);
                        mPassword.setTransformationMethod(null);
                    } else {


                        mImgNewPassword.setVisibility(View.VISIBLE);
                        //mImgNewPasswordVisible.setVisibility(View.GONE);
                        mPassword.setTransformationMethod(new AsterikPasswordTransformationMethod());
                    }

                }



        });
        mImgNewConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mImgNewConfirmPassword.getVisibility()==View.VISIBLE)
                {
                    mImgNewConfirmPassword.setVisibility(View.GONE);
                    mImgNewConfirmPasswordVisible.setVisibility(View.VISIBLE);
                    mConfirmPassword.setTransformationMethod(null);
                }
                else
                {
                    mImgNewConfirmPassword.setVisibility(View.VISIBLE);
                    mImgNewConfirmPasswordVisible.setVisibility(View.GONE);
                    mConfirmPassword.setTransformationMethod(new AsterikPasswordTransformationMethod());
                }
            }
        });


        mPassword.setTransformationMethod(new AsterikPasswordTransformationMethod());

        mConfirmPassword.setTransformationMethod(new AsterikPasswordTransformationMethod());*/
    }


    /*private class AsterikPasswordTransformationMethod implements TransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {


            return new PasswordCharSequence(source);



        }

        @Override
        public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {

        }
    }

    private class PasswordCharSequence implements CharSequence {
        private CharSequence mSource;
        public PasswordCharSequence(CharSequence source) {
            mSource = source; // Store char sequence
        }
        public char charAt(int index) {
            return '*'; // This is the important part
        }
        public int length() {
            return mSource.length(); // Return default
        }
        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end); // Return default
        }
    }*/
}

