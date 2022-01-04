
package com.chilicode.JFroniusTBot.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Site {

    @SerializedName("E_Day")
    @Expose
    private Float eDay;
    @SerializedName("E_Total")
    @Expose
    private Float eTotal;
    @SerializedName("E_Year")
    @Expose
    private Float eYear;
    @SerializedName("Meter_Location")
    @Expose
    private String meterLocation;
    @SerializedName("Mode")
    @Expose
    private String mode;
    @SerializedName("P_Akku")
    @Expose
    private String pAkku;
    @SerializedName("P_Grid")
    @Expose
    private String pGrid;
    @SerializedName("P_Load")
    @Expose
    private String pLoad;
    @SerializedName("P_PV")
    @Expose
    private Float pPv;
    @SerializedName("rel_Autonomy")
    @Expose
    private String relAutonomy;
    @SerializedName("rel_SelfConsumption")
    @Expose
    private String relSelfConsumption;

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

    public String getMeterLocation() {
        return meterLocation;
    }

    public void setMeterLocation(String meterLocation) {
        this.meterLocation = meterLocation;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getPAkku() {
        return pAkku;
    }

    public void setPAkku(String pAkku) {
        this.pAkku = pAkku;
    }

    public String getPGrid() {
        return pGrid;
    }

    public void setPGrid(String pGrid) {
        this.pGrid = pGrid;
    }

    public String getPLoad() {
        return pLoad;
    }

    public void setPLoad(String pLoad) {
        this.pLoad = pLoad;
    }

    public Float getPPv() {
        return pPv;
    }

    public void setPPv(Float pPv) {
        this.pPv = pPv;
    }

    public String getRelAutonomy() {
        return relAutonomy;
    }

    public void setRelAutonomy(String relAutonomy) {
        this.relAutonomy = relAutonomy;
    }

    public String getRelSelfConsumption() {
        return relSelfConsumption;
    }

    public void setRelSelfConsumption(String relSelfConsumption) {
        this.relSelfConsumption = relSelfConsumption;
    }

}
