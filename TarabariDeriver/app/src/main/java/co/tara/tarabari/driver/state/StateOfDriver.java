package co.tara.tarabari.driver.state;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

//import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.DriverRES;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.myview.MyTextView;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.async.AcceptTrip;
import co.tara.tarabari.driver.rest.async.GetAddressDa;
import co.tara.tarabari.driver.rest.async.GetTimeDa;
import co.tara.tarabari.driver.rest.async.RejectTrip;
import co.tara.tarabari.driver.servise.SendLocationService2;
import co.tara.tarabari.driver.servise.SendLocationService4;

/**
 * Created by jalalnia on 5/18/2017.
 */

public class StateOfDriver implements Serializable {


    public static int state;
    public static Activity activity;
    public static boolean actionOnTrip = false;

    public static void goToState0() {

        state = 0;
    }

    public static void goToState1(TripRES tripRES) {
        openDialog(tripRES);
        state = 1;
    }

    public static void goToState2(TripRES tripRES) {

        SharedPreferences.Editor editor = Config.preferences.edit();
        editor.putLong("pk_trip", tripRES.getPk_id_trip());
        editor.commit();

        activity.stopService(new Intent(activity, SendLocationService2.class));
        activity.startService(new Intent(activity, SendLocationService4.class));

        state = 2;
    }

    public static void goToState3() {

        state = 3;
    }

    public static void openDialog(TripRES myTripRES2) {


        final Dialog dialog = new Dialog(activity);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_request_trip);
        actionOnTrip = false;

        MyTextView txtBarName = (MyTextView) dialog.findViewById(R.id.txt_bar_name);
        MyTextView txtBarWeight = (MyTextView) dialog.findViewById(R.id.txt_bar_weight);
        MyTextView txtBarInfo = (MyTextView) dialog.findViewById(R.id.txt_bar_info);
        final MyTextView txtOrgin = (MyTextView) dialog.findViewById(R.id.txt_orgin);
        final MyTextView txtDistination = (MyTextView) dialog.findViewById(R.id.txt_distination);
        final MyTextView txtTime = (MyTextView) dialog.findViewById(R.id.txt_time);
        MyTextView txtPrice = (MyTextView) dialog.findViewById(R.id.txt_mablagh);
        final ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.prog_cancle);

        new AsyncTask<Void, Integer, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (!actionOnTrip) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            activity.startService(new Intent(activity, SendLocationService2.class));

                        }
                    }, 60000);


                }
            }

            @Override
            protected Void doInBackground(Void... params) {
                int progressStatus = 0;
                while (progressStatus < 100) {
                    progressStatus++;
                    publishProgress(progressStatus);
                    try {
                        Thread.sleep(90);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                progressBar.setProgress(values[0]);

            }
        }.execute();

//        txtBarName.setText(myTripRES2.getLoadRES().getLoadTypeDesc());
//        txtBarWeight.setText(myTripRES2.getLoadRES().getWeight());
//        txtBarInfo.setText(myTripRES2.getLoadRES().getLoadInfo());
//        txtPrice.setText(String.valueOf(myTripRES2.getTripCost()));


        GetAddressDa getAddressDa = new GetAddressDa(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {


                txtOrgin.setText((String) output);

            }

        });
        getAddressDa.execute(String.valueOf(myTripRES2.getStartLat()), String.valueOf(myTripRES2.getStartLng()));


        GetAddressDa getAddressDa2 = new GetAddressDa(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {


                txtDistination.setText((String) output);

            }

        });
        getAddressDa2.execute(String.valueOf(myTripRES2.getEndLat()), String.valueOf(myTripRES2.getEndLng()));

/*

        GetTimeDa getTimeDa = new GetTimeDa(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {
                txtTime.setText((String) output);
            }
        });
        getTimeDa.execute(new LatLng(myTripRES2.getStartLat(), myTripRES2.getStartLng()), new LatLng(myTripRES2.getEndLat(), myTripRES2.getStartLng()));
*/

        final TripRES myTripRES = new TripRES();
        myTripRES.setPk_id_trip(myTripRES2.getPk_id_trip());
        myTripRES.setPk_id_driver(Config.preferences.getLong("pk_id", 1000));


        dialog.findViewById(R.id.btn_accept).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        final AcceptTrip acceptTrip = new AcceptTrip(new AsyncResponse() {
                            @Override
                            public void processFinish(Object output) {

                                TripRES tripRES = (TripRES) output;


                                actionOnTrip = true;

                                goToState2(tripRES);

                            }
                        });
                        acceptTrip.execute(myTripRES);

                        dialog.dismiss();
                    }
                });


        dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DriverRES driverRES = new DriverRES();

                driverRES.setPk_id(Config.preferences.getLong("pk_id", 1000));
                RejectTrip rejectTrip = new RejectTrip(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {


                        goToState0();
                        actionOnTrip = true;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                activity.startService(new Intent(activity, SendLocationService2.class));

                            }
                        }, 60000);


                    }
                });
                rejectTrip.execute(driverRES);

                dialog.dismiss();

            }
        });
        dialog.setCancelable(true);
        dialog.show();


 /*       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        activity.startService(new Intent(activity, SendLocationService2.class));

                    }
                }, 60000);


                dialog.dismiss();

            }
        }, 9000);*/
    }

}
