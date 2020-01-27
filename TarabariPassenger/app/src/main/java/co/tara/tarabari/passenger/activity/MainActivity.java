package co.tara.tarabari.passenger.activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.fragment.NewTripFragment;
import co.tara.tarabari.passenger.fragment.PassTripFragment;
import co.tara.tarabari.passenger.model.Trip;
import co.tara.tarabari.passenger.myview.MyTabLayout;
import co.tara.tarabari.passenger.myview.MyTextView;
import co.tara.tarabari.passenger.state.StateOfApp;
import co.tara.tarabari.passenger.utils.IdGenerator;

/**
 * Created by jalalnia on 5/3/2017.
 */
public class MainActivity extends AppCompatActivity {



    private MyTabLayout tabLayout;

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    public Trip trip;
    public StateOfApp stateOfApp;
    private String[] viewPagerTitles = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getSupportActionBar().setElevation(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        stateOfApp = new StateOfApp(this,fragmentManager,0);
        viewPagerTitles[1] = getString(R.string.startTrip);
        viewPagerTitles[0] = getString(R.string.currentTrip);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (MyTabLayout) findViewById(R.id.tabsApp);



        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
  /*      Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final int value = extras.getInt("StateId");


            if (value == 2) {

                trip = (Trip) getIntent().getSerializableExtra("Trip");
            } else {

                trip = new Trip();
            }

            getState(value, trip);

            trip.setId(Config.preferences.getInt("AccontId", 20));
        }
        trip = new Trip();
        getState(1, trip);*/


    }
    private void setupTabIcons() {

        MyTextView tabOne = (MyTextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getString(R.string.currentTrip));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        MyTextView tabTwo = (MyTextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText( getString(R.string.startTrip));

        tabLayout.getTabAt(1).setCustomView(tabTwo);


    }
    public void getState(int value, Trip trip) {


        if (value == 1) {
            stateOfApp.goToStateNormal();
        } else if (value == 2) {

            stateOfApp.goToStateGetPrice(trip);
        } else if (value == 3) {


        } else {
            stateOfApp.goToStateNormal();
        }


    }


    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(1);

    }
    class ViewPagerAdapter extends PagerAdapter {
        RelativeLayout newTripFragmentLayout = null;
        RelativeLayout passTripFragmentLayout = null;

        NewTripFragment newTripFragment = NewTripFragment.newInstance(stateOfApp);
        PassTripFragment passTripFragment = new PassTripFragment();

        FragmentManager fragmentManager = null;
        FragmentTransaction fragmentTransaction = null;


        private ViewPagerAdapter() {
            newTripFragmentLayout = new RelativeLayout(getApplicationContext());
            newTripFragmentLayout.setId(IdGenerator.getId("newTripFragmentLayout"));
            newTripFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            passTripFragmentLayout = new RelativeLayout(getApplicationContext());
            passTripFragmentLayout.setId(IdGenerator.getId("passTripFragmentLayout"));
            passTripFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        }

        public ViewPagerAdapter(FragmentManager manager) {
            this();
            this.fragmentManager = manager;

        }


        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return viewPagerTitles[position];
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (View) object == view;
        }

        @Deprecated
        public Object instantiateItem(View container, int position) {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (position == 1) {

                fragmentTransaction.add(newTripFragmentLayout.getId(), newTripFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(newTripFragmentLayout, 0);
                return newTripFragmentLayout;
            } else if (position == 0) {

                fragmentTransaction.add(passTripFragmentLayout.getId(), passTripFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(passTripFragmentLayout, 0);
                return passTripFragmentLayout;
            }

            return null;
        }


    }
    @Override
    public void onBackPressed() {

        if (stateOfApp.getState() == 0) {
            super.onBackPressed();
        } else if (stateOfApp.getState() == 1) {

            stateOfApp.goToStateNormal();
            stateOfApp.markerOrgin.remove();

        } else if (stateOfApp.getState() == 2) {

            stateOfApp.googleMap.getUiSettings().setAllGesturesEnabled(true);
            stateOfApp.goToStateSelectDistination();
            stateOfApp.markerDestination.remove();
            if (stateOfApp.isSecondTrip()) {
                stateOfApp.setSecondTrip(false);
                stateOfApp.markerDestination2.remove();

            }
        } else if (stateOfApp.getState() == 3) {

            trip.setDistance2(0);
            trip.setAllDistance2(0);
            stateOfApp.setSecondTrip(false);
            stateOfApp.goToStateGetPrice(trip);

        }

    }
    @Override
    protected void onResume() {
        super.onResume();

        if (stateOfApp.sabtBar && stateOfApp.getState() == 1) {

            stateOfApp.goToStateGetPrice(trip);

        }

    }

}
