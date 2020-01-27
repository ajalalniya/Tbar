package co.tara.tarabari.passenger.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SedAliReza on 4/29/2017.
 */

public class TripRES implements Serializable {
    private boolean s_f;
    private String msg;


    private long pk_id_trip;


    private long pk_id_passenger;
    private String passenger_name;
    private String passenger_family;
    private String passenger_mobile_number;
    private String passenger_src_image;


   /*vehicle*/
    private long pk_id_vehicle;
    private String color;
    private String plackNumber;
    private Parameter vehicleType;
    private String model;
    private int productionYear;
    private int capacity;
    private boolean trafficPrivilege;
    private boolean evenPlackNumber;
    private boolean enable;
    private long pk_company_id;
    private String companyName;
/*driver*/
    private long pk_id_driver;
    private String driver_name;
    private String driver_family;
    private String driver_mobileNumber;
    private String driver_srcImage;
    private boolean driver_gender;
    private boolean driver_married;

    /*Load*/
    private LoadRES loadRES;




   private TripRES pTripRES;


    private double startLat;
    private double startLng;
    private double endLat;
    private double endLng;
    private double endLat2;
    private double endLng2;

    private Parameter tripType;
    private Parameter tripVehicleType;
    private long startTripTime;
    private long endTripTime;
    private int waitTime;
    private long distance;
    private long tripCost;
    private Parameter paymentType;
    private int passengerRate;
    private int driverRate;
    private int predictedTripTime;
    private boolean trafficprivilegeArea;


    private long acceptDriverDate;
    private long arrivalDestinationDate;
    private long comingDriverDate;
    private long loadingDate;
    private long startTripDate;
    private long deliveredLoadDate;
    private long endTripDate;


    private Parameter state;
    private long createDate;


    public boolean isS_f() {
        return s_f;
    }



    public long getPk_company_id() {
        return pk_company_id;
    }

    public void setPk_company_id(long pk_company_id) {
        this.pk_company_id = pk_company_id;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getStartTripTime() {
        return startTripTime;
    }

    public void setStartTripTime(long startTripTime) {
        this.startTripTime = startTripTime;
    }

    public long getEndTripTime() {
        return endTripTime;
    }

    public void setEndTripTime(long endTripTime) {
        this.endTripTime = endTripTime;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public Parameter getTripVehicleType() {
        return tripVehicleType;
    }

    public void setTripVehicleType(Parameter tripVehicleType) {
        this.tripVehicleType = tripVehicleType;
    }

    public void setS_f(boolean s_f) {
        this.s_f = s_f;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getPk_id_passenger() {
        return pk_id_passenger;
    }

    public void setPk_id_passenger(long pk_id_passenger) {
        this.pk_id_passenger = pk_id_passenger;
    }

    public LoadRES getLoadRES() {
        return loadRES;
    }

    public void setLoadRES(LoadRES loadRES) {
        this.loadRES = loadRES;
    }

    public long getPk_id_trip() {
        return pk_id_trip;
    }

    public void setPk_id_trip(long pk_id_trip) {
        this.pk_id_trip = pk_id_trip;
    }

    public long getPk_id_vehicle() {
        return pk_id_vehicle;
    }

    public void setPk_id_vehicle(long pk_id_vehicle) {
        this.pk_id_vehicle = pk_id_vehicle;
    }

    public double getEndLat2() {
        return endLat2;
    }

    public void setEndLat2(double endLat2) {
        this.endLat2 = endLat2;
    }

    public double getEndLng2() {
        return endLng2;
    }

    public void setEndLng2(double endLng2) {
        this.endLng2 = endLng2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlackNumber() {
        return plackNumber;
    }

    public void setPlackNumber(String plackNumber) {
        this.plackNumber = plackNumber;
    }

    public Parameter getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Parameter vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isTrafficPrivilege() {
        return trafficPrivilege;
    }

    public void setTrafficPrivilege(boolean trafficPrivilege) {
        this.trafficPrivilege = trafficPrivilege;
    }

    public boolean isEvenPlackNumber() {
        return evenPlackNumber;
    }

    public void setEvenPlackNumber(boolean evenPlackNumber) {
        this.evenPlackNumber = evenPlackNumber;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public long getPk_id_driver() {
        return pk_id_driver;
    }

    public void setPk_id_driver(long pk_id_driver) {
        this.pk_id_driver = pk_id_driver;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_family() {
        return driver_family;
    }

    public void setDriver_family(String driver_family) {
        this.driver_family = driver_family;
    }

    public String getDriver_mobileNumber() {
        return driver_mobileNumber;
    }

    public void setDriver_mobileNumber(String driver_mobileNumber) {
        this.driver_mobileNumber = driver_mobileNumber;
    }

    public String getDriver_srcImage() {
        return driver_srcImage;
    }

    public void setDriver_srcImage(String driver_srcImage) {
        this.driver_srcImage = driver_srcImage;
    }

    public boolean isDriver_gender() {
        return driver_gender;
    }

    public void setDriver_gender(boolean driver_gender) {
        this.driver_gender = driver_gender;
    }

    public boolean isDriver_married() {
        return driver_married;
    }

    public void setDriver_married(boolean driver_married) {
        this.driver_married = driver_married;
    }

    public TripRES getpTripRES() {
        return pTripRES;
    }

    public void setpTripRES(TripRES pTripRES) {
        this.pTripRES = pTripRES;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLng() {
        return endLng;
    }

    public void setEndLng(double endLng) {
        this.endLng = endLng;
    }

    public Parameter getTripType() {
        return tripType;
    }

    public void setTripType(Parameter tripType) {
        this.tripType = tripType;
    }



    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
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

    public Parameter getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Parameter paymentType) {
        this.paymentType = paymentType;
    }

    public int getPassengerRate() {
        return passengerRate;
    }

    public void setPassengerRate(int passengerRate) {
        this.passengerRate = passengerRate;
    }

    public int getDriverRate() {
        return driverRate;
    }

    public void setDriverRate(int driverRate) {
        this.driverRate = driverRate;
    }

    public int getPredictedTripTime() {
        return predictedTripTime;
    }

    public void setPredictedTripTime(int predictedTripTime) {
        this.predictedTripTime = predictedTripTime;
    }

    public boolean isTrafficprivilegeArea() {
        return trafficprivilegeArea;
    }

    public void setTrafficprivilegeArea(boolean trafficprivilegeArea) {
        this.trafficprivilegeArea = trafficprivilegeArea;
    }


    public Parameter getState() {
        return state;
    }

    public void setState(Parameter state) {
        this.state = state;
    }



    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_family() {
        return passenger_family;
    }

    public void setPassenger_family(String passenger_family) {
        this.passenger_family = passenger_family;
    }

    public String getPassenger_mobile_number() {
        return passenger_mobile_number;
    }

    public void setPassenger_mobile_number(String passenger_mobile_number) {
        this.passenger_mobile_number = passenger_mobile_number;
    }

    public String getPassenger_src_image() {
        return passenger_src_image;
    }

    public void setPassenger_src_image(String passenger_src_image) {
        this.passenger_src_image = passenger_src_image;
    }
}
