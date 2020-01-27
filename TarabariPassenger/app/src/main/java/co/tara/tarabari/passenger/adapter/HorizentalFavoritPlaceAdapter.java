package co.tara.tarabari.passenger.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.HorizentalFavorit;
import co.tara.tarabari.passenger.myview.MyTextView;

/**
 * Created by jalalnia on 6/18/2017.
 */

public class HorizentalFavoritPlaceAdapter extends RecyclerView.Adapter<HorizentalFavoritPlaceAdapter.MyViewHolder> {

    private List<HorizentalFavorit> horizontalList;




    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout relativeLayout;
        public MyTextView title;


        public MyViewHolder(View view) {
            super(view);

            title = (MyTextView) view.findViewById(R.id.txtFav);

            relativeLayout = (RelativeLayout) view.findViewById(R.id.relFav);

        }


    }

    public HorizentalFavoritPlaceAdapter(List<HorizentalFavorit> horizontalList) {

        this.horizontalList = horizontalList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_horizental_favorit_place, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.title.setText(horizontalList.get(position).title);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

}
