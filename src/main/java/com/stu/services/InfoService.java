package com.stu.services;

import com.stu.entity.Info;

import java.util.List;

public interface InfoService {
    /**
     * 保存发布信息
     * @param info
     */
    public void add(Info info);

    /**
     * 获取所有的发布信息
     * @return
     * @param curr
     * @param limit
     */
    public List<Info> findAllInfo(int curr, int limit);

    /**
     * 通过 infoId 过去某一篇信息。
     * @param infoId：信息 id
     * @return
     */
    public Info findByInfoId(String infoId);

    /**
     * 修改发布的信息
     * @param info
     */
    public void edit(Info info);

    /***
     * 获取发布信息的总记录数
     * @return
     */
    public long getTotal();

    /**
     * 删除 Info 对象
     * @param info
     */
    public void delInfo(Info info);
}
