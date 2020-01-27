package co.tara.tarabari.passenger.model;


import java.io.Serializable;

/**
 * Created by SedAliReza on 5/7/2017.
 */

public class DistanceFeeRES implements Serializable {
    private long distance;
    private Parameter vehicleType;
    private Parameter tripType;
    private long tripCost;
    private int waite;
    private boolean insurance;

    public int getWaite() {
        return waite;
    }

    public void setWaite(int waite) {
        this.waite = waite;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public Parameter getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Parameter vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Parameter getTripType() {
        return tripType;
    }

    public void setTripType(Parameter tripType) {
        this.tripType = tripType;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getTripCost() {
        return tripCost;
    }

    public void setTripCost(long tripCost) {
        this.tripCost = tripCost;
    }
}
