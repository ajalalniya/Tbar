package co.tara.tarabari.driver.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
/*
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;*/

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalalnia on 2/20/2017.
 */

public class ManageMarkers {


  /*  public Marker addMarker(GoogleMap googleMap, LatLng latLng, BitmapDrawable bitmapDrawer, float height, float width) {


      *//* float height = 213;
       float width = 214;*//*
        MarkerOptions optionsOrginPin;
        BitmapDrawable bitmapdraw;

        bitmapdraw = (BitmapDrawable) bitmapDrawer;
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, (int) width, (int) height, false);
        optionsOrginPin = new MarkerOptions().position(latLng);
        optionsOrginPin.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        return googleMap.addMarker(optionsOrginPin);


    }


    public List<Marker> addMarkers(GoogleMap googleMap, List<LatLng> latLngs, BitmapDrawable bitmapDrawer, float height, float width) {
        MarkerOptions optionsOrginPin;
        BitmapDrawable bitmapdraw;

        bitmapdraw = (BitmapDrawable) bitmapDrawer;
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, (int) width, (int) height, false);
        List<Marker> markers = new ArrayList<Marker>();
        for (LatLng latLng : latLngs) {


            optionsOrginPin = new MarkerOptions().position(latLng);
            optionsOrginPin.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            Marker marker = googleMap.addMarker(optionsOrginPin);
            markers.add(marker);


        }


        return markers;


    }



    public void removeMarkers(List<Marker> markers) {


        for (Marker marker : markers) {
            marker.remove();
        }


    }

*/
}
