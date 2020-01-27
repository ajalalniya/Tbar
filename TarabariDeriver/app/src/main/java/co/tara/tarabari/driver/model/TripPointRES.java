package co.tara.tarabari.driver.model;



import java.io.Serializable;

/**
 * Created by SedAliReza on 5/7/2017.
 */

public class TripPointRES implements Serializable {
    private boolean s_f;
    private String msg;
    private double lat;
    private double lng;
    private Parameter state_trip;

    private long acceptDriverDate;
    private long arrivalDestinationDate;
    private long comingDriverDate;
    private long loadingDate;
    private long startTripDate;
    private long deliveredLoadDate;
    private long endTripDate;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isS_f() {
        return s_f;
    }

    public void setS_f(boolean s_f) {
        this.s_f = s_f;
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

    public Parameter getState_trip() {
        return state_trip;
    }

    public void setState_trip(Parameter state_trip) {
        this.state_trip = state_trip;
    }

    public long getAcceptDriverDate() {
        return acceptDriverDate;
    }

    public void setAcceptDriverDate(long acceptDriverDate) {
        this.acceptDriverDate = acceptDriverDate;
    }

    public long getArrivalDestinationDate() {
        return arrivalDestinationDate;
    }

    public void setArrivalDestinationDate(long arrivalDestinationDate) {
        this.arrivalDestinationDate = arrivalDestinationDate;
    }

    public long getComingDriverDate() {
        return comingDriverDate;
    }

    public void setComingDriverDate(long comingDriverDate) {
        this.comingDriverDate = comingDriverDate;
    }

    public long getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(long loadingDate) {
        this.loadingDate = loadingDate;
    }

    public long getStartTripDate() {
        return startTripDate;
    }

    public void setStartTripDate(long startTripDate) {
        this.startTripDate = startTripDate;
    }

    public long getDeliveredLoadDate() {
        return deliveredLoadDate;
    }

    public void setDeliveredLoadDate(long deliveredLoadDate) {
        this.deliveredLoadDate = deliveredLoadDate;
    }

    public long getEndTripDate() {
        return endTripDate;
    }

    public void setEndTripDate(long endTripDate) {
        this.endTripDate = endTripDate;
    }
}
