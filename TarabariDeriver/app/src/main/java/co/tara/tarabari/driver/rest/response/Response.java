package co.tara.tarabari.driver.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Ali on 2/4/2017.
 */

public class Response {



    @SerializedName("MESSAGE")
    @Expose
    private String mESSAGE;
    @SerializedName("RESULT")
    @Expose
    private String rESULT;

    public String getMESSAGE() {
        return mESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    public String getRESULT() {
        return rESULT;
    }

    public void setRESULT(String rESULT) {
        this.rESULT = rESULT;
    }

}
