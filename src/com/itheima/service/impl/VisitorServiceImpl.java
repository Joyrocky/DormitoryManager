package com.itheima.service.impl;

import com.itheima.dao.VisitorDao;
import com.itheima.po.PageInfo;
import com.itheima.po.Visitor;
import com.itheima.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客
 * @author: Joyrocky
 * @create: 2019-05-14 12:39
 **/
@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {
    // 注入studentDao
    @Autowired
    private VisitorDao visitorDao;


    //分页查询
    @Override
    public PageInfo<Visitor> findPageInfo(String v_name, Integer v_phone , Integer pageIndex, Integer pageSize) {
        PageInfo<Visitor> pi = new PageInfo<Visitor>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = visitorDao.totalCount(v_name,v_phone);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList =	visitorDao.getVisitorList(v_name,v_phone,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(visitorList);
        }
        return pi;
    }

    @Override
    public List<Visitor> getAll(){
        List<Visitor> visitorList = visitorDao.getAll();
        return visitorList;
    }

    //添加学生信息
    @Override
    public  int addVisitor(Visitor visitor) {
        return visitorDao.addVisitor(visitor);
    }
}

