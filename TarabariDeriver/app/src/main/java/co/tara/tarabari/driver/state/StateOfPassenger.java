package co.tara.tarabari.driver.state;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/*import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;*/

import java.io.Serializable;

import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.fragment.FindDriverFragment;
import co.tara.tarabari.driver.fragment.PriceRequestFragment;
import co.tara.tarabari.driver.model.Trip;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.myview.MyTextView;

/**
 * Created by jalalnia on 6/24/2017.
 */

public class StateOfPassenger implements Serializable {


    public MyTextView address;
    public MyTextView orginAddress;
    public MyTextView distinationAddress;
    public MyTextView distinationAddress2;
    public ProgressBar loadOrginAddress;
    public ProgressBar loadDistinationAddress;
    public ProgressBar loadDistinationAddress2;
    public ProgressBar loadAddress;
    public RelativeLayout distinationAddressCard;
    public RelativeLayout distinationAddressCard2;
    public RelativeLayout relFavoritePlace;
    public RelativeLayout relselectCar;
    public ImageView locationPin;
   // public Marker markerOrgin;
  //  public Marker markerDestination;
  //  public Marker markerDestination2;
  //  public GoogleMap googleMap;
    public boolean secondTrip = false;
    public boolean dialogOpen = false;
    public int state;
    public Activity activity;
    public FragmentManager fragmentManager;
    public StateOfPassenger stateOfApp;
    public boolean sabtBar;


    public StateOfPassenger(Activity activity, FragmentManager fragmentManager, int state) {


        this.activity=activity;
        this.fragmentManager=fragmentManager;
        this.state=state;

    }

    public RelativeLayout getRelFavoritePlace() {
        return relFavoritePlace;
    }

    public void setRelFavoritePlace(RelativeLayout relFavoritePlace) {
        this.relFavoritePlace = relFavoritePlace;
    }

    public RelativeLayout getRelselectCar() {
        return relselectCar;
    }

    public void setRelselectCar(RelativeLayout relselectCar) {
        this.relselectCar = relselectCar;
    }
    /* public StateOfApp(Activity activity, FragmentManager fragmentManager, MyTextView orginAddress, MyTextView distinationAddress, MyTextView distinationAddress2, ProgressBar loadOrginAddress, ProgressBar loadDistinationAddress, ProgressBar loadDistinationAddress2, RelativeLayout distinationAddressCard, RelativeLayout distinationAddressCard2, ImageView locationPin, int state) {

        this.distinationAddressCard = distinationAddressCard;
        this.locationPin = locationPin;
        this.state = state;
        this.address = orginAddress;
        this.distinationAddress = distinationAddress;
        this.orginAddress = orginAddress;
        this.loadDistinationAddress = loadDistinationAddress;
        this.loadOrginAddress = loadOrginAddress;
        this.loadAddress = loadOrginAddress;
        this.distinationAddress2 = distinationAddress2;
        this.distinationAddressCard2 = distinationAddressCard2;
        this.loadDistinationAddress2 = loadDistinationAddress2;
        this.activity = activity;
        this.fragmentManager = fragmentManager;

    }
*/

    public void goToStateNormal() {

        locationPin.setVisibility(View.VISIBLE);
        locationPin.setImageResource(R.drawable.placeholder_source);
        distinationAddressCard.setVisibility(View.GONE);
        distinationAddressCard2.setVisibility(View.GONE);
        address = orginAddress;
        loadAddress = loadOrginAddress;

        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //GPS Provider disabled


            openDialog(activity);

        }

