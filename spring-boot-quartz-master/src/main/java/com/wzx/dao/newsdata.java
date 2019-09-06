package com.wzx.dao;

import java.util.ArrayList;

public class newsdata {
    private String stat;
    private ArrayList<news> data;
    public newsdata(String stat,ArrayList data){
        super();
        this.stat=stat;
        this.data=data;
    }
    public newsdata(){

    }

    @Override
    public String toString() {
        return "newsdata{" +
                "stat='" + stat + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public ArrayList<news> getData() {
        return data;
    }

    public void setData(ArrayList<news> data) {
        this.data = data;
    }
}
