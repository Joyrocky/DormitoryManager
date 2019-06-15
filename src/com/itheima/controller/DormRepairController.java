package com.itheima.controller;

import com.itheima.po.DormRepair;
import com.itheima.po.Dormitory;
import com.itheima.po.PageInfo;
import com.itheima.service.DormRepairService;
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
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-27 17:13
 **/
@Controller
public class DormRepairController {
    // 依赖注入
    @Autowired
    private DormRepairService dormRepairService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormRepair")
    public String findDormRepair(Integer d_id,String d_dormbuilding,
                                 Integer pageIndex, Integer pageSize, Model model) {

        PageInfo<DormRepair> di = dormRepairService.findPageInfo(d_id,d_dormbuilding,
                                                    pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormrepair_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormrepairlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormRepair> exportDormrepair(){
        List<DormRepair> dormRepairList = dormRepairService.getAll();
        return dormRepairList;
    }


    /**
     * 添加宿舍信息
     */
    @RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody DormRepair dormrepair) {
        int d = dormRepairService.addDormRepair(dormrepair);
        return "dormrepair_list";
    }

    /**
     * 删除宿舍信息
     */
    @RequestMapping( "/deleteDormRepair")
    @ResponseBody
    public String deleteDormRepair(Integer r_id) {
        int d = dormRepairService.deleteDormRepair(r_id);
        return "dormrepair_list";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping( "/updateDormRepair")
    public String updateDormRepair( DormRepair dormrepair) {
        int d = dormRepairService.updateDormRepair(dormrepair);
        return "redirect:/findDormRepair";
    }


    @RequestMapping( "/findDormRepairById")
    public String findDormRepairById(Integer r_id, HttpSession session) {

        DormRepair d= dormRepairService.findDormRepairById(r_id);
        session.setAttribute("d",d);
        return "dormrepair_edit";
    }

}

