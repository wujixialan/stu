package com.stu.dao;

import com.stu.entity.Info;

import java.util.List;

public interface InfoDao {
    /**
     * 保存发布信息
     * @param info：信息对象
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
     * @param infoId
     * @return
     */
    public Info findByInfoId(String infoId);

    /**
     * 获取发布信息的总记录数
     * @return
     */
    public long getTotal();

    /**
     * 删除某个发布信息。
     * @param info
     */
    public void delInfo(Info info);
}
