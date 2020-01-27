package co.tara.tarabari.passenger.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import co.tara.tarabari.passenger.Config;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.PassengerRES;
import co.tara.tarabari.passenger.model.StateRES;
import co.tara.tarabari.passenger.myview.MyButton;
import co.tara.tarabari.passenger.myview.MyEditText;
import co.tara.tarabari.passenger.rest.client.MyScalarClient;
import co.tara.tarabari.passenger.rest.request.LoginApi;
import co.tara.tarabari.passenger.utils.EncoderUtil;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/3/2017.
 */

public class LoginActivity extends AppCompatActivity {
    public MyEditText phoneNum;
    public MyEditText password;
    public MyButton btnLogin;
    public TextView textView;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        phoneNum = (MyEditText) findViewById(R.id.edt_phonenum);
        password = (MyEditText) findViewById(R.id.edt_password);
        btnLogin = (MyButton) findViewById(R.id.btn_login);

        textView = (TextView) findViewById(R.id.test);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();


            }
        });


    }

    public void login() {


        if (!validate()) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "NOT VALID", Snackbar.LENGTH_LONG);


            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTypeface(Config.typeface);
            textView.setTextColor(Color.YELLOW);
            snackbar.show();
            return;
        }


        btnLogin.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        String password = this.password.getText().toString();
        try {
            EncoderUtil encoderUtil = new EncoderUtil();

            password = encoderUtil.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String phoneNum = this.phoneNum.getText().toString();

        PassengerRES passengerRES = new PassengerRES();
        passengerRES.setUsername(phoneNum);
        passengerRES.setPassword(password);
        String mPassenger = new Gson().toJson(passengerRES);
        LoginApi loginApi = MyScalarClient.getClient().create(LoginApi.class);
        Call<String> call = loginApi.login(mPassenger, "application/json");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {


                String response2 = response.body();
                if (response.body() != null) {

                    StateRES stateRES;
                    stateRES = new Gson().fromJson(response.body(), StateRES.class);


                }
                progressDialog.dismiss();
                btnLogin.setEnabled(true);

            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {

                btnLogin.setEnabled(true);
                progressDialog.dismiss();

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "field", Snackbar.LENGTH_LONG);


                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTypeface(Config.typeface);
                textView.setTextColor(Color.RED);
                snackbar.show();


            }
        });


    }


    public boolean validate() {
        boolean valid = true;

        String phoneNum = this.phoneNum.getText().toString();
        String password = this.password.getText().toString();

        if (this.password.getText().toString().trim().equals("") || password.length() < 4 || password.length() > 10) {
            this.password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            this.password.setError(null);
        }


        if (this.phoneNum.getText().toString().trim().equals("") || phoneNum.trim().length() != 11)

        {
            this.phoneNum.setError("enter a valid phoneNum");
            valid = false;


        } else {

            this.phoneNum.setError(null);
        }

        return valid;
    }


}

