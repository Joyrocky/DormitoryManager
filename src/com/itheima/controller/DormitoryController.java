package com.itheima.controller;



import com.itheima.po.Dormitory;
import com.itheima.po.PageInfo;
import com.itheima.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class DormitoryController {
	// 依赖注入
	@Autowired
	private DormitoryService dormitoryService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findDormitory")
	public String findDormitory(String a_name,Integer s_dormitoryid,String d_dormbuilding,
								Integer pageIndex, Integer pageSize, Model model) {

	  PageInfo<Dormitory> di = dormitoryService.findPageInfo(a_name,s_dormitoryid,
			  d_dormbuilding,pageIndex,pageSize);
	  model.addAttribute("di",di);
		return "dormitory_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormitorylist", method = RequestMethod.POST)
	@ResponseBody
	public List<Dormitory> exportDormitory(){
		List<Dormitory> dormitoryList = dormitoryService.getAll();
		return dormitoryList;
	}

	/**
	 * 添加宿舍信息
	 */
	@RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormitory( @RequestBody Dormitory dormitory) {
		int d = dormitoryService.addDormitory(dormitory);
		return "dormitory_list";
	}

	/**
	 * 删除宿舍信息
	 */
	@RequestMapping( "/deleteDormitory")
	@ResponseBody
	public String deleteDormitory(Integer d_id) {
		int d = dormitoryService.deleteDormitory(d_id);
		return "dormitory_list";
	}

	/**
	 * 修改学生信息
	 */
	@RequestMapping( "/updateDormitory")
	public String updateDormitory( Dormitory dormitory) {
		int d = dormitoryService.updateDormitory(dormitory);
		return "redirect:/findDormitory";
	}


	@RequestMapping( "/findDormitoryById")
	public String findDormitoryById(Integer d_id,HttpSession session) {

		Dormitory d= dormitoryService.findDormitoryById(d_id);
		session.setAttribute("d",d);
		return "dormitory_edit";
	}

	/**
	 * 宿舍人员信息查询
	 */
	@RequestMapping(value = "/findDormitoryStudent")
	public String findDormitoryStudent(Dormitory dormitory,Model model) {
		List<Dormitory> d = dormitoryService.findDormitoryStudent(dormitory);
		model.addAttribute("ds",d);
		return "dormitory_Studentlist";
	}


}
