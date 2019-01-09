package pram.techvedika.com.drivermain;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static pram.techvedika.com.drivermain.R.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Switch mSwitch;
    private ImageView mNavigationArrow;
    private Dialog mVerificationDialog,mDriverRequestDialog,mSurgeEffectDialog;
    private BottomSheetDialog mDriverstartedRide;
    private Button mVerify;
    private RatingBar mRating;
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(id.map);
        mapFragment.getMapAsync(this);
        //Switch functionality
        mSwitch=(Switch)findViewById(id.switch_one);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mSwitch.setText("ONLINE  ");
                }
                else
                {
                    mSwitch.setText("OFFLINE  ");
                }
            }
        });
        //setting color for the navigation arrow image
        mNavigationArrow=(ImageView) findViewById(id.img_nav_arrow);
        mNavigationArrow.setColorFilter(Color.GRAY);
        //a custom dialog for displaying the verification popup
        mVerificationDialog=new Dialog(this);
        mVerificationDialog.setContentView(layout.driver_start);
        mVerificationDialog.setCancelable(false);
        //mVerificationDialog.show();
        //if we click on ok button,the verification dialog will get closed,offline switch turns into online
        mVerify=(Button)mVerificationDialog.findViewById(id.btn_dialog_ok);
        mVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVerificationDialog.dismiss();
                mSwitch.setChecked(true);
            }
        });
        //setting the driver request dialog
        mDriverRequestDialog=new Dialog(this);
        mDriverRequestDialog.setContentView(layout.driver_ride_request);
        mDriverRequestDialog.setCancelable(false);
        Window window=mDriverRequestDialog.getWindow();
        WindowManager.LayoutParams wlp=window.getAttributes();
        wlp.gravity= Gravity.CENTER;
        // mDriverRequestDialog.show();
        //setting the surge effect dialog
        mSurgeEffectDialog=new Dialog(this);
        mSurgeEffectDialog.setContentView(layout.surgefare);
        Window window1=mSurgeEffectDialog.getWindow();
        window1.setBackgroundDrawableResource(color.colorTransparent);
        WindowManager.LayoutParams wlp1=window1.getAttributes();
        wlp1.gravity=Gravity.BOTTOM;
        mSurgeEffectDialog.setCancelable(false);
        //mSurgeEffectDialog.show();
        //Dialog Trip Earning
        Dialog mTripEarning=new Dialog(this);
        mTripEarning.setContentView(layout.driver_tripfare);
        mTripEarning.setCancelable(false);

        //dialog trip toll
        Dialog mTripToll=new Dialog(this);
        mTripToll.setContentView(layout.driver_apply_toll);
        mTripToll.setCancelable(false);

        //action on the checkbox toll fee
        final TextInputLayout textInputLayout=(TextInputLayout)mTripToll.findViewById(id.ed_toll_fee);
        final CheckBox mTollfee=(CheckBox)mTripToll.findViewById(id.check_tollApply);
        mTollfee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView==mTollfee)
                {
                    if(isChecked)
                    {
                        textInputLayout.setVisibility(View.VISIBLE);
                        mTollfee.setButtonDrawable(drawable.ic_check_box);

                    }
                    else
                    {
                        textInputLayout.setVisibility(View.GONE);

                        mTollfee.setButtonDrawable(drawable.ic_check_box_outline_blank);
                    }
                }
            }
        });
        //action for the check box airport fees
        final CheckBox mAirportFee=(CheckBox)mTripToll.findViewById(id.check_AirportFees);
        mAirportFee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView==mAirportFee)
                {
                    if(isChecked)
                    {
                        mAirportFee.setButtonDrawable(drawable.ic_check_box);
                    }
                    else
                    {
                        mAirportFee.setButtonDrawable(drawable.ic_check_box_outline_blank);
                    }
                }
            }
        });
        //Bottom sheet Behaviour
        mDriverstartedRide=new BottomSheetDialog(this);
        View mSheetView=this.getLayoutInflater().inflate(layout.driverstarted,null);
        mDriverstartedRide.setContentView(mSheetView);
        //mDriverstartedRide.setCancelable(false);
        mDriverstartedRide.show();
        //mTripEarning.show();
        mTripToll.show();
        //Rating bar actions
        mRating=(RatingBar)mDriverstartedRide.findViewById(id.rating2);
        mRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mRating.setRating(4);
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sunnyvalle = new LatLng(	37.368832, 	-122.036346);
        mMap.addMarker(new MarkerOptions().position(sunnyvalle).title("Marker in SunnyVale"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sunnyvalle));
    }
}
