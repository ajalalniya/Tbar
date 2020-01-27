package co.tara.tarabari.passenger.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.tara.tarabari.passenger.Config;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.adapter.PassTripAdapter;
import co.tara.tarabari.passenger.model.PassTrip;

/**
 * Created by jalalnia on 6/17/2017.
 */

public class PassTripFragment extends Fragment {
@BindView(R.id.rec_pass)
    public RecyclerView recyclerView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pass_trip,container,false);
        ButterKnife.bind(this, view);


        ArrayList<PassTrip> passTrips =new ArrayList<>();

        for (int i=0 ; i<=9;i++){
            PassTrip passTrip =new PassTrip();

            passTrips.add(passTrip);


        }



        RecyclerView rycAppList = (RecyclerView) view.findViewById(R.id.rec_pass);

        PassTripAdapter passTripAdapter = new PassTripAdapter(passTrips);
        LinearLayoutManager passTripLayoutManagaer
                = new LinearLayoutManager(Config.context);
        rycAppList.setLayoutManager(passTripLayoutManagaer);
        rycAppList.setAdapter(passTripAdapter);



        return view;

    }
}
