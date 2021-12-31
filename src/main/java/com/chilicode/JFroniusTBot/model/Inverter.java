
package com.chilicode.JFroniusTBot.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Inverter {

    @SerializedName("DT")
    @Expose
    private Float dt;
    @SerializedName("E_Day")
    @Expose
    private Float eDay;
    @SerializedName("E_Total")
    @Expose
    private Float eTotal;
    @SerializedName("E_Year")
    @Expose
    private Float eYear;
    @SerializedName("P")
    @Expose
    private Float p;

    public Float getDt() {
        return dt;
    }

    public void setDt(Float dt) {
        this.dt = dt;
    }

    public Float getEDay() {
        return eDay;
    }

    public void setEDay(Float eDay) {
        this.eDay = eDay;
    }

    public Float getETotal() {
        return eTotal;
    }

    public void setETotal(Float eTotal) {
        this.eTotal = eTotal;
    }

    public Float getEYear() {
        return eYear;
    }

    public void setEYear(Float eYear) {
        this.eYear = eYear;
    }

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
    }

}
