package co.tara.tarabari.passenger.model;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by SedAliReza on 5/7/2017.
 */

public class LoadRES implements Serializable {
    private long pk_id;
    private Parameter loadType;
    private String srcLoadImage;
    private String weight;
    private String loadTypeDesc;
    private int loadTypeCode;
    private int loadCount;
    private String keyLoad;
    private String receiverName;
    private String receiverNationalCode;
    private String receiverMobileNumber;
    private boolean insurance;
    private String loadValue;
    private String correctEndAddress;
    private String loadInfo;


    private Parameter state;
    private long createDate;

    public String getLoadInfo() {
        return loadInfo;
    }

    public void setLoadInfo(String loadInfo) {
        this.loadInfo = loadInfo;
    }

    public String getCorrectEndAddress() {
        return correctEndAddress;
    }

    public void setCorrectEndAddress(String correctEndAddress) {
        this.correctEndAddress = correctEndAddress;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public Parameter getLoadType() {
        return loadType;
    }

    public String getLoadTypeDesc() {
        return loadTypeDesc;
    }

    public void setLoadTypeDesc(String loadTypeDesc) {
        this.loadTypeDesc = loadTypeDesc;
    }

    public int getLoadTypeCode() {
        return loadTypeCode;
    }

    public void setLoadTypeCode(int loadTypeCode) {
        this.loadTypeCode = loadTypeCode;
    }

    public int getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(int loadCount) {
        this.loadCount = loadCount;
    }

    public void setLoadType(Parameter loadType) {
        this.loadType = loadType;
    }

    public String getSrcLoadImage() {
        return srcLoadImage;
    }

    public void setSrcLoadImage(String srcLoadImage) {
        this.srcLoadImage = srcLoadImage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getKeyLoad() {
        return keyLoad;
    }

    public void setKeyLoad(String keyLoad) {
        this.keyLoad = keyLoad;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverNationalCode() {
        return receiverNationalCode;
    }

    public void setReceiverNationalCode(String receiverNationalCode) {
        this.receiverNationalCode = receiverNationalCode;
    }

    public String getReceiverMobileNumber() {
        return receiverMobileNumber;
    }

    public void setReceiverMobileNumber(String receiverMobileNumber) {
        this.receiverMobileNumber = receiverMobileNumber;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public String getLoadValue() {
        return loadValue;
    }

    public void setLoadValue(String loadValue) {
        this.loadValue = loadValue;
    }

    public Parameter getState() {
        return state;
    }

    public void setState(Parameter state) {
        this.state = state;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
