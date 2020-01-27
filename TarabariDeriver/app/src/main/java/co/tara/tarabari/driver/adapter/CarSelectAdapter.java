package co.tara.tarabari.driver.adapter;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.model.Cars;


/**
 * Created by jalalnia on 6/19/2017.
 */

public class CarSelectAdapter extends RecyclerView.Adapter<CarSelectAdapter.MyViewHolder> {

    public List<Cars> cars;
    Dialog dialog;

    public CarSelectAdapter(List<Cars> cars, Dialog dialog) {
        this.cars = cars;
        this.dialog = dialog;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_select_car, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel_cars);
        }
    }

}
