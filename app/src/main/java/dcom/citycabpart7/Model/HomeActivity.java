package dcom.citycabpart7.Model;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.widget.ImageView;

import dcom.citycabpart7.BottomSheetRiderFragment;
import dcom.citycabpart7.R;

public class HomeActivity extends AppCompatActivity {



    ImageView imgExpandable;
    BottomSheetRiderFragment mBottomSheet;
    Button btnPickupRequest;
    Marker mUseMaker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);

        ImageView imgExpandable;
        final BottomSheetRiderFragment mBottomSheet;


        imgExpandable=findViewById(R.id.imgExpandable);
        mBottomSheet=BottomSheetRiderFragment.newInstance("Rider bottom sheet");
        imgExpandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheet.show(getSupportFragmentManager(),mBottomSheet.getTag());


            }
        });

        btnPickupRequest=(Button)findViewById(R.id.btnPickupRequest);
        btnPickupRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPickupHere(FirebaseAuth.getInstance().getCurrentUser().getUid());

            }
        });


    }

    private void requestPickupHere(String uid)
    {
        DatabaseReference dbRequest= FirebaseDatabase.getInstance().getReference("PickupRequest");
        GeoFire mGeoFire=new GeoFire(dbRequest);
        mGeoFire.setLocation(uid,new Geolocation(mLastLocation.getLatitude(),mLastLocation.getLongitude()));

        if(mUserMarker.isVisible())
            mUserMarker.remove();

          mUseMaker=mMap.addMarker(new  MarkerOptions()).title("pickup Here").snipper(" ")
                  .position(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()))
                  .icon(BitmapDescriptorFactory.defaultMrker(BitmapDescriptorFactory.HUE_RED));

          mUseMaker.showInfoWindow();

          btnPickupRequest.setText("Getting Your Driver");


    }

    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        mMap.getUiSettings.setZoomControlEnabled(true);
        mMap.getUiSettings.setZoomGesturesEnabled(true);
        mMap.setInfoWindowAdapter(new CustomInfoWindow(this));

    }

}
