package com.wzx.dao;

import java.util.ArrayList;

public class Total {
    private String total;
    private ArrayList<staff> rows;
    public Total(String total,ArrayList rows){
        super();
        this.total=total;
        this.rows=rows;
    }
    public Total(){
        super();
    }

    @Override
    public String toString() {
        return "Total{" +
                "total='" + total + '\'' +
                ", rows=" + rows +
                '}';
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<staff> getRows() {
        return rows;
    }

    public void setRows(ArrayList<staff> rows) {
        this.rows = rows;
    }
}
