package com.stu.services.impl;

import com.stu.dao.InfoDao;
import com.stu.entity.Info;
import com.stu.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;

    /**
     * 保存发布信息
     *
     * @param info
     */
    @Override
    public void add(Info info) {
        infoDao.add(info);
    }

    /**
     * 获取所有的发布信息
     *
     * @return
     * @param curr
     * @param limit
     */
    @Override
    public List<Info> findAllInfo(int curr, int limit) {
        return infoDao.findAllInfo(curr, limit);
    }

    /**
     * 通过 infoId 过去某一篇信息。
     *
     * @param infoId ：信息 id
     * @return
     */
    @Override
    public Info findByInfoId(String infoId) {
        return infoDao.findByInfoId(infoId);
    }

    /**
     * 修改发布的信息
     *
     * @param info
     */
    @Override
    public void edit(Info info) {
        infoDao.add(info);
    }

    /***
     * 获取发布信息的总记录数
     * @return
     */
    @Override
    public long getTotal() {
        return infoDao.getTotal();
    }

    /**
     * 删除 Info 对象
     *
     * @param info
     */
    @Override
    public void delInfo(Info info) {
        infoDao.delInfo(info);
    }
}
