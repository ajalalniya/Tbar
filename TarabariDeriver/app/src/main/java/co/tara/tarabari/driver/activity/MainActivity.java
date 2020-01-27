package co.tara.tarabari.driver.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.adapter.CarSelectAdapter;
import co.tara.tarabari.driver.fragment.AccontFragment;
import co.tara.tarabari.driver.fragment.DailyEarningsFragment;
import co.tara.tarabari.driver.fragment.EarningsFragment;
import co.tara.tarabari.driver.fragment.HomeFragment;
import co.tara.tarabari.driver.fragment.ScoreFragment;
import co.tara.tarabari.driver.fragment.WeeklyEarningsFragment;
import co.tara.tarabari.driver.model.Cars;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.model.VehicleDriverRES;
import co.tara.tarabari.driver.myview.MyButton;
import co.tara.tarabari.driver.myview.MyRadioButton;
import co.tara.tarabari.driver.myview.MyTabLayout;
import co.tara.tarabari.driver.myview.MyTextShape;
import co.tara.tarabari.driver.myview.MyTextShape2;
import co.tara.tarabari.driver.myview.MyTextView;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.rest.async.ActiveVehicle;
import co.tara.tarabari.driver.servise.SendLocationService2;
import co.tara.tarabari.driver.state.StateOfDriver;
import co.tara.tarabari.driver.utils.IdGenerator;


public class MainActivity extends AppCompatActivity {

    private MyTabLayout tabLayout;

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private SendLocationService2 gps;
    private Context context;
    @BindView(R.id.btn_offOn)
    public ImageView btnOffOn;

    @BindView(R.id.txt_off_on)
    public MyTextView txt_off_on;
    double longitude;
    double latitude;

    private String[] viewPagerTitles = new String[4];
/*    final int[] ICONS = new int[]{

            R.drawable.btn_profile,
            R.drawable.btn_rate,
            R.drawable.btn_payment,
            R.drawable.btn_home


    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = this;
        viewPagerTitles[3] = getString(R.string.home);
        viewPagerTitles[2] = getString(R.string.earnings);
        viewPagerTitles[1] = getString(R.string.score);
        viewPagerTitles[0] = getString(R.string.accont);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (MyTabLayout) findViewById(R.id.tabsApp);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        /*tabLayout.getTabAt(3).setIcon(ICONS[3]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(0).setIcon(ICONS[0]);*/


