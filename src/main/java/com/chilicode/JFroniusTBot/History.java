package com.chilicode.JFroniusTBot;

import java.util.Date;

public class History {
    
    Boolean running = false;
    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Float getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(Float currentPower) {
        this.currentPower = currentPower;
    }

    public Date getLastResponse() {
        return lastResponse;
    }

    public void setLastResponse(Date lastResponse) {
        this.lastResponse = lastResponse;
    }

    Float currentPower = 0.0f;
    Date lastResponse = new Date();

    private static History history;
    
    public History(){}
    
    //static block initialization for exception handling
    static{
        try{
            new History();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static History getInstance(){
        return history;
    }




}
