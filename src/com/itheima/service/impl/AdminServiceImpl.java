package com.itheima.service.impl;

import com.itheima.dao.AdminDao;
import com.itheima.po.Admin;
import com.itheima.po.PageInfo;
import com.itheima.service.AdminService;
import com.itheima.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	// 注入UserDao
	@Autowired
	private AdminDao adminDao;

	//管理登陆查询
	@Override
	public Admin findAdmin(Admin admin) {
		Admin a = adminDao.findAdmin(admin);
		return a;
	}

	@Override
	public List<Admin> getAll(){

		List<Admin> adminList = adminDao.getAll();
		return adminList;
    }

	@Override
	public PageInfo<Admin> findPageInfo(String a_username, String a_describe,Integer a_id,Integer pageIndex, Integer pageSize) {
		PageInfo<Admin> pi = new PageInfo<Admin>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = adminDao.totalCount(a_username,a_describe,a_id);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示管理员信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Admin> adminList =	adminDao.getAdminList(a_username,a_describe,a_id,
					(pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
			pi.setList(adminList);
		}
		return pi;
	}

	//添加管理员信息
	@Override
	public int addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	//通过id删除管理员信息
	@Override
	public int deleteAdmin(Integer a_id) {
		return adminDao.deleteAdmin(a_id);
	}

	//修改管理员信息
	@Override
	public int updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Override
	public Admin findAdminById (Integer a_id){
		Admin a = adminDao.findAdminById(a_id);
		return  a;
	}
}
