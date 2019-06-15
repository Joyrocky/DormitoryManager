package com.itheima.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: dormitorySystem
 * @description: 学生卫生
 * @author: Joyrocky
 * @create: 2019-04-25 12:12
 **/
public class StudentClean {
    private Integer g_id;
    private Integer s_studentid;
    private String s_name;
    private Integer s_grade;
    private Integer s_classid;
    private Integer s_dormitoryid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date update_time;

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
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

    public Integer getS_grade() {
        return s_grade;
    }

    public void setS_grade(Integer s_grade) {
        this.s_grade = s_grade;
    }

    public Integer getS_classid() {
        return s_classid;
    }

    public void setS_classid(Integer s_classid) {
        this.s_classid = s_classid;
    }

    public Integer getS_dormitoryid() {
        return s_dormitoryid;
    }

    public void setS_dormitoryid(Integer s_dormtoryid) {
        this.s_dormitoryid = s_dormtoryid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}

