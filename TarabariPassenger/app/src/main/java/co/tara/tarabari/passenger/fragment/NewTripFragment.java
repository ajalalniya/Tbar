package co.tara.tarabari.passenger.fragment;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.passenger.Config;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.activity.LoadActivity1;
import co.tara.tarabari.passenger.adapter.CarSelectAdapter;
import co.tara.tarabari.passenger.adapter.HorizentalFavoritPlaceAdapter;
import co.tara.tarabari.passenger.model.Cars;
import co.tara.tarabari.passenger.model.HorizentalFavorit;
import co.tara.tarabari.passenger.model.Trip;
import co.tara.tarabari.passenger.model.TripRES;
import co.tara.tarabari.passenger.myview.MyTextView;
import co.tara.tarabari.passenger.myview.selector.BackToMain;
import co.tara.tarabari.passenger.myview.selector.MySelectorAdapter;
import co.tara.tarabari.passenger.myview.selector.MySelectorPage;
import co.tara.tarabari.passenger.rest.async.GetAddressDa;
import co.tara.tarabari.passenger.state.StateOfApp;
import co.tara.tarabari.passenger.utils.ManageMarkers;

/**
 * Created by jalalnia on 6/17/2017.
 */


public class NewTripFragment extends Fragment implements Observer, OnMapReadyCallback {
    @BindView(R.id.sourceAddress)
    public MyTextView originAddress;
    @BindView(R.id.distinationAddress)
    public MyTextView distinationAddress;
    @BindView(R.id.distinationAddress2)
    public MyTextView distinationAddress2;
    @BindView(R.id.loadDistinationAddress)
    public ProgressBar loadDistinationAddress;
    @BindView(R.id.loadDistinationAddress2)
    public ProgressBar loadDistinationAddress2;
    @BindView(R.id.loadSourceAddress)
    public ProgressBar loadSourceAddress;
    @BindView(R.id.finalTripBtn)
    public MyTextView finalTripBtn;
    @BindView(R.id.sourcePin)
    public ImageView sourcePine;
    @BindView(R.id.carddistination)
    public RelativeLayout distinationCard;
    @BindView(R.id.carddistination2)
    public RelativeLayout distinationCard2;
    @BindView(R.id.rel_favorite)
    public RelativeLayout relFavoritePlace;
    @BindView(R.id.rel_select_car)
    public RelativeLayout relselectCar;
    public GoogleMap googleMap;
    public Trip trip;
    public Marker markerOrgin;
    public Marker markerDistination;
    public Marker markerDistination2;
    public List<Marker> carMarkers;
    public ViewPager viewPager;
    public Animation animation, revanimation;
    public int lastPosition = 0;
    public ImageView imgLine;
    public StateOfApp stateOfApp;
    private static final String STATEOFAPP = "STATE";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static NewTripFragment newInstance(StateOfApp stateOfApp) {
        NewTripFragment fragment = new NewTripFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(STATEOFAPP, stateOfApp);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        stateOfApp = (StateOfApp) getArguments().getSerializable(
                STATEOFAPP);


        getArguments().clear();
        View view = inflater.inflate(R.layout.fragment_new_trip, container, false);
        ButterKnife.bind(this, view);
        trip = new Trip();
        stateOfApp.setOrginAddress(originAddress);
        stateOfApp.setDistinationAddress(distinationAddress);
        stateOfApp.setGoogleMap(googleMap);
        stateOfApp.setLocationPin(sourcePine);
        stateOfApp.setLoadOrginAddress(loadSourceAddress);
        stateOfApp.setLoadDistinationAddress(loadDistinationAddress);
        stateOfApp.setDistinationAddressCard(distinationCard);
        stateOfApp.setDistinationAddressCard2(distinationCard2);
        stateOfApp.setRelselectCar(relselectCar);
        stateOfApp.setRelFavoritePlace(relFavoritePlace);
        if (stateOfApp.state == 0) {

            stateOfApp.goToStateNormal();
        }
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        imgLine = (ImageView) view.findViewById(R.id.imgLine);
  /*      SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/


        ArrayList<HorizentalFavorit> horizentalFavorits = new ArrayList<>();

        //TODO
        for (int i = 0; i <= 10; i++) {

            HorizentalFavorit horizentalFavorit = new HorizentalFavorit();
            horizentalFavorit.setTitle("انبار شماره 1");
            horizentalFavorits.add(horizentalFavorit);


        }

        RecyclerView rycAppList = (RecyclerView) view.findViewById(R.id.recFavorit);

        HorizentalFavoritPlaceAdapter horizontalAdapter = new HorizentalFavoritPlaceAdapter(horizentalFavorits);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Config.context, LinearLayoutManager.HORIZONTAL, true);
        rycAppList.setLayoutManager(horizontalLayoutManagaer);
        rycAppList.setAdapter(horizontalAdapter);

        // FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //    stateOfApp = new StateOfApp(getActivity(), fragmentManager, originAddress, distinationAddress, distinationAddress2, loadSourceAddress, loadDistinationAddress, loadDistinationAddress2, distinationCard, distinationCard2, sourcePine, 0);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        MySelectorPage pages = new MySelectorPage();
        final int viewPagerSize = pages.fill();


        viewPager.setAdapter(new MySelectorAdapter(getContext(), pages, new BackToMain() {
            @Override
            public void onFinish(int position) {


                viewPager.setCurrentItem(position, true);
            }
        }));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgLine.getLayoutParams();
                View next = viewPager.getChildAt(position);
                ImageView img = (ImageView) next.findViewById(R.id.bike);
                RelativeLayout rel2 = (RelativeLayout) next.findViewById(R.id.rel_bike);
                MyTextView txtTitle = (MyTextView) next.findViewById(R.id.txt_title);

                img.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                if (position == viewPagerSize) {

                    layoutParams.setMargins(0, convertDpToPixel(46, getActivity()), convertDpToPixel(160, getActivity()), 0);
                    imgLine.setLayoutParams(layoutParams);
                } else if (position == 0) {
                    layoutParams.setMargins(convertDpToPixel(160, getActivity()), convertDpToPixel(46, getActivity()), 0, 0);
                    imgLine.setLayoutParams(layoutParams);
                } else {
                    layoutParams.setMargins(0, convertDpToPixel(46, getActivity()), 0, 0);
                    imgLine.setLayoutParams(layoutParams);
                }
                if (Config.currentVersion >= Build.VERSION_CODES.JELLY_BEAN) {
                    rel2.setBackgroundResource(R.drawable.orangecircle);
                } else {
                    rel2.setBackgroundDrawable(getResources().getDrawable(R.drawable.orangecircle));
                }

                txtTitle.setTextColor(getResources().getColor(R.color.colorPrimary));
                openDialog();
                View current;
                if (lastPosition != -1) {
                    current = viewPager.getChildAt(lastPosition);
                    ImageView imageView = (ImageView) current.findViewById(R.id.bike);
                    RelativeLayout rel = (RelativeLayout) current.findViewById(R.id.rel_bike);
                    MyTextView txtTitle2 = (MyTextView) current.findViewById(R.id.txt_title);

                    imageView.setColorFilter(null);
                    if (Config.currentVersion >= Build.VERSION_CODES.JELLY_BEAN) {
                        rel.setBackgroundResource(R.drawable.graycircle);

                    } else {
                        rel.setBackgroundDrawable(getResources().getDrawable(R.drawable.graycircle));
                    }
                    txtTitle2.setTextColor(Color.argb(255, 0, 0, 0));
                    revanimation = AnimationUtils.loadAnimation(Config.context, R.anim.downscale);
                    revanimation.setFillAfter(true);
                    rel.startAnimation(revanimation);
                }

                animation = AnimationUtils.loadAnimation(Config.context, R.anim.upscale);
                animation.setFillAfter(true);
                rel2.startAnimation(animation);
                lastPosition = position;
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

   /*     Bundle extras = getIntent().getExtras();
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
        getState(1, trip);
*/

        return view;

    }

    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px = (int) (dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @OnClick(R.id.sourcePin)
    public void choiseOrgin() {
        ManageMarkers manageMarkers = new ManageMarkers();
        if (stateOfApp.getState() == 0) {

            trip.setLatOrigin(googleMap.getCameraPosition().target.latitude);
            trip.setLngOrigin(googleMap.getCameraPosition().target.longitude);
            stateOfApp.markerOrgin = manageMarkers.addMarker(googleMap, googleMap.getCameraPosition().target, (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_source), 213, 214);
            stateOfApp.goToStateSelectDistination();

        } else if (stateOfApp.getState() == 1) {

            trip.setLatDestination1(googleMap.getCameraPosition().target.latitude);
            trip.setLngDestination1(googleMap.getCameraPosition().target.longitude);
            stateOfApp.markerDestination = manageMarkers.addMarker(googleMap, new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_destination), 213, 214);
            Intent intent = new Intent(getContext(), LoadActivity1.class);
            intent.putExtra("trip", trip);
            // intent.putExtra("state",  stateOfApp);
            getActivity().startActivity(intent);

            stateOfApp.goToStateGetPrice(trip);
            //stateOfApp.goToStateGetPrice(trip);

        } else if (stateOfApp.getState() == 3) {
            trip.setLatDestination2(googleMap.getCameraPosition().target.latitude);
            trip.setLngDestination2(googleMap.getCameraPosition().target.longitude);
            markerDistination2 = manageMarkers.addMarker(googleMap, new LatLng(trip.getLatDestination2(), trip.getLngDestination2()), (BitmapDrawable) getResources().getDrawable(R.drawable.placeholder_destination), 213, 214);
            stateOfApp.setMarkerDestination2(markerDistination2);
            stateOfApp.goToStateGetPrice(trip);
        }


    }

