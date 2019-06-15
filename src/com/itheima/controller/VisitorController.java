package com.itheima.controller;

import com.itheima.po.PageInfo;
import com.itheima.po.Visitor;
import com.itheima.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客管理
 * @author: Joyrocky
 * @create: 2019-05-14 12:37
 **/
@Controller
public class VisitorController {
    //依赖注入
    @Autowired
    private VisitorService visitorService;
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findVisitor")
    public String findVisitor(String v_name, Integer v_phone , Integer pageIndex,
                              Integer pageSize, Model model) {

        PageInfo<Visitor> pi = visitorService.findPageInfo(v_name,v_phone,
                                                pageIndex,pageSize);
        model.addAttribute("pi",pi);
        model.addAttribute("v_name",v_name);
        return "visitor_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportvisitorlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Visitor> exportVisitor(){
        List<Visitor> visitorList = visitorService.getAll();
        return visitorList;
    }

    /**
     * 添加学生信息
     */

    @RequestMapping(value = "/addVisitor" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody Visitor visitor) {
        int v = visitorService.addVisitor(visitor);
        return "visitor_list";
    }

}

