package co.tara.tarabari.driver.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

//import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.DistanceFeeRES;
import co.tara.tarabari.driver.model.Parameter;
import co.tara.tarabari.driver.model.Trip;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.myview.MyTextView;
import co.tara.tarabari.driver.rest.AsyncResponse;
import co.tara.tarabari.driver.utils.InAreaUtil;
import co.tara.tarabari.driver.utils.parameters.ParameterID;


/**
 * Created by jalalnia on 2/18/2017.
 */

public class PriceRequestFragment extends Fragment  {


    private static final String TRIP = "trip_key";

    private Trip trip;

    @BindView(R.id.txt_cost)
    public TextView txt_cost;
    @BindView(R.id.costProgress)
    ProgressBar costProgress;
    /* @BindView(R.id.options_btn)
     RelativeLayout optionBtn;
 */
    @BindView(R.id.finalTripBtn)
    MyTextView finalTripBtn;
    InAreaUtil inAreaUtil;
    InAreaUtil inAreaUtil2;


    public static PriceRequestFragment newInstance(Trip mtrip) {
        PriceRequestFragment fragment = new PriceRequestFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TRIP, mtrip);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        trip = (Trip) getArguments().getSerializable(
                TRIP);


        getArguments().clear();


        View view = inflater.inflate(R.layout.fragment_price_request, container, false);


        ButterKnife.bind(this, view);


        inAreaUtil2 = new InAreaUtil();

/*        if (inAreaUtil2.isPointInTehran(new LatLng(trip.getLatOrigin(), trip.getLngOrigin()), Config.mytarh) && inAreaUtil2.isPointInTehran(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), Config.mytarh)) {


            trip.setInTarh(true);


        }*/
/*

        if (StateOfApp.isDialogOpen() && !StateOfApp.isSecondTrip()) {


            openDialog();
        }


        inAreaUtil = new InAreaUtil();


        if (!StateOfApp.isSecondTrip()) {
            if (inAreaUtil.isPointInTehran(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), Config.mytehran)) {
                GetDistanceDa asyncTask = new GetDistanceDa(new AsyncResponse() {

                    @Override
                    public void processFinish(Object output) {

                        trip.setAllDistance1(Integer.parseInt((String) output));
                        trip.setDisatance1(Integer.parseInt((String) output));
                        getPrice();

                    }
                });

                asyncTask.execute(new LatLng(trip.getLatOrigin(), trip.getLngOrigin()), new LatLng(trip.getLatDestination1(), trip.getLngDestination1()));


            } else {
                LatLng nearestPoint = inAreaUtil.findNearestPoint(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), Config.mytehran);
                GetDistanceDa asyncTask = new GetDistanceDa(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {

                        trip.setAllDistance1(Integer.parseInt((String) output));


                    }
                });

                asyncTask.execute(new LatLng(trip.getLatOrigin(), trip.getLngOrigin()), new LatLng(trip.getLatDestination1(), trip.getLngDestination1()));


                GetDistanceDa asyncTask2 = new GetDistanceDa(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {


                        trip.setDisatance1(Integer.parseInt((String) output));


                        getPrice();


                    }
                });

                asyncTask2.execute(new LatLng(trip.getLatOrigin(), trip.getLngOrigin()), nearestPoint);

            }
        } else {


            if (inAreaUtil.isPointInTehran(new LatLng(trip.getLatDestination2(), trip.getLngDestination2()), Config.mytehran)) {
                GetDistanceDa asyncTask = new GetDistanceDa(new AsyncResponse() {


                    @Override
                    public void processFinish(Object output) {

                        trip.setAllDistance2(Integer.parseInt((String) output));
                        trip.setDistance2(Integer.parseInt((String) output));
                        getPrice();
                     //   openDialog();

                    }
                });

                asyncTask.execute(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), new LatLng(trip.getLatDestination2(), trip.getLngDestination2()));


            } else {
                LatLng nearestPoint = inAreaUtil.findNearestPoint(new LatLng(trip.getLatDestination2(), trip.getLngDestination2()), Config.mytehran);
                GetDistanceDa asyncTask = new GetDistanceDa(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {

                        trip.setAllDistance2(Integer.parseInt((String) output));

                    }
                });

                asyncTask.execute(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), new LatLng(trip.getLatDestination2(), trip.getLatDestination2()));


                GetDistanceDa asyncTask2 = new GetDistanceDa(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {


                        trip.setDistance2(Integer.parseInt((String) output));


                        getPrice();
                       // openDialog();

                    }
                });

                asyncTask2.execute(new LatLng(trip.getLatDestination1(), trip.getLngDestination1()), nearestPoint);


            }
        }*/

