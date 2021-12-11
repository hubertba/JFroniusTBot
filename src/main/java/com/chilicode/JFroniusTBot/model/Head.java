
package com.chilicode.JFroniusTBot.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Head {

    @SerializedName("RequestArguments")
    @Expose
    private RequestArguments requestArguments;
    @SerializedName("Status")
    @Expose
    private Status status;
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;

    public RequestArguments getRequestArguments() {
        return requestArguments;
    }

    public void setRequestArguments(RequestArguments requestArguments) {
        this.requestArguments = requestArguments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
