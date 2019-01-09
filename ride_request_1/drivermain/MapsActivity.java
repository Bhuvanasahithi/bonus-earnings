package pram.techvedika.com.drivermain;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.xmlpull.v1.XmlPullParser;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Switch mSwitch;
    private ImageView mNavigationArrow;
    private Dialog mVerificationDialog,mDriverRequestDialog,mSurgeEffectDialog;
    private Button mVerify;
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Switch functionality
        mSwitch=(Switch)findViewById(R.id.switch_one);
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
        mNavigationArrow=(ImageView) findViewById(R.id.img_nav_arrow);
        mNavigationArrow.setColorFilter(Color.GRAY);
        //a custom dialog for displaying the verification popup
        mVerificationDialog=new Dialog(this);
        mVerificationDialog.setContentView(R.layout.driver_start);
        mVerificationDialog.setCancelable(false);
        //mVerificationDialog.show();
        //if we click on ok button,the verification dialog will get closed,offline switch turns into online
        mVerify=(Button)mVerificationDialog.findViewById(R.id.btn_dialog_ok);
        mVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVerificationDialog.dismiss();
                mSwitch.setChecked(true);
            }
        });
        //setting the driver request dialog
        mDriverRequestDialog=new Dialog(this);
        mDriverRequestDialog.setContentView(R.layout.driver_ride_request);
        mDriverRequestDialog.setCancelable(false);
        Window window=mDriverRequestDialog.getWindow();
        WindowManager.LayoutParams wlp=window.getAttributes();
        wlp.gravity= Gravity.CENTER;
        mDriverRequestDialog.show();
        //setting the surge effect dialog
        mSurgeEffectDialog=new Dialog(this);
        mSurgeEffectDialog.setContentView(R.layout.surgefare);
        Window window1=mSurgeEffectDialog.getWindow();
        WindowManager.LayoutParams wlp1=window1.getAttributes();
        wlp1.gravity=Gravity.BOTTOM;
        mSurgeEffectDialog.setCancelable(false);
        mSurgeEffectDialog.show();

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
