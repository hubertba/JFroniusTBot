
package com.chilicode.JFroniusTBot.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("Inverters")
    @Expose
    private Inverters inverters;
    @SerializedName("Site")
    @Expose
    private Site site;
    @SerializedName("Version")
    @Expose
    private String version;

    public Inverters getInverters() {
        return inverters;
    }

    public void setInverters(Inverters inverters) {
        this.inverters = inverters;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