        return view;


    }

    @OnClick(R.id.finalTripBtn)
    public void finalTrip() {


        TripRES tripRES = new TripRES();

        tripRES.setPk_id_passenger(33);
        tripRES.setLoadRES(null);
        tripRES.setStartLat(trip.getLatOrigin());
        tripRES.setStartLng(trip.getLngOrigin());
        tripRES.setEndLat(trip.getLatDestination1());
        tripRES.setEndLng(trip.getLngDestination1());
        Parameter pTripType = new Parameter();
        pTripType.setPk_id(ParameterID.NORMAL_TRIP);
        tripRES.setTripType(pTripType);
        Parameter pVehicleType = new Parameter();
        pVehicleType.setPk_id(ParameterID.TAXI);
        tripRES.setTripVehicleType(pVehicleType);
        tripRES.setWaitTime(100);
        tripRES.setDistance(trip.getDisatance1());
        tripRES.setTripCost(trip.getPrice());
        Parameter pPaymentType = new Parameter();
        pPaymentType.setPk_id(ParameterID.CACH_PAY_IN_DESTINATION);
        tripRES.setPaymentType(pPaymentType);


/*        String myTripres = new Gson().toJson(tripRES);

        FindingDriverApi findingDriver = MyOkClient.getClient().create(FindingDriverApi.class);*/

/*
        Call<String> call = findingDriver.findDriver(myTripres, "application/json");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

               Log.i("-------", "1111");

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("-------", "0000");
            }
        });*/


       /* final Intent intent =new Intent(getContext(), WaitForCarActivity.class);
        intent.putExtra("TRIP",tripRES);
        getActivity().startActivityForResult(intent,1);
*/



        // StateOfApp.goToState4(trip);

    }

