package com.itheima.controller;


import com.itheima.po.Class;
import com.itheima.po.PageInfo;
import com.itheima.service.ClassService;
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
public class ClassController {
	// 依赖注入
	@Autowired
	private ClassService classService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findClass")
	public String findClass(Integer c_classid, String c_classname, String c_counsellor,
							Integer pageIndex, Integer pageSize, Model model) {

	  PageInfo<Class> ci = classService.findPageInfo(c_classname,c_counsellor,
			  c_classid,pageIndex,pageSize);
	  model.addAttribute("ci",ci);
	  model.addAttribute("c_classid",c_classid);
		return "class_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportclasslist", method = RequestMethod.POST)
	@ResponseBody
	public List<Class> exportClass(){
		List<Class> classList = classService.getAll();
		return classList;
	}

	/**
	 * 删除学生信息
	 */
	@RequestMapping( "/deleteClass")
	@ResponseBody
	public String deleteClass(Integer c_id) {
		int c = classService.deleteClass(c_id);
		return "class_list";
	}

	/**
	 * 添加班级信息
	 */
	@RequestMapping(value = "/addClass" ,method = RequestMethod.POST)
	@ResponseBody
	public String addClass( @RequestBody Class uclass) {
		int c = classService.addClass(uclass);
		return "class_list";
	}

	@RequestMapping( "/findClassById")
	public String findClassById( Integer c_id,HttpSession session) {
		Class c= classService.findClassById(c_id);
		session.setAttribute("c",c);
		return "class_edit";
	}

	/**
	 * 修改班级信息
	 */
	@RequestMapping(value = "/updateClass" ,method = RequestMethod.POST)

	public String updateClass( Class uclass) {
		int c = classService.updateClass(uclass);
		return "redirect:/findClass";
	}

	/**
	 * 班级人员信息查询
	 */
	@RequestMapping(value = "/findClassStudent")
	public String findClassStudent(Class uclass,Model model) {
		List<Class> c = classService.findClassStudent(uclass);
		model.addAttribute("cs",c);
		return "class_Studentlist";
	}

	//采用Ajax来提交表单，并返回JSON数据
//	@RequestMapping(value = "/findClassStudentlist",method = RequestMethod.POST)
//	@ResponseBody
//	public List<Class> findClassStudentlist(@RequestBody Class uclass){
//		List<Class> c = classService.findClassStudent(uclass);
//		return c;
//	}
}
