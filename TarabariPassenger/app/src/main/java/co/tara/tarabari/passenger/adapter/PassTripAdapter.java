package co.tara.tarabari.passenger.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.fragment.PassTripFragment;
import co.tara.tarabari.passenger.model.HorizentalFavorit;
import co.tara.tarabari.passenger.model.PassTrip;

/**
 * Created by jalalnia on 6/19/2017.
 */

public class PassTripAdapter extends RecyclerView.Adapter<PassTripAdapter.MyViewHolder> {

    private List<PassTrip> passTrips;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_current_trip, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return passTrips.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
    public PassTripAdapter(List<PassTrip> passTrips){

        this.passTrips=passTrips;
    }
}
