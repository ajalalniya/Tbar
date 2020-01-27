package co.tara.tarabari.passenger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.Trip;

/**
 * Created by jalalnia on 5/10/2017.
 */

public class LoadActivity3 extends AppCompatActivity {

    public Trip trip;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar3);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        if (intent != null) {

            trip = (Trip) intent.getSerializableExtra("TRIP");

        }

    }

    @OnClick(R.id.btn_next_page2)
    public void onclick() {
        finish();
    }


}
