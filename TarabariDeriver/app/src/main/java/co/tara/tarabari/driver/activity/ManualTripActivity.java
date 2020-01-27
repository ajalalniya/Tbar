package co.tara.tarabari.driver.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/*import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;*/

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.Trip;
import co.tara.tarabari.driver.myview.MyTextView;
import co.tara.tarabari.driver.state.StateOfDriver;
import co.tara.tarabari.driver.state.StateOfPassenger;
import co.tara.tarabari.driver.utils.ManageMarkers;

/**
 * Created by jalalnia on 6/24/2017.
 */

//public class ManualTripActivity extends AppCompatActivity implements OnMapReadyCallback {
public class ManualTripActivity extends AppCompatActivity  {

    @BindView(R.id.sourceAddress)
    public MyTextView originAddress;
    @BindView(R.id.distinationAddress)
    public MyTextView distinationAddress;
    @BindView(R.id.distinationAddress2)
    public MyTextView distinationAddress2;
    @BindView(R.id.loadDistinationAddress)
    public ProgressBar loadDistinationAddress;
    @BindView(R.id.loadDistinationAddress2)
    public ProgressBar loadDistinationAddress2;
    @BindView(R.id.loadSourceAddress)
    public ProgressBar loadSourceAddress;
    @BindView(R.id.finalTripBtn)
    public MyTextView finalTripBtn;
    @BindView(R.id.sourcePin)
    public ImageView sourcePine;
    @BindView(R.id.carddistination)
    public RelativeLayout distinationCard;
    @BindView(R.id.carddistination2)
    public RelativeLayout distinationCard2;
  //  public GoogleMap googleMap;
    public Trip trip;
  /*  public Marker markerOrgin;
    public Marker markerDistination;
    public Marker markerDistination2;
    public List<Marker> carMarkers;*/
    public int lastPosition = 0;
    public ImageView imgLine;
    public StateOfPassenger stateOfApp;
    private static final String STATEOFAPP = "STATE";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_trip);
        ButterKnife.bind(this);

     /*   SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
        trip = new Trip();
        stateOfApp = new StateOfPassenger(this, getSupportFragmentManager(), 0);
        stateOfApp.setOrginAddress(originAddress);
        stateOfApp.setDistinationAddress(distinationAddress);
      //  stateOfApp.setGoogleMap(googleMap);
        stateOfApp.setLocationPin(sourcePine);
        stateOfApp.setLoadOrginAddress(loadSourceAddress);
        stateOfApp.setLoadDistinationAddress(loadDistinationAddress);
        stateOfApp.setDistinationAddressCard(distinationCard);
        stateOfApp.setDistinationAddressCard2(distinationCard2);
        if (stateOfApp.state == 0) {

            stateOfApp.goToStateNormal();
        }


    }

 /*   @Override
    public void onMapReady(GoogleMap googleMap) {




        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //    stateOfApp = new StateOfDriver(getActivity(), fragmentManager, originAddress, distinationAddress, distinationAddress2, loadSourceAddress, loadDistinationAddress, loadDistinationAddress2, distinationCard, distinationCard2, sourcePine, 0);
        this.googleMap = googleMap;
        stateOfApp.setGoogleMap(googleMap);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onBackPressed() {

        if (stateOfApp.getState() == 0) {
            super.onBackPressed();
        } else if (stateOfApp.getState() == 1) {

            stateOfApp.goToStateNormal();
            stateOfApp.markerOrgin.remove();

        } else if (stateOfApp.getState() == 2) {

            stateOfApp.googleMap.getUiSettings().setAllGesturesEnabled(true);
            stateOfApp.goToStateSelectDistination();
            stateOfApp.markerDestination.remove();
            if (stateOfApp.isSecondTrip()) {
                stateOfApp.setSecondTrip(false);
                stateOfApp.markerDestination2.remove();

            }
        } else if (stateOfApp.getState() == 3) {

            trip.setDistance2(0);
            trip.setAllDistance2(0);
            stateOfApp.setSecondTrip(false);
            stateOfApp.goToStateGetPrice(trip);

        }

    }
    @Override
    protected void onResume() {
        super.onResume();

        if (stateOfApp.sabtBar && stateOfApp.getState() == 1) {

            stateOfApp.goToStateGetPrice(trip);

        }
    }


    @OnClick(R.id.sourcePin)
    public void choiseOrgin() {
        ManageMarkers manageMarkers = new ManageMarkers();
        if (stateOfApp.getState() == 0) {

            trip.setLatOrigin(googleMap.getCameraPosition().target.latitude);
            trip.setLngOrigin(googleMap.getCameraPosition().target.longitude);
            stateOfApp.markerOrgin = manageMarkers.addMarker(googleMap, googleMap.getCameraPosition().target, (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_source), 213, 214);
            stateOfApp.goToStateSelectDistination();

        } else if (stateOfApp.getState() == 1) {

            trip.setLatDestination1(googleMap.getCameraPosition().target.latitude);
            trip.setLngDestination1(googleMap.getCameraPosition().target.longitude);
            stateOfApp.markerDestination = manageMarkers.addMarker(googleMap, new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_destination), 213, 214);
            Intent intent = new Intent(this, LoadActivity1.class);
            intent.putExtra("trip", trip);
            // intent.putExtra("state",  stateOfApp);
            this.startActivity(intent);

            stateOfApp.goToStateGetPrice(trip);
            //stateOfApp.goToStateGetPrice(trip);

        } else if (stateOfApp.getState() == 3) {
            trip.setLatDestination2(googleMap.getCameraPosition().target.latitude);
            trip.setLngDestination2(googleMap.getCameraPosition().target.longitude);
            markerDistination2 = manageMarkers.addMarker(googleMap, new LatLng(trip.getLatDestination2(), trip.getLngDestination2()), (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_destination), 213, 214);
            stateOfApp.setMarkerDestination2(markerDistination2);
            stateOfApp.goToStateGetPrice(trip);
        }


    }

    public void getState(int value, Trip trip) {


        if (value == 1) {
            stateOfApp.goToStateNormal();
        } else if (value == 2) {

            stateOfApp.goToStateGetPrice(trip);
        } else if (value == 3) {


        } else {
            stateOfApp.goToStateNormal();
        }


    }*/
}
