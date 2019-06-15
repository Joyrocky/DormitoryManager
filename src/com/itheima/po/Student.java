package com.itheima.po;

public class Student {
    private static final long serialVersionUID = 1L;
    private  Integer s_id;
    private  Integer s_studentid;
    private  String  s_name;
    private  String  s_sex;
    private  Integer  s_age;
    private  Integer  s_phone;
    private  Integer  s_classid;
    private  String s_classname;
    private  Integer  s_dormitoryid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getS_studentid() {
        return s_studentid;
    }

    public void setS_studentid(Integer s_studentid) {
        this.s_studentid = s_studentid;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public Integer getS_age() {
        return s_age;
    }

    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }

    public Integer getS_phone() {
        return s_phone;
    }

    public void setS_phone(Integer s_phone) {
        this.s_phone = s_phone;
    }

    public Integer getS_classid() {
        return s_classid;
    }

    public void setS_classid(Integer s_classid) {
        this.s_classid = s_classid;
    }

    public String getS_classname() {
        return s_classname;
    }

    public void setS_classname(String s_classname) {
        this.s_classname = s_classname;
    }

    public Integer getS_dormitoryid() {
        return s_dormitoryid;
    }

    public void setS_dormitoryid(Integer s_dormitoryid) {
        this.s_dormitoryid = s_dormitoryid;
    }

}
