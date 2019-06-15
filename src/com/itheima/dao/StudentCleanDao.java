package com.itheima.dao;

import com.itheima.po.StudentClean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 学生卫生
 * @author: Joyrocky
 * @create: 2019-04-25 12:14
 **/
public interface StudentCleanDao {
    /**
     * 进行分页查询
     */
    //获取总条数
    public Integer totalCount(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name,@Param("s_dormitoryid") Integer s_dormitoryid);
    //获取用户列表
    public List<StudentClean> getStudentCleanList(@Param("s_studentid") Integer s_studentid, @Param("s_name") String s_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addStudentClean(StudentClean studentclean);    //添加宿舍卫生信息
    public int deleteStudentClean(Integer g_id);   //删除宿舍卫生信息
    public int updateStudentClean(StudentClean studentclean); //修改宿舍卫生信息
    public StudentClean findStudentCleanById(Integer g_id);

    public List<StudentClean> getAll();
}