/*

    @OnClick(R.id.options_btn)
    public void openDialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_extera);
        ButterKnife.bind(dialog);
        final RelativeLayout secondTripBtn = (RelativeLayout) dialog.findViewById(R.id.second_tripBtn);
        final RelativeLayout sweepBtn = (RelativeLayout) dialog.findViewById(R.id.sweepBtn);
        final RelativeLayout stopTimeBtn = (RelativeLayout) dialog.findViewById(R.id.stopTimeBtn);
        StateOfApp.setDialogOpen(true);

        if (StateOfApp.isSecondTrip()) {


            secondTripBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        if (trip.isSweepTrip()) {


            sweepBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {

            sweepBtn.setBackgroundColor(getResources().getColor(R.color.dialog_card));

        }

        if (trip.isWaitTrip()) {


            stopTimeBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {

            stopTimeBtn.setBackgroundColor(getResources().getColor(R.color.dialog_card));

        }

        secondTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!StateOfApp.isSecondTrip()) {
                   // StateOfApp.goToState3();
                    StateOfApp.setSecondTrip(true);
                    dialog.dismiss();
                } else {

                    secondTripBtn.setBackgroundColor(getResources().getColor(R.color.dialog_card));
                    trip.setDistance2(0);
                    trip.setAllDistance2(0);
                    StateOfApp.setSecondTrip(false);
                    StateOfApp.setSecondTrip(false);
                    StateOfApp.goToStateGetPrice(trip);
                    dialog.dismiss();
                    getPrice();


                }


            }
        });


        sweepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!trip.isSweepTrip()) {
                    trip.setSweepTrip(true);
                    getPrice();
                    dialog.dismiss();
                    StateOfApp.goToStateGetPrice(trip);
                } else {

                    trip.setSweepTrip(false);
                    getPrice();
                    dialog.dismiss();
                    StateOfApp.goToStateGetPrice(trip);

                }


            }
        });


        stopTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waitDialog(dialog);
            }
        });


        Log.i("-----aaaa", "aa   " + trip.getPrice());

        MyTextView txtCost = (MyTextView) dialog.findViewById(R.id.myCost);

        txtCost.setText("" + trip.getPrice());


        dialog.show();

    }
*/

 /*   @OnClick(R.id.discard_btn)
    public void opnDiscardDialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_takhfif);


        dialog.show();


    }
*/

   /* public void getPrice() {


        Parameter parameter1 = new Parameter();
        Parameter parameter2 = new Parameter();
      *//*  parameter[0].setPk_id(ParameterID.NORMAL_TRIP);
        parameter[1].setPk_id(ParameterID.TAXI);*//*
        parameter1.setPk_id(ParameterID.NORMAL_TRIP);
        parameter2.setPk_id(ParameterID.TAXI);

        DistanceFeeRES distanceFeeRES = new DistanceFeeRES();

        distanceFeeRES.setDistance(trip.getAllDistance1());
        distanceFeeRES.setTripType(parameter1);
        distanceFeeRES.setVehicleType(parameter2);

        GetPriceDa asyncTask = new GetPriceDa(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                trip.setPrice((long) output);
                txt_cost.setText((Long) output + "");
                costProgress.setVisibility(View.GONE);

            }
        });
        asyncTask.execute(distanceFeeRES);


    }*/


    public void waitDialog(Dialog exteraDialog) {


    }










   /* private void dialogExtera1(final List<ResponseWait> waitResponse) {
        String[] wait_Array = new String[waitResponse.size()];
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_extera);
       // final Spinner spinner = (Spinner) dialog.findViewById(R.id.wait_spinner);
        final RelativeLayout secondTripBtn = (RelativeLayout) dialog.findViewById(R.id.second_tripBtn);
        final RelativeLayout sweepBtn = (RelativeLayout) dialog.findViewById(R.id.sweepBtn);

        final MyButton okDialogBtn = (MyButton) dialog.findViewById(R.id.okDialogBtn);

        okDialogBtn.setText(trip.getPrice());
        int n = waitResponse.size();
        ResponseWait responseWait0 = new ResponseWait();
        waitResponse.add(responseWait0);


        for (int j = 0; j <= waitResponse.size(); j++) {


            ResponseWait responseWait2 = new ResponseWait();
            responseWait2 = waitResponse.get(n);

            waitResponse.add(n + 1, responseWait0);

            n--;
        }
        ResponseWait responseWait3 = new ResponseWait();

        responseWait3.setId(0);
        responseWait3.setPrice(0);
        responseWait3.setTime("0-5");
        waitResponse.add(0, responseWait3);

        okDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });

        final int price = trip.getPrice();
        sweepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!trip.isSweepTrip()) {
                    sweepBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    trip.setSweepTrip(true);
                    trip.setPrice(price + (price / 2));
                    MyButton myBtn = okDialogBtn;
                    myBtn.setText(trip.getPrice());

                } else {

                    sweepBtn.setBackgroundColor(getResources().getColor(R.color.register_btn));
                    trip.setSweepTrip(false);
                    trip.setPrice(price - (price / 2));
                    MyButton myBtn = okDialogBtn;
                    myBtn.setText(trip.getPrice());
                }


            }
        });

      *//*  secondTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!trip.isSecondTrip()) {
                    secondTripBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    trip.setSecondTrip(true);
                    dialog.dismiss();
                    //////////////////////////////////////////////////////

                } else {

                    secondTripBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    trip.setSecondTrip(false);

                }
            }
        });*//*
        int i = 0;
        for (ResponseWait responseWait : waitResponse) {


            wait_Array[i] = responseWait.getTime();
            i++;
        }


        ArrayAdapter NoCoreAdapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_spinner_item, wait_Array);

        spinner.setAdapter(NoCoreAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                String NoCore = parent.getItemAtPosition(pos).toString();
                int i = 0;
                for (ResponseWait responseWait : waitResponse) {
                    if (NoCore.equals(waitResponse.get(i).getTime())) {
                        trip.setWaitTime("" + waitResponse.get(i).getPrice());
                        i++;
                    }
                }
                MyButton myBtn = okDialogBtn;
                trip.setPrice(trip.getPrice() + Integer.parseInt(trip.getWaitTime()));
                myBtn.setText("" + trip.getPrice());
            }

            public void onNothingSelected(AdapterView parent) {
                trip.setWaitTime("" + waitResponse.get(0).getPrice());


            }


        });
        dialog.show();

    }

    private void dialogExtera() {
        DriverWaitApi driverWaitApi = DriverWaitClient.getClient().create(DriverWaitApi.class);
        Call<ResponseWaitArray> call = driverWaitApi.wait("selectAll");
        call.enqueue(new Callback<ResponseWaitArray>() {
            @Override
            public void onResponse(Call<ResponseWaitArray> call, retrofit2.Response<ResponseWaitArray> response) {

                int i = 0;

                List<ResponseWait> waitResponse = response.body().getRESULT();


                if (response.body().getMESSAGE().equals(String.valueOf(ResultMessages.SUCCESS))) {
                    dialogExtera1(waitResponse);

                } else if (response.body().getMESSAGE().equals(String.valueOf(ResultMessages.UN_SUCCESS))) {

                } else if (response.body().getMESSAGE().equals(String.valueOf(ResultMessages.SERVER_EXCEPTION))) {

                }
            }


            @Override
            public void onFailure(Call<ResponseWaitArray> call, Throwable t) {


                Log.i("----", "fieler");
            }
        });


    }
*/

    /*@Override
    public void processFinish(String output) {

        Log.i("--------","aaa :" +output);

    }*/
}
