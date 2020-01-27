package co.tara.tarabari.passenger.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.passenger.Config;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.PassengerRES;
import co.tara.tarabari.passenger.myview.MyButton;
import co.tara.tarabari.passenger.myview.MyEditText;
import co.tara.tarabari.passenger.rest.client.MyScalarClient;
import co.tara.tarabari.passenger.rest.request.ReverifiyApi;
import co.tara.tarabari.passenger.rest.request.VerifyApi;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/4/2017.
 */

public class VerifyActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    @BindView(R.id.edt_verify)
    MyEditText edtVerify;
    @BindView(R.id.btn_verify)
    MyButton btn_verify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_verify)
    public void verify() {


        if (edtVerify.getText().toString().length() < 6) {

            edtVerify.setError("error");

        } else {
            edtVerify.setError(null);

            progressDialog = new ProgressDialog(VerifyActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Verify...");
            progressDialog.show();

            PassengerRES passengerRES = new PassengerRES();
            passengerRES.setVerifyCode(edtVerify.getText().toString().toUpperCase());
            passengerRES.setPk_id(Config.preferences.getLong("pk_id",0));

            String myPassenger = new Gson().toJson(passengerRES);

            VerifyApi verifyApi = MyScalarClient.getClient().create(VerifyApi.class);
            Call<String> call = verifyApi.verify(myPassenger, "application/json");
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                    // String response2 = response.body().getMESSAGE();
                    progressDialog.dismiss();


                    if (response.body() != null) {
                        PassengerRES passengerRES = new PassengerRES();
                        passengerRES = new Gson().fromJson(response.body(), PassengerRES.class);

                        Intent intent = new Intent(VerifyActivity.this, FirstActivity.class);
                        startActivity(intent);
                        finish();

                    } else {


                        btn_verify.setEnabled(true);

                    }


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    progressDialog.dismiss();
                    btn_verify.setEnabled(true);


                }
            });
        }
    }

    @OnClick(R.id.btnReverification)
    public void reVerification(){

        progressDialog = new ProgressDialog(VerifyActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("reVerify...");
        progressDialog.show();

        PassengerRES passengerRES =new PassengerRES();
        passengerRES.setPk_id(Config.preferences.getLong("pk_id",0));

        String myPassenger = new Gson().toJson(passengerRES);
        ReverifiyApi reVerifyApi = MyScalarClient.getClient().create(ReverifiyApi.class);
        Call<String> call = reVerifyApi.reVerification(myPassenger, "application/json");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {

                progressDialog.dismiss();

                if (response.body() != null) {
                    PassengerRES passengerRES = new PassengerRES();
                    passengerRES = new Gson().fromJson(response.body(), PassengerRES.class);


                } else {

                    btn_verify.setEnabled(true);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                btn_verify.setEnabled(true);
            }
        });

    }
}