        state = 0;

    }


    public void goToStateSelectDistination() {



        locationPin.setVisibility(View.VISIBLE);
        locationPin.setImageResource(R.drawable.placeholder_destination);
        distinationAddressCard.setVisibility(View.VISIBLE);
        distinationAddressCard2.setVisibility(View.GONE);
        address = distinationAddress;
        loadAddress = loadDistinationAddress;

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment != null && fragment.getTag().equals("fragment_price")) {


            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
     //   googleMap.getUiSettings().setAllGesturesEnabled(true);
        state = 1;

    }


    public void goToStateGetPrice(Trip trip) {

        if (secondTrip == false) {
            distinationAddressCard2.setVisibility(View.GONE);
          /*  if (markerDestination2 != null) {
                markerDestination2.remove();

            }*/
        }



        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = PriceRequestFragment.newInstance(trip);
        fragmentTransaction.replace(R.id.fragment_container, fragment, "fragment_price");
        fragmentTransaction.commit();
        locationPin.setVisibility(View.GONE);

       // googleMap.getUiSettings().setAllGesturesEnabled(false);
        state = 2;


    }

    public void goToStateSelectSecondDistination() {

        distinationAddressCard2.setVisibility(View.VISIBLE);

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment != null && fragment.getTag().equals("fragment_price")) {


            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
      //  googleMap.getUiSettings().setAllGesturesEnabled(true);

        locationPin.setVisibility(View.VISIBLE);
        locationPin.setImageResource(R.drawable.placeholder_destination);

        address = distinationAddress2;
        loadAddress = loadDistinationAddress2;
        state = 3;
    }


    public void goToStateFindDriver(TripRES trip) {
        locationPin.setVisibility(View.VISIBLE);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = FindDriverFragment.newInstance(trip);
        fragmentTransaction.replace(R.id.fragment_container, fragment, "fragment_finaltrip");
        fragmentTransaction.commitAllowingStateLoss();


        state = 4;

    }

    public void goToStateArriveToOrgin(TripRES trip) {
    }

    public void goToStateStartTrip(TripRES trip) {

    }

    public void goToStateEndTrip(TripRES trip) {

    }

    public void openDialog(final Activity activity) {


        final Dialog dialog = new Dialog(activity);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_location);
        dialog.findViewById(R.id.turnOnLocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                dialog.dismiss();
            }
        });


        dialog.show();


    }


    public boolean isDialogOpen() {
        return dialogOpen;
    }

    public void setDialogOpen(boolean dialogOpen2) {
        dialogOpen = dialogOpen2;
    }

  /*  public Marker getMarkerOrgin() {
        return markerOrgin;
    }

    public void setMarkerOrgin(Marker markerOrgin) {
        this.markerOrgin = markerOrgin;
    }*/


    public MyTextView getDistinationAddress2() {
        return distinationAddress2;
    }

    public void setDistinationAddress2(MyTextView distinationAddress2) {
        this.distinationAddress2 = distinationAddress2;
    }

    public ProgressBar getLoadDistinationAddress2() {
        return loadDistinationAddress2;
    }

    public void setLoadDistinationAddress2(ProgressBar loadDistinationAddress2) {
        this.loadDistinationAddress2 = loadDistinationAddress2;
    }

    public RelativeLayout getDistinationAddressCard2() {
        return distinationAddressCard2;
    }

    public void setDistinationAddressCard2(RelativeLayout distinationAddressCard2) {
        this.distinationAddressCard2 = distinationAddressCard2;
    }

    public MyTextView getOrginAddress() {
        return orginAddress;
    }

    public void setOrginAddress(MyTextView orginAddress) {
        this.orginAddress = orginAddress;
    }

    public MyTextView getDistinationAddress() {
        return distinationAddress;
    }

    public boolean isSecondTrip() {
        return secondTrip;
    }

    public void setSecondTrip(boolean secondTrip2) {
        secondTrip = secondTrip2;
    }

    public void setDistinationAddress(MyTextView distinationAddress) {
        this.distinationAddress = distinationAddress;

    }

    public ProgressBar getLoadOrginAddress() {
        return loadOrginAddress;
    }

    public void setLoadOrginAddress(ProgressBar loadOrginAddress) {
        this.loadOrginAddress = loadOrginAddress;
    }

  /*  public Marker getMarkerDestination() {
        return markerDestination;
    }

    public void setMarkerDestination(Marker markerDestination) {
        stateOfApp.markerDestination = markerDestination;
    }

    public Marker getMarkerDestination2() {
        return markerDestination2;
    }

    public void setMarkerDestination2(Marker markerDestination2) {
        stateOfApp.markerDestination2 = markerDestination2;
    }
*/
    public ProgressBar getLoadDistinationAddress() {
        return loadDistinationAddress;
    }

    public void setLoadDistinationAddress(ProgressBar loadDistinationAddress) {
        this.loadDistinationAddress = loadDistinationAddress;
    }

    public ProgressBar getLoadAddress() {
        return loadAddress;
    }

    public void setLoadAddress(ProgressBar loadAddress) {
        this.loadAddress = loadAddress;
    }

 /*   public GoogleMap getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }
*/
    public MyTextView getAddress() {
        return address;
    }

    public void setAddress(MyTextView address) {
        this.address = address;
    }

    public RelativeLayout getDistinationAddressCard() {
        return distinationAddressCard;
    }

    public void setDistinationAddressCard(RelativeLayout distinationAddressCard) {
        this.distinationAddressCard = distinationAddressCard;
    }

    public ImageView getLocationPin() {
        return locationPin;
    }

    public void setLocationPin(ImageView locationPin) {
        this.locationPin = locationPin;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
