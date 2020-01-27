package co.tara.tarabari.driver.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.Trip;
import co.tara.tarabari.driver.myview.MyTextView;


/**
 * Created by jalalnia on 5/10/2017.
 */

public class LoadActivity1 extends AppCompatActivity {

    @BindView(R.id.btn_next_page)
    Button btnNextPage;
    Trip trip;
    @BindView(R.id.txt_bime)
    MyTextView txtBime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar1);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        if (intent != null) {

            trip = (Trip) intent.getSerializableExtra("TRIP");

        }

        String htmlString = "<u>شرایط بیمه</u>";
        txtBime.setText(Html.fromHtml(htmlString));

    }

    @OnClick(R.id.btn_next_page)
    public void nextPage() {

        Intent intent = new Intent(this, LoadActivity2.class);

        intent.putExtra("TRIP", trip);
        LoadActivity1.this.startActivity(intent);
        LoadActivity1.this.finish();

    }
}
