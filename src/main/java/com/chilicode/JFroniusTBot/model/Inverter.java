
package com.chilicode.JFroniusTBot.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Inverter {

    @SerializedName("DT")
    @Expose
    private Integer dt;
    @SerializedName("E_Day")
    @Expose
    private Integer eDay;
    @SerializedName("E_Total")
    @Expose
    private Integer eTotal;
    @SerializedName("E_Year")
    @Expose
    private Integer eYear;
    @SerializedName("P")
    @Expose
    private Integer p;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getEDay() {
        return eDay;
    }

    public void setEDay(Integer eDay) {
        this.eDay = eDay;
    }

    public Integer getETotal() {
        return eTotal;
    }

    public void setETotal(Integer eTotal) {
        this.eTotal = eTotal;
    }

    public Integer getEYear() {
        return eYear;
    }

    public void setEYear(Integer eYear) {
        this.eYear = eYear;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

}
