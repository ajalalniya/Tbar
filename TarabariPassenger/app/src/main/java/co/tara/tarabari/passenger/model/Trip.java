package co.tara.tarabari.passenger.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ali on 2/1/2017.
 */
public class Trip implements Serializable {

    public int disatance1;
    public int distance2;
    public int allDistance1;
    public int allDistance2;
    public double latOrigin;
    public double lngOrigin;
    public boolean inTarh;
    public boolean waitTrip;
    public int id;
    public double latDestination1;
    public double lngDestination1;
    public double lngDestination2;

    public double getLngDestination1() {
        return lngDestination1;
    }

    public void setLngDestination1(double lngDestination1) {
        this.lngDestination1 = lngDestination1;
    }

    public double getLatDestination2() {
        return latDestination2;
    }

    public void setLatDestination2(double latDestination2) {
        this.latDestination2 = latDestination2;
    }

    public double latDestination2;
    public String waitTime;
    public Date StartTripTime;
    public boolean secondTrip;
    public boolean sweepTrip;
    public long price;

    public double getLatOrigin() {
        return latOrigin;
    }

    public void setLatOrigin(double latOrigin) {
        this.latOrigin = latOrigin;
    }

    public double getLngOrigin() {
        return lngOrigin;
    }

    public void setLngOrigin(double lngOrigin) {
        this.lngOrigin = lngOrigin;
    }

    public double getLatDestination1() {
        return latDestination1;
    }

    public void setLatDestination1(double latDestination1) {
        this.latDestination1 = latDestination1;
    }

    public double getLngDestination2() {
        return lngDestination2;
    }

    public void setLngDestination2(double lngDestination2) {
        this.lngDestination2 = lngDestination2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWaitTrip() {
        return waitTrip;
    }

    public void setWaitTrip(boolean waitTrip) {
        this.waitTrip = waitTrip;
    }

    public boolean isInTarh() {
        return inTarh;
    }

    public void setInTarh(boolean inTarh) {
        this.inTarh = inTarh;
    }

    public int getAllDistance1() {
        return allDistance1;
    }

    public void setAllDistance1(int allDistance1) {
        this.allDistance1 = allDistance1;
    }

    public int getAllDistance2() {
        return allDistance2;
    }

    public void setAllDistance2(int allDistance2) {
        this.allDistance2 = allDistance2;
    }



    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isSecondTrip() {
        return secondTrip;
    }

    public void setSecondTrip(boolean secondTrip) {
        this.secondTrip = secondTrip;
    }

    public boolean isSweepTrip() {
        return sweepTrip;
    }

    public void setSweepTrip(boolean sweepTrip) {
        this.sweepTrip = sweepTrip;
    }

    public int getDisatance1() {
        return disatance1;
    }

    public void setDisatance1(int diatance1) {
        this.disatance1 = diatance1;
    }

    public int getDistance2() {
        return distance2;
    }

    public void setDistance2(int distance2) {
        this.distance2 = distance2;
    }



    public String getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public Date getStartTripTime() {
        return StartTripTime;
    }

    public void setStartTripTime(Date startTripTime) {
        StartTripTime = startTripTime;
    }
}
