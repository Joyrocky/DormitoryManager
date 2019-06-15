package com.itheima.dao;

import com.itheima.po.DormRepair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-27 17:20
 **/
public interface DormRepairDao {

    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding);
    //获取用户列表
    public List<DormRepair> getDormRepairList(@Param("d_id") Integer d_id, @Param("d_dormbuilding") String d_dormbuilding, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addDormRepair(DormRepair dormrepair);    //添加宿舍信息
    public int deleteDormRepair(Integer r_id);   //删除宿舍信息
    public int updateDormRepair(DormRepair dormrepair); //修改宿舍信息
    public DormRepair findDormRepairById(Integer r_id);
    public List<DormRepair> getAll();

}
