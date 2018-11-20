package com.itheima.dao;

import com.itheima.po.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface DormitoryDao {
	/**
	 * 进行分页查询
	 */

	 //获取总条数
     public Integer totalCount(@Param("d_name") String d_name, @Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid);
	 //获取用户列表
     public List<Dormitory> getDormitoryList(@Param("d_name") String d_name, @Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addDormitory(Dormitory dormitory);    //添加宿舍信息
	public int deleteDormitory(Integer d_id);   //删除宿舍信息
	public int updateDormitory(Dormitory dormitory); //修改宿舍信息
	public Dormitory findDormitoryById(Integer d_id);

	public List<Dormitory> findDormitoryStudent(Dormitory dormitory);//查询宿舍人员信息


}