    /*public void getState(int value, Trip trip) {


        if (value == 1) {
            stateOfApp.goToStateNormal();
        } else if (value == 2) {

            stateOfApp.goToStateGetPrice(trip);
        } else if (value == 3) {


        } else {
            stateOfApp.goToStateNormal();
        }


    }
*/

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        double lat = 35.7054921;
        double lng = 51.4014754;

        this.googleMap = googleMap;
        stateOfApp.setGoogleMap(googleMap);

        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {


                String loc = NewTripFragment.this.googleMap.getCameraPosition().target.latitude + "," + NewTripFragment.this.googleMap.getCameraPosition().target.longitude;
                GetAddressDa.getInstance().getAddress(loc, stateOfApp.getAddress(), stateOfApp.getLoadAddress());




               /* if (stateOfApp.getState() == 0) {


                    if(carMarkers!=null){


                       ManageMarkers manageMarkers =new ManageMarkers();
                        manageMarkers.removeMarkers(carMarkers);
                    }


                    GetCarLocationDa getCarLocationDa = new GetCarLocationDa(new AsyncResponseCars() {
                        @Override
                        public void processFinish(List<LatLng> output) {

                            ManageMarkers manageMarkers = new ManageMarkers();
                           carMarkers = manageMarkers.addMarkers(googleMap, output, (BitmapDrawable) getResources().getDrawable(R.drawable.ico_taxi), 213, 214);


                        }
                    });
                    getCarLocationDa.execute(MainActivity.this.googleMap.getCameraPosition().target);

                }*/


            }

        });


        CameraPosition position = CameraPosition.builder()
                .target(new LatLng(lat, lng))
                .zoom(16.0f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);

    }


    private void displayView(int position) {


        String title = getString(R.string.app_name);
        switch (position) {


            case 0:
                distinationCard.setVisibility(View.VISIBLE);

                break;
            case 1:
                distinationCard.setVisibility(View.GONE);
                break;
            case 2:

                break;
            default:
                break;
        }


        // set the toolbar title
        //getSupportActionBar().setTitle(title);


    }


    public void openDialog() {

        final Dialog dialog = new Dialog(getActivity());
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        dialog.show();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                TripRES result = (TripRES) data.getSerializableExtra("RESULT");


                stateOfApp.goToStateFindDriver(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }


    @Override
    public void update(Observable observable, Object o) {

    }
}
