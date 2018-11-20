package com.itheima.dao;

import com.itheima.po.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface ClassDao {
	/**
	 * 进行分页查询
	 */

	 //获取总条数
     public Integer totalCount(@Param("c_classname") String c_classname, @Param("c_counsellor") Integer c_counsellor, @Param("s_classid") String s_classid);
	 //获取用户列表
     public List<Class> getClassList(@Param("c_classname") String c_classname, @Param("c_counsellor") Integer c_counsellor, @Param("s_classid") String s_classid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int deleteClass(Integer c_id);   //删除班级信息
	public int addClass(Class ucalss);    //添加班级信息
	public int updateClass(Class uclass); //修改班级信息
	public Class findClassById(Integer c_id);
	public List<Class> findClassStudent(Class uclass);//查询班级人员信息
}
