package co.tara.tarabari.driver.model;

import java.io.Serializable;


public class Parameter implements Serializable{
    private long pk_id;
    private Parameter pParent;
    private int key;
    private String keyTitle;
    private String keyValue;
    private int version;

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public Parameter getpParent() {
        return pParent;
    }

    public void setpParent(Parameter pParent) {
        this.pParent = pParent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getKeyTitle() {
        return keyTitle;
    }

    public void setKeyTitle(String keyTitle) {
        this.keyTitle = keyTitle;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
