package co.tara.tarabari.driver.servise;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.model.DriverPointRES;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.async.SetLatLng;
import co.tara.tarabari.driver.rest.async.SetLatLngInTrip;

/**
 * Created by Ali on 2/21/2017.
 */

public class SendLocationService4 extends Service implements LocationListener {


    boolean checkGPS = false;


    boolean checkNetwork = false;

    boolean canGetLocation = false;
    private boolean running;
    Location loc;
    double latitude;
    double longitude;
    DriverPointRES driverPointRes;
    Thread thread;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;


    private static final long MIN_TIME_BW_UPDATES = 30000;
    protected LocationManager locationManager;


    public int onStartCommand(Intent intent, int flags, int startId) {
        running = true;
        driverPointRes = new DriverPointRES();
        getLocation();
        driverPointRes.setPk_id(Config.preferences.getLong("pk_id", 1000));
        if (canGetLocation()) {




/*
            while (true) {
                try {
                    driverPointRes.setLat(getLatitude());
                    driverPointRes.setLng(getLongitude());

                    SetLatLng setLatLng = new SetLatLng(new AsyncResponse() {
                        @Override
                        public void processFinish(Object output) {
                            ArrayList<TripRES> tripRESArrayList = (ArrayList<TripRES>) output;

                        }
                    });
                    setLatLng.execute(driverPointRes);

                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/


            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        try {
                            driverPointRes.setLat(getLatitude());
                            driverPointRes.setLng(getLongitude());
                            driverPointRes.setPk_trip(Config.preferences.getLong("pk_trip", 0));
                            SetLatLngInTrip setLatLng = new SetLatLngInTrip(new AsyncResponse() {
                                @Override
                                public void processFinish(Object output) {

                                    String string = (String) output;
                                    Log.i("-----", string);
                                }
                            });
                            setLatLng.execute(driverPointRes);
                            Log.i("-------", longitude + "    " + latitude);
                            Thread.sleep(20000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();

        } else {

            showSettingsAlert();
        }


        return Service.START_FLAG_REDELIVERY;
    }


    private Location getLocation() {

        try {
            locationManager = (LocationManager) Config.context
                    .getSystemService(LOCATION_SERVICE);

            // getting GPS status
            checkGPS = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            checkNetwork = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!checkGPS && !checkNetwork) {
                Toast.makeText(Config.context, "No Service Provider Available", Toast.LENGTH_SHORT).show();
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (checkNetwork) {
                    Toast.makeText(Config.context, "Network", Toast.LENGTH_SHORT).show();

                    try {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("Network", "Network");
                        if (locationManager != null) {
                            loc = locationManager
                                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                        }

                        if (loc != null) {
                            latitude = loc.getLatitude();
                            longitude = loc.getLongitude();
                        }
                    } catch (SecurityException e) {

                    }
                }
            }
            // if GPS Enabled get lat/long using GPS Services
            if (checkGPS) {
                Toast.makeText(Config.context, "GPS", Toast.LENGTH_SHORT).show();
                if (loc == null) {
                    try {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            loc = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (loc != null) {
                                latitude = loc.getLatitude();
                                longitude = loc.getLongitude();
                            }
                        }
                    } catch (SecurityException e) {

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loc;
    }

    public double getLongitude() {
        if (loc != null) {
            longitude = loc.getLongitude();
        }
        return longitude;
    }

    public double getLatitude() {
        if (loc != null) {
            latitude = loc.getLatitude();
        }
        return latitude;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Config.context);


        alertDialog.setTitle("GPS Not Enabled");

        alertDialog.setMessage("Do you wants to turn On GPS");


        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Config.context.startActivity(intent);
            }
        });


        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertDialog.show();
    }


    public void stopUsingGPS() {
        if (locationManager != null) {


            locationManager.removeUpdates(SendLocationService4.this);
        }
    }


    @Override
    public void onDestroy() {
        running = false;
        super.onDestroy();
        thread.interrupt();


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {


        Log.i("---------", location.getLatitude() + "    " + location.getLongitude());


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
