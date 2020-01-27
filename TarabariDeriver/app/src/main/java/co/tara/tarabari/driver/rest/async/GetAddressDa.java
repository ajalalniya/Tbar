package co.tara.tarabari.driver.rest.async;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONObject;

import co.tara.tarabari.driver.myview.MyTextView;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.client.MyGeoCodeClient;
import co.tara.tarabari.driver.rest.request.GeoCodeApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jalalnia on 2/18/2017.
 */

public class GetAddressDa extends AsyncTask<String,Void,Object>{


AsyncResponse asyncResponse =null;



    public GetAddressDa(AsyncResponse asyncResponse) {
        this.asyncResponse =asyncResponse;
    }

    @Override
    protected Object doInBackground(String... strings) {

        GeoCodeApi geoCodeApi = MyGeoCodeClient.getClient().create(GeoCodeApi.class);
        Call<String> call = geoCodeApi.getAddress(strings[0]+","+strings[1], "fa");
        return call;
    }

    @Override
    protected void onPostExecute(Object objects) {
        super.onPostExecute(objects);

        Call<String> call = (Call<String>) objects;
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String response2 = response.body().toString();
                try {
                    JSONObject obj = new JSONObject(response2);
                    if (!obj.getString("status").equals("OK"))
                        return;

                    // get the first result


                    JSONObject res = obj.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(0);


                  asyncResponse.processFinish( res.getString("long_name"));

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }






}
