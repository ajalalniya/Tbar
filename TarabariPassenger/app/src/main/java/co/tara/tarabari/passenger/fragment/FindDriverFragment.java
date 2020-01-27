package co.tara.tarabari.passenger.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.model.TripRES;


/**
 * Created by jalalnia on 2/18/2017.
 */

public class FindDriverFragment extends Fragment {

    private static final String TRIP = "trip_key2";

    private TripRES trip;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static FindDriverFragment newInstance(TripRES mtrip) {
        FindDriverFragment fragment = new FindDriverFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TRIP, mtrip);
        fragment.setArguments(bundle);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        trip = (TripRES) getArguments().getSerializable(
                TRIP);


        getArguments().clear();
        View view = inflater.inflate(R.layout.fragment_find_driver,container,false);
        ButterKnife.bind(this, view);


        return view;



    }


    @OnClick(R.id.btn_ignore)
    public void ignored(){


//stateOfApp.goToState0();

    }



}
