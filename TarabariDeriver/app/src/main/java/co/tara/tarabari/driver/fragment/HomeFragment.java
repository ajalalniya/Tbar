package co.tara.tarabari.driver.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/*import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;*/


import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.activity.LoadActivity1;
import co.tara.tarabari.driver.activity.ManualTripActivity;
import co.tara.tarabari.driver.myview.MyTabLayout;
import co.tara.tarabari.driver.myview.MyTextShape2;
import co.tara.tarabari.driver.servise.SendLocationService;
import co.tara.tarabari.driver.servise.SendLocationService2;


/**
 * Created by Ali on 2/21/2017.
 */

//public class HomeFragment extends Fragment implements OnMapReadyCallback {
public class HomeFragment extends Fragment  {

    private SendLocationService2 gps;
    double longitude;
    double latitude;
    int width;
    //   GoogleApiClient mGoogleApiClient;
    Location mLastLocation;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

      /*  SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
*/

        view.findViewById(R.id.btnTarh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



     /*      gps = new SendLocationService2(getContext());


        if(gps.canGetLocation()){


            longitude = gps.getLongitude();
            latitude = gps .getLatitude();
            Log.i("----","Longitude:"+Double.toString(longitude)+"\nLatitude:"+Double.toString(latitude));

            Toast.makeText(getContext(),"Longitude:"+Double.toString(longitude)+"\nLatitude:"+Double.toString(latitude),Toast.LENGTH_SHORT).show();
        }
        else
        {

            gps.showSettingsAlert();
        }
*/
                //broadcastIntent();

                Intent intent = new Intent(getContext(), ManualTripActivity.class);
                startActivity(intent);


            }
        });

        return view;
    }

    private void unselectTab() {

        View view2 = getActivity().findViewById(R.id.tabsApp);

        MyTabLayout tabLayout = (MyTabLayout) view2;


        MyTextShape2 imgtab1 = (MyTextShape2) tabLayout.getTabAt(3).getCustomView().findViewById(R.id.imgTab);
        imgtab1.setText(getResources().getString(R.string.icon_btn_home));

       /* MyTextShape2 imgtab2 = (MyTextShape2) tabLayout.getTabAt(2).getCustomView().findViewById(R.id.imgTab);
        imgtab2.setText(getResources().getString(R.string.icon_btn_rate));

        MyTextShape2 imgtab3 = (MyTextShape2) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.imgTab);
        imgtab3.setText(getResources().getString(R.string.icon_btn_payment));

        MyTextShape2 imgtab4 = (MyTextShape2) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.imgTab);
        imgtab4.setText(getResources().getString(R.string.icon_btn_profile));*/


    }

    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("co.tara.tarabari.GET_TRIP");
        getActivity().sendBroadcast(intent);
    }

   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        double lat = 35.7054921;
        double lng = 51.4014754;
 *//*       CameraPosition position = CameraPosition.builder()
                .target(new LatLng(lat, lng))
                .zoom(16.0f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();*//*

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.style_json));

            if (!success) {
                Log.e("error", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("error", "Can't find style. Error: ", e);
        }



        googleMap.setPadding(400, 0, 0, 0);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 16.0f));

        //. googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // googleMap.setIndoorEnabled(true);

    }*/

}
