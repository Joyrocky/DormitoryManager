package com.itheima.dao;

import com.itheima.po.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客
 * @author: Joyrocky
 * @create: 2019-05-14 12:57
 **/
public interface VisitorDao {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("v_name") String v_name, @Param("v_phone")Integer v_phone);
    //获取用户列表
    public List<Visitor> getVisitorList(@Param("v_name") String v_name, @Param("v_phone")Integer v_phone,@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addVisitor(Visitor visitor);   //添加学生信息
    public List<Visitor> getAll();

}
