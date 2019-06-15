package com.itheima.controller;

import com.itheima.po.DormClean;
import com.itheima.po.PageInfo;
import com.itheima.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生控制器
 * @author: Joyrocky
 * @create: 2019-04-24 11:19
 **/

@Controller
public class DormCleanController {

    //依赖注入
    @Autowired
    private DormCleanService dormCleanService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormClean")
    public String findDormClean(Integer d_id,String d_dormbuilding,
                                Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<DormClean> di = dormCleanService.findPageInfo(d_id,d_dormbuilding,
                                            pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormclean_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormcleanlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormClean> exportDormclean(){
        List<DormClean> dormclean = dormCleanService.getAll();
        return dormclean;
    }

    /**
     * 添加宿舍卫生信息
     */
    @RequestMapping(value = "/addDormClean" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormClean( @RequestBody DormClean dormclean) {
        int d = dormCleanService.addDormClean(dormclean);
        return "dormclean_list";
    }

    /**
     * 删除宿舍卫生信息
     */
    @RequestMapping( "/deleteDormClean")
    @ResponseBody
    public String deleteDormClean(Integer g_id) {
        int d = dormCleanService.deleteDormClean(g_id);
        return "dormclean_list";
    }

    /**
     * 修改宿舍卫生信息
     */
    @RequestMapping( "/updateDormClean")
    public String updateDormClean( DormClean dormclean) {
        int d = dormCleanService.updateDormClean(dormclean);
        return "redirect:/findDormClean";
    }


    @RequestMapping( "/findDormCleanById")
    public String findDormCleanById(Integer g_id, HttpSession session) {

        DormClean d= dormCleanService.findDormCleanById(g_id);
        session.setAttribute("d",d);
        return "dormclean_edit";
    }


}

