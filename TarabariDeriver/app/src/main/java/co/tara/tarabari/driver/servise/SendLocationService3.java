package co.tara.tarabari.driver.servise;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/*
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
*/

/**
 * Created by Ali on 2/21/2017.
 */

public class SendLocationService3 extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }/*
//public class SendLocationService3 extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    TextView tvLatlong;

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

        if (mLastLocation != null) {
      *//*      tvLatlong.setText("Latitude: "+ String.valueOf(mLastLocation.getLatitude())+"Longitude: "+
                    String.valueOf(mLastLocation.getLongitude()));*//*


            Log.i("-------aaa",mLastLocation.getLatitude()+"   "+mLastLocation.getLongitude());
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Connection suspended...", Toast.LENGTH_SHORT).show();
        Log.i("-------aaa","Suspended");

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Toast.makeText(this, "Failed to connect...", Toast.LENGTH_SHORT).show();
        Log.i("-------aaa","failed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // your code
        Log.i("-------aaa","khkhkh");
        final Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){


                    try {
                        Log.i("-------aaa","11111");
                        buildGoogleApiClient();
                        if(mGoogleApiClient!= null){
                            mGoogleApiClient.connect();
                        }
                        else{
                           // Toast.makeText(this, "Not connected...", Toast.LENGTH_SHORT).show();

                            Log.i("-------aaa","failed2");
                        }


                        Thread.sleep(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
thread.start();



        return Service.START_FLAG_REDELIVERY;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }*/
}