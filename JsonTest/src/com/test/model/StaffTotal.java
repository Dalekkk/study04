package com.test.model;

import java.util.List;

public class StaffTotal {
    private int total;
    private List<Staff> rows;

    public StaffTotal(){

    }
    public StaffTotal(int total,List<Staff> rows){
        this.total=total;
        this.rows=rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Staff> getRows() {
        return rows;
    }

    public void setRows(List<Staff> rows) {
        this.rows = rows;
    }

}
