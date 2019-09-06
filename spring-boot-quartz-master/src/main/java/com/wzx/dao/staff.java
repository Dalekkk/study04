package com.wzx.dao;

public class staff {
    private String usercode;

    private String username;

    private String department;

    public staff(String usercode, String username, String department) {
        this.usercode = usercode;
        this.username = username;
        this.department = department;
    }

    @Override
    public String toString() {
        return '{'+
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public staff() {
        super();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

}