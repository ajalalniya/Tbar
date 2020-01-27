package co.tara.tarabari.passenger.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.passenger.Config;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.PassengerRES;
import co.tara.tarabari.passenger.myview.MyButton;
import co.tara.tarabari.passenger.myview.MyEditText;
import co.tara.tarabari.passenger.rest.client.MyScalarClient;
import co.tara.tarabari.passenger.rest.request.RegisterApi;
import co.tara.tarabari.passenger.utils.EncoderUtil;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jalalnia on 5/3/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edt_firstname)
    MyEditText firstName;
    @BindView(R.id.edt_lastname)
    MyEditText lastName;
    @BindView(R.id.edt_email)
    MyEditText email;
    @BindView(R.id.edt_phonenum)
    MyEditText phoneNum;
    @BindView(R.id.edt_password)
    MyEditText password;
    @BindView(R.id.edt_referee)
    MyEditText referee;
    @BindView(R.id.btn_register)
    MyButton btnRegister;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    ProgressDialog progressDialog;
    PassengerRES passnger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void register() {
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
        try {
            EncoderUtil encoderUtil = new EncoderUtil();
            passnger.setPassword(encoderUtil.getMD5(password.getText().toString().trim()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnRegister.setEnabled(false);
        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
        final Gson gson = new Gson();
        String myPassenger = gson.toJson(passnger);
        RegisterApi registerApi = MyScalarClient.getClient().create(RegisterApi.class);
        Call<String> call = registerApi.register(myPassenger, "application/json");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                // String response2 = response.body().getMESSAGE();
                progressDialog.dismiss();


                if (response.body() != null) {
                    PassengerRES passengerRES = new PassengerRES();
                    passengerRES = gson.fromJson(response.body(), PassengerRES.class);

                    SharedPreferences.Editor editor = Config.preferences.edit();
                    editor.putString("referCode", passengerRES.getReferCode());
                    editor.putString("refereeCode", passengerRES.getRefereeCode());
                    editor.putLong("pk_id", passengerRES.getPk_id());
                    editor.commit();

                    Intent intent = new Intent(RegisterActivity.this, VerifyActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "field", Snackbar.LENGTH_LONG);

                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTypeface(Config.typeface);
                    textView.setTextColor(Color.RED);
                    snackbar.show();

                    btnRegister.setEnabled(true);

                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                btnRegister.setEnabled(true);
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
        passnger = new PassengerRES();
        passnger.setName(firstName.getText().toString());
        passnger.setFamily(lastName.getText().toString());
        passnger.setEmail(email.getText().toString());
        passnger.setMobileNumber(phoneNum.getText().toString());
        passnger.setPassword(password.getText().toString());
        passnger.setRefereeCode(referee.getText().toString());
        if (passnger.getPassword().isEmpty() || passnger.getName().length() < 3) {
            this.firstName.setError("at least 3 characters");
            valid = false;
        } else {
            this.firstName.setError(null);
        }

        if (passnger.getEmail().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(passnger.getEmail()).matches()) {
            this.email.setError("enter a valid email address");
            valid = false;
        } else {
            this.email.setError(null);
        }


        if (passnger.getFamily().isEmpty() || passnger.getFamily().length() < 3) {
            this.lastName.setError("at least 3 characters");
            valid = false;
        } else {
            this.lastName.setError(null);
        }
        if (passnger.getPassword().isEmpty() || passnger.getPassword().length() < 4 || passnger.getPassword().length() > 10) {
            this.password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            this.password.setError(null);
        }


        if (this.phoneNum.getText().toString().trim().equals("") || passnger.getMobileNumber().trim().length() != 11)

        {
            this.phoneNum.setError("enter a valid phoneNum");
            valid = false;


        } else {

            this.phoneNum.setError(null);
        }
        return valid;
    }


}

