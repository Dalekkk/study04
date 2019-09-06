package com.wzx.dao;

import java.util.ArrayList;

public class newsreason {
    private String reason;
    private ArrayList<newsdata> result;

    public newsreason(String reason,ArrayList result){
        super();
        this.reason=reason;
        this.result=result;
    }
    public newsreason(){

    }

    @Override
    public String toString() {
        return "newsreason{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ArrayList<newsdata> getResult() {
        return result;
    }

    public void setResult(ArrayList<newsdata> result) {
        this.result = result;
    }
}