        StateOfDriver.activity = this;
        Config.inMain = true;
        if (Config.preferences.getBoolean("HasTarh", false)) {


            // startService(new Intent(getBaseContext(), SendLocationService2.class));
        } else {

            //stopService(new Intent(getBaseContext(), SendLocationService2.class));

        }
        if (Config.preferences.getBoolean("online", false)) {
            btnOffOn.setImageResource(R.drawable.btn_online);


        } else {


            btnOffOn.setImageResource(R.drawable.btn_offline);

        }

//TODO
        if (StateOfDriver.state == 1) {

            Intent intent = getIntent();

            TripRES tripRES = (TripRES) intent.getSerializableExtra("TRIP");

            StateOfDriver.goToState1(tripRES);

        }

    }

    private void setupTabIcons() {

        View view0 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        MyTextView tabOne = (MyTextView) view0.findViewById(R.id.tab);
        MyTextShape2 imgOne = (MyTextShape2) view0.findViewById(R.id.imgTab);
        tabOne.setText("حساب");
        imgOne.setText(getResources().getString(R.string.icon_btn_profile));
        tabLayout.getTabAt(0).setCustomView(view0);

        View view1 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        MyTextView tabTwo = (MyTextView) view1.findViewById(R.id.tab);
        MyTextShape2 imgTwo = (MyTextShape2) view1.findViewById(R.id.imgTab);
        tabTwo.setText("امتیاز");
        imgTwo.setText(getResources().getString(R.string.icon_btn_rate));
        tabLayout.getTabAt(1).setCustomView(view1);

        View view2 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        MyTextView tabThree = (MyTextView) view2.findViewById(R.id.tab);
        MyTextShape2 imgThree = (MyTextShape2) view2.findViewById(R.id.imgTab);
        tabThree.setText("درآمد");
        imgThree.setText(getResources().getString(R.string.icon_btn_payment));
        tabLayout.getTabAt(2).setCustomView(view2);

        View view3 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        MyTextView tabFour = (MyTextView) view3.findViewById(R.id.tab);
        MyTextShape2 imgFour = (MyTextShape2) view3.findViewById(R.id.imgTab);
        tabFour.setText("خانه");
        imgFour.setText(getResources().getString(R.string.icon_btn_home_s));
        tabLayout.getTabAt(3).setCustomView(view3);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("------", "onpause");
        Config.inMain = false;
    }

    @OnClick(R.id.btn_offOn)
    public void btnOffOn() {

     /*   final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();*/

        if (Config.preferences.getBoolean("online", false)) {

            SharedPreferences.Editor editor = Config.preferences.edit();
            editor.putBoolean("online", false);
            editor.commit();
            btnOffOn.setImageResource(R.drawable.btn_offline);
            txt_off_on.setText("خاموش");

        } else {

            SharedPreferences.Editor editor = Config.preferences.edit();
            editor.putBoolean("online", true);
            editor.commit();
            btnOffOn.setImageResource(R.drawable.btn_online);
            txt_off_on.setText("روشن");

            ArrayList<VehicleDriverRES> vehicleDriverRESList = new ArrayList<>();

            for (int i = 0; i <= 9; i++) {
                VehicleDriverRES vehicleDriverRES = new VehicleDriverRES();

                vehicleDriverRESList.add(vehicleDriverRES);

            }
            openDialog();
            // driverListDialog(vehicleDriverRESList);
        }

/*

            VehicleDriverRES vehicleDriverRES = new VehicleDriverRES();
            vehicleDriverRES.setPk_driver_id(Config.preferences.getLong("pk_id", 1000));
            vehicleDriverRES.setPk_vehicle_id(Config.preferences.getLong("pk_vehicle_id", 1000));
            SetOffline setOffline = new SetOffline(new AsyncResponse() {
                @Override
                public void processFinish(Object output) {
                    String res = (String) output;

                    if (res.equals("success")) {

                        SharedPreferences.Editor editor = Config.preferences.edit();
                        editor.putBoolean("online", false);
                        editor.commit();
                        btnOffOn.setImageResource(R.drawable.btn_offline);


                        stopService(new Intent(getBaseContext(), SendLocationService2.class));

                    }
                    progressDialog.dismiss();
                }
            });
            setOffline.execute(vehicleDriverRES);


        } else {


            DriverRES driverRES = new DriverRES();

            //TODO
            driverRES.setPk_id(Config.preferences.getLong("pk_id", 1000));
            GetVehicleList getVehicleList = new GetVehicleList(new AsyncResponse() {
                @Override
                public void processFinish(Object output) {
                    progressDialog.dismiss();
                    ArrayList<VehicleDriverRES> driverRESList = (ArrayList<VehicleDriverRES>) output;
                    driverListDialog(driverRESList);


                }
            });
            getVehicleList.execute(driverRES);
*/


    }

    public void reciveTripDialog(TripRES tripRES) {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.trip_request_dialog);

        dialog.show();

    }

    public void driverListDialog(final ArrayList<VehicleDriverRES> vehicleDriverRESList) {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_drivers);
        final RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.vehicleRadio);
        MyButton myButton = (MyButton) dialog.findViewById(R.id.btnSabtVehicle);
        MyRadioButton button;
        radioGroup.removeAllViews();


        int i = 0;
        for (VehicleDriverRES vehicleDriverRES : vehicleDriverRESList) {
            button = new MyRadioButton(this);
            button.setText(vehicleDriverRES.getPlakNum() + "   " + vehicleDriverRES.getOwnerName());
            button.setId(i);
            i++;
            //    pasokh  =pasokh + answer.getAnswer() + "  " + answer.getAnswerCount() + "  " + context.getResources().getString(R.string.pasokh) +"\n";
            radioGroup.addView(button);
        }

        dialog.show();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                dialog.dismiss();
                ActiveVehicle sendVehicle = new ActiveVehicle(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {
                        String res = (String) output;
                        if (res.equals("success")) {
                            SharedPreferences.Editor editor = Config.preferences.edit();
                            editor.putBoolean("online", true);
                            editor.commit();
                            btnOffOn.setImageResource(R.drawable.btn_online);
                            startService(new Intent(getBaseContext(), SendLocationService2.class));
                            progressDialog.dismiss();
                        }
                    }
                });
                sendVehicle.execute(vehicleDriverRESList.get(radioGroup.getCheckedRadioButtonId()));
            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                unselectTab();
                MyTextShape2 imgtab1 = (MyTextShape2) tabLayout.getTabAt(position).getCustomView().findViewById(R.id.imgTab);
                switch (position) {

                    case 0:
                        imgtab1.setText(getResources().getString(R.string.icon_btn_profile_s));
                        break;
                    case 1:
                        imgtab1.setText(getResources().getString(R.string.icon_btn_rate_s));
                        break;
                    case 2:
                        imgtab1.setText(getResources().getString(R.string.icon_btn_payment_s));
                        break;
                    case 3:
                        imgtab1.setText(getResources().getString(R.string.icon_btn_home_s));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void unselectTab() {
        MyTextShape2 imgtab1 = (MyTextShape2) tabLayout.getTabAt(3).getCustomView().findViewById(R.id.imgTab);
        imgtab1.setText(getResources().getString(R.string.icon_btn_home));

        MyTextShape2 imgtab2 = (MyTextShape2) tabLayout.getTabAt(2).getCustomView().findViewById(R.id.imgTab);
        imgtab2.setText(getResources().getString(R.string.icon_btn_payment));

        MyTextShape2 imgtab3 = (MyTextShape2) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.imgTab);
        imgtab3.setText(getResources().getString(R.string.icon_btn_rate));

        MyTextShape2 imgtab4 = (MyTextShape2) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.imgTab);
        imgtab4.setText(getResources().getString(R.string.icon_btn_profile));


    }

    public void openDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_car_selection);

        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.rec_car_select);
        ArrayList<Cars> carses = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            Cars cars = new Cars();

            carses.add(cars);

        }

        CarSelectAdapter carSelectAdapter = new CarSelectAdapter(carses, dialog);
        recyclerView.setAdapter(carSelectAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dialog.show();


    }


    class ViewPagerAdapter extends PagerAdapter {
        RelativeLayout homeFragmentLayout = null;
        RelativeLayout earningsFragmentLayout = null;
        RelativeLayout scoreFragmentLayout = null;
        RelativeLayout accontFragmentLayout = null;
        HomeFragment homeFragment = new HomeFragment();
        DailyEarningsFragment earningsFragment = new DailyEarningsFragment();
        ScoreFragment scoreFragment = new ScoreFragment();
        AccontFragment accontFragment = new AccontFragment();
        FragmentManager fragmentManager = null;
        FragmentTransaction fragmentTransaction = null;


        private ViewPagerAdapter() {
            homeFragmentLayout = new RelativeLayout(getApplicationContext());
            homeFragmentLayout.setId(IdGenerator.getId("homeFragmentLayout"));
            homeFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            earningsFragmentLayout = new RelativeLayout(getApplicationContext());
            earningsFragmentLayout.setId(IdGenerator.getId("earningsFragmentLayout"));
            earningsFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            scoreFragmentLayout = new RelativeLayout(getApplicationContext());
            scoreFragmentLayout.setId(IdGenerator.getId("scoreFragmentLayout"));
            scoreFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


            accontFragmentLayout = new RelativeLayout(getApplicationContext());
            accontFragmentLayout.setId(IdGenerator.getId("accontFragmentLayout"));
            accontFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        }

        public ViewPagerAdapter(FragmentManager manager) {
            this();
            this.fragmentManager = manager;

        }


        @Override
        public int getCount() {
            return 4;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            Log.i("---------", "tab " + position);

            return viewPagerTitles[position];
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (View) object == view;
        }


        @Deprecated
        public Object instantiateItem(View container, int position) {
            fragmentTransaction = fragmentManager.beginTransaction();


            Log.i("---------", "" + position);


            if (position == 3) {
                fragmentTransaction.add(homeFragmentLayout.getId(), homeFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(homeFragmentLayout, 0);


                return homeFragmentLayout;
            } else if (position == 2) {
                fragmentTransaction.add(earningsFragmentLayout.getId(), earningsFragment);
                fragmentTransaction.commit();

                ((ViewPager) container).addView(earningsFragmentLayout, 0);


                return earningsFragmentLayout;
            } else if (position == 1) {

                fragmentTransaction.add(scoreFragmentLayout.getId(), scoreFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(scoreFragmentLayout, 0);

                return scoreFragmentLayout;
            } else if (position == 0) {

                fragmentTransaction.add(accontFragmentLayout.getId(), accontFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(accontFragmentLayout, 0);


                return accontFragmentLayout;
            }

            return null;
        }


    }

}
