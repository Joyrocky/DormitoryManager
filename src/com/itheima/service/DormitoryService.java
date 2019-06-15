package com.itheima.service;

import com.itheima.po.Dormitory;
import com.itheima.po.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DormitoryService {

	//分页查询
	public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid,String d_dormbuilding, Integer pageIndex, Integer pageSize);

	public int addDormitory(Dormitory dormitory);    //添加宿舍信息
	public int deleteDormitory(Integer d_id);   //删除宿舍信息
	public int updateDormitory(Dormitory dormitory); //修改宿舍信息
	public Dormitory findDormitoryById(Integer d_id);

	public List<Dormitory> findDormitoryStudent(Dormitory dormitory);//查询宿舍人员信息
	public List<Dormitory> getAll();

}
