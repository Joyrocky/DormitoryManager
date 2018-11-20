package com.itheima.po;

public class Class {
    private  Integer c_id;
    private  Integer s_classid;
    private  String  c_classname;
    private  String  c_counsellor;
    private  Student  students;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getS_classid() {
        return s_classid;
    }

    public void setS_classid(Integer s_classid) {
        this.s_classid = s_classid;
    }

    public String getC_classname() {
        return c_classname;
    }

    public void setC_classname(String c_classname) {
        this.c_classname = c_classname;
    }

    public String getC_counsellor() {
        return c_counsellor;
    }

    public void setC_counsellor(String c_counsellor) {
        this.c_counsellor = c_counsellor;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }
}
