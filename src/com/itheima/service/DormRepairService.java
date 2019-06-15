package com.itheima.service;

import com.itheima.po.DormRepair;
import com.itheima.po.PageInfo;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:25
 **/
public interface DormRepairService {

    //分页查询
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize);

    public int addDormRepair(DormRepair dormrepair);    //添加宿舍信息
    public int deleteDormRepair(Integer r_id);   //删除宿舍信息
    public int updateDormRepair(DormRepair dormrepair); //修改宿舍信息
    public DormRepair findDormRepairById(Integer r_id);
    public List<DormRepair> getAll();
}
