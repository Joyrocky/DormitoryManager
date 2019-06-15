package com.itheima.dao;
import com.itheima.po.Admin;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface AdminDao {
	/**
	 * 通过账号和密码查询管理员
	 */
	public Admin findAdmin(Admin admin);

	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id);
	//获取用户列表
	public List<Admin> getAdminList(@Param("a_username") String a_username, @Param("a_describe") String a_describe,@Param("a_id") Integer a_id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addAdmin(Admin admin);    //添加管理员信息
	public int deleteAdmin(Integer a_id);   //删除管理员信息
	public int updateAdmin(Admin admin); //修改管理员信息
	public Admin findAdminById(Integer a_id);
	public List<Admin> getAll();
}
