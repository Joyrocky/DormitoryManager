package com.itheima.service.impl;

import com.itheima.dao.DormRepairDao;
import com.itheima.po.DormRepair;
import com.itheima.po.PageInfo;
import com.itheima.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:24
 **/
@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {
    // classDao
    @Autowired
    private DormRepairDao dormRepairDao;


    //分页查询
    @Override
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormRepairDao.totalCount(d_id,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormRepair> dormRepairList =	dormRepairDao.getDormRepairList(d_id,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }
        return pi;
    }

    @Override
    public List<DormRepair> getAll(){
        List<DormRepair> dormRepairList = dormRepairDao.getAll();
        return dormRepairList;
    }

    //添加宿舍信息
    @Override
    public int addDormRepair(DormRepair dormrepair) {
        return dormRepairDao.addDormRepair(dormrepair);
    }

    //通过id删除宿舍信息
    @Override
    public int deleteDormRepair(Integer r_id) {
        return dormRepairDao.deleteDormRepair(r_id);
    }

    //修改宿舍信息
    @Override
    public int updateDormRepair(DormRepair dormrepair) {
        return dormRepairDao.updateDormRepair(dormrepair);
    }

    @Override
    public DormRepair findDormRepairById (Integer r_id){
        DormRepair d = dormRepairDao.findDormRepairById(r_id);
        return  d;
    }

}

