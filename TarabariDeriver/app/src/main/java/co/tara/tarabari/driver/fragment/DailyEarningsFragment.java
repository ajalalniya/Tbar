package co.tara.tarabari.driver.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.adapter.TodayTripAdapter;
import co.tara.tarabari.driver.model.TodayTrip;


/**
 * Created by jalalnia on 2/22/2017.
 */

public class DailyEarningsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_daily_earning,container,false);


        RecyclerView recyclerView = (RecyclerView)  view.findViewById(R.id.rec_trip);

        ArrayList<TodayTrip> todayTrips =new ArrayList<>();
        for (int i=0;i<=9;i++){
            TodayTrip todayTrip =new TodayTrip();
            todayTrips.add(todayTrip);

        }
        TodayTripAdapter todayTripAdapter =new TodayTripAdapter(todayTrips);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(todayTripAdapter);
        return view;
    }
}
