package com.itheima.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Admin {
    private  Integer a_id;
    private  String  a_username;

    @JsonIgnore
    private  String  a_password;

    private  String  a_name;
    private  Integer a_phone;

    @JsonIgnore
    private  Integer a_power;

    private  String  a_describe;

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_username() {
        return a_username;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public Integer getA_phone() {
        return a_phone;
    }

    public void setA_phone(Integer a_phone) {
        this.a_phone = a_phone;
    }

    public Integer getA_power() {
        return a_power;
    }

    public void setA_power(Integer a_power) {
        this.a_power = a_power;
    }

    public String getA_describe() {
        return a_describe;
    }

    public void setA_describe(String a_describe) {
        this.a_describe = a_describe;
    }
}
