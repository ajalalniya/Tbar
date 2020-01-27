package co.tara.tarabari.driver.model;



import java.io.Serializable;

/**
 * Created by SedAliReza on 5/3/2017.
 */

public class StateRES implements Serializable{
    private boolean s_f;
    private String msg;


    private long pk_id;
    private int stateKey;
    private TripRES tripRES;

    public boolean isS_f() {
        return s_f;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
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

    public int getStateKey() {
        return stateKey;
    }

    public void setStateKey(int stateKey) {
        this.stateKey = stateKey;
    }

    public TripRES getTripRES() {
        return tripRES;
    }

    public void setTripRES(TripRES tripRES) {
        this.tripRES = tripRES;
    }
}
