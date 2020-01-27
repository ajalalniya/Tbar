package co.tara.tarabari.passenger.model;



import java.io.Serializable;

/**
 * Created by SedAliReza on 5/11/2017.
 */

public class VehicleDriverRES implements Serializable {
    private boolean s_f;
    private String msg;
    private long pk_vehicle_id;
    private long pk_driver_id;
    private long pk_company_id;
    private String plakNum;
    private String ownerName;

    public boolean isS_f() {
        return s_f;
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

    public long getPk_vehicle_id() {
        return pk_vehicle_id;
    }

    public void setPk_vehicle_id(long pk_vehicle_id) {
        this.pk_vehicle_id = pk_vehicle_id;
    }

    public long getPk_driver_id() {
        return pk_driver_id;
    }

    public void setPk_driver_id(long pk_driver_id) {
        this.pk_driver_id = pk_driver_id;
    }

    public long getPk_company_id() {
        return pk_company_id;
    }

    public void setPk_company_id(long pk_company_id) {
        this.pk_company_id = pk_company_id;
    }

    public String getPlakNum() {
        return plakNum;
    }

    public void setPlakNum(String plakNum) {
        this.plakNum = plakNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
