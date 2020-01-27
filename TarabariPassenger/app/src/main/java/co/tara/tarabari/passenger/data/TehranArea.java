package co.tara.tarabari.passenger.data;

import com.google.android.gms.maps.model.LatLng;

import co.tara.tarabari.passenger.Config;


/**
 * Created by Ali on 1/30/2017.
 */
public class TehranArea {


    /////////////////////////////uper rec////////////////////////
    public static final double upperUpLeftLat = 35.818450;
    public static final double upperUpLeftLng = 51.283912;

    public static final double upperDownLeftLat = 35.759766;
    public static final double upperDownLeftLng = 51.283912;

    public static final double upperUpRightLat = 35.818450;
    public static final double upperUpRightLng = 51.484733;

    public static final double upperDownRightLat = 35.759766;
    public static final double upperDownRightLng = 51.484733;
    /////////////////////////middle rec////////////////////


    public static final double middleUpLeftLat = 35.759766;
    public static final double middleUpLeftLng = 51.252972;


    public static final double middleDownLeftLat = 35.716347;
    public static final double middleDownLeftLng = 51.252972;

    public static final double middleUpRightLat = 35.759766;
    public static final double middleUpRightLng = 51.575386;

    public static final double middleDownRightLat = 35.716347;
    public static final double middleDownRightLng = 51.575386;

    /////////////////////////down rec////////////////////

    public static final double downUpLeftLat = 35.716347;
    public static final double downUpLeftLng = 51.221505;

    public static final double downDownLeftLat = 35.585602;
    public static final double downDownLeftLng = 51.221505;

    public static final double downUpRightLat = 35.716347;
    public static final double downUpRightLng = 51.516763;

    public static final double downDownRightLat = 35.579459;
    public static final double downDownRightLng = 51.516763;


    public void init(String str) {


        String[] myLatLngs = str.split(",");
        LatLng latlng;
        for (String myLatLng : myLatLngs) {
            latlng = new LatLng(Double.parseDouble(myLatLng.split(" ")[1]), Double.parseDouble(myLatLng.split(" ")[0]));
            Config.mytehran.add(latlng);
            //Log.i("----2", myLatLng);
        }


    }

    public void initTarh(String str) {


        String[] myLatLngs = str.split(",");
        LatLng latlng;
        for (String myLatLng : myLatLngs) {
            latlng = new LatLng(Double.parseDouble(myLatLng.split(" ")[1]), Double.parseDouble(myLatLng.split(" ")[0]));
            Config.mytarh.add(latlng);
            //Log.i("----2", myLatLng);
        }


    }

}
