package co.tara.tarabari.passenger.rest.async;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONObject;


import co.tara.tarabari.passenger.myview.MyTextView;
import co.tara.tarabari.passenger.rest.client.MyGeoCodeClient;
import co.tara.tarabari.passenger.rest.client.MyScalarClient;
import co.tara.tarabari.passenger.rest.request.GeoCodeApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetAddressDa {


    private static GetAddressDa ourInstance = new GetAddressDa();

    public static GetAddressDa getInstance() {
        return ourInstance;
    }

    private GetAddressDa() {
    }

    public void getAddress(String latLng, MyTextView myTextView, ProgressBar progressBar) {


        progressBar.setVisibility(View.VISIBLE);
        new GetMyAddress().execute(latLng, myTextView, progressBar);


    }


    public class GetMyAddress extends AsyncTask<Object, ProgressBar, Object[]> {

        @Override
        protected void onPostExecute(final Object[] objects) {
            super.onPostExecute(objects);


            ProgressBar progressBar = (ProgressBar) objects[2];

            progressBar.setVisibility(View.GONE);

            Call<String> call = (Call<String>) objects[0];

            call.enqueue(new Callback<String>() {

                @Override
                public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                    String response2 = response.body().toString();
                    try {
                        JSONObject obj = new JSONObject(response2);
                        if (!obj.getString("status").equals("OK"))
                            return;

                        // get the first result


                        JSONObject res = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(0);


                        MyTextView myTextView = (MyTextView) objects[1];
                        myTextView.setText(res.getString("long_name"));

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    // Log.i("----", "fieler");

                }
            });


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected void onProgressUpdate(ProgressBar... values) {
            super.onProgressUpdate(values);

            values[0].setVisibility(View.VISIBLE);
        }

        @Override
        protected Object[] doInBackground(Object... objects) {


            GeoCodeApi geoCodeApi = MyGeoCodeClient.getClient().create(GeoCodeApi.class);
            Call<String> call = geoCodeApi.getAddress((String) objects[0], "fa");


            Object[] objects1 = new Object[3];
            objects1[0] = call;
            objects1[1] = objects[1];
            objects1[2] = objects[2];
            publishProgress((ProgressBar) objects[2]);
            return objects1;
        }


    }

}
