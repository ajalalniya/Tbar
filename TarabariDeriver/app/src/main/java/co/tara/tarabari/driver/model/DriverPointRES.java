package co.tara.tarabari.driver.model;



import java.io.Serializable;

/**
 * Created by SedAliReza on 5/7/2017.
 */

public class DriverPointRES implements Serializable {
    private double lat;
    private double lng;
    private long pk_id;
    private long pk_trip;

    public long getPk_trip() {
        return pk_trip;
    }

    public void setPk_trip(long pk_trip) {
        this.pk_trip = pk_trip;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }
}
