package co.tara.tarabari.driver.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.TodayTrip;

/**
 * Created by jalalnia on 6/20/2017.
 */

public class TodayTripAdapter extends RecyclerView.Adapter<TodayTripAdapter.MyViewHolder> {

    public ArrayList<TodayTrip> todayTrips;

    public TodayTripAdapter(ArrayList<TodayTrip> todayTrips) {

        this.todayTrips = todayTrips;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_today_trip, parent, false);

        return new TodayTripAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return todayTrips.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
