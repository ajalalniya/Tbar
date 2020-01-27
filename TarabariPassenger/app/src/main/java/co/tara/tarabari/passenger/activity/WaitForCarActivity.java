package co.tara.tarabari.passenger.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.TripRES;
import co.tara.tarabari.passenger.myview.MyButton;
import co.tara.tarabari.passenger.rest.AsyncResponse;
import co.tara.tarabari.passenger.rest.async.GetFindDriverDa;


/**
 * Created by jalalnia on 5/24/2017.
 */

public class WaitForCarActivity extends Activity {
    ImageView rotatingBackground, rotatingCar, wheelOne, wheelTwo;
    MyButton cancelRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wait_car);

        Intent intent = getIntent();

        TripRES tripRES = (TripRES) intent.getSerializableExtra("TRIP");

        GetFindDriverDa getFindDriverDa = new GetFindDriverDa(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                TripRES tripRES1 = (TripRES) output;
                Intent returnIntent = new Intent();
                returnIntent.putExtra("RESULT", tripRES1);
                setResult(Activity.RESULT_OK, returnIntent);
                WaitForCarActivity.this.finish();

            }
        });
        getFindDriverDa.execute(tripRES);















/*
        BlurBehind.getInstance()
                .withAlpha(80)
                .withFilterColor(Color.parseColor("#FF060606"))
                .setBackground(this);
        rotatingBackground = (ImageView) findViewById(R.id.rotatingBackground);
        rotatingCar = (ImageView) findViewById(R.id.rotatingCar);
        wheelOne = (ImageView) findViewById(R.id.wheelOne);
        wheelTwo = (ImageView) findViewById(R.id.wheelTwo);

        RotateAnimation backgroundRotate = new RotateAnimation(360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        backgroundRotate.setDuration(8000);
        backgroundRotate.setInterpolator(new LinearInterpolator());
        backgroundRotate.setRepeatCount(Animation.INFINITE);
        rotatingBackground = (ImageView) findViewById(R.id.rotatingBackground);
        rotatingBackground.startAnimation(backgroundRotate);
        RotateAnimation wheelRotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        wheelRotate.setDuration(1500);
        wheelRotate.setInterpolator(new LinearInterpolator());
        wheelRotate.setRepeatCount(Animation.INFINITE);
        wheelOne = (ImageView) findViewById(R.id.wheelOne);
        wheelTwo = (ImageView) findViewById(R.id.wheelTwo);
        wheelOne.startAnimation(wheelRotate);
        wheelTwo.startAnimation(wheelRotate);

    }
*/


    }

    @Override
    public void onBackPressed() {




    }
}
