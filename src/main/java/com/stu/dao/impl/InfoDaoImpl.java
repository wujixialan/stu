package com.stu.dao.impl;

import com.stu.dao.InfoDao;
import com.stu.entity.Info;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InfoDaoImpl extends BaseDaoImpl implements InfoDao {
    /**
     * 保存发布信息
     *
     * @param info ：信息对象
     */
    @Override
    public void add(Info info) {
        getSession().saveOrUpdate(info);
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
        String hql = "from Info i order by i.infoTime desc";
        return getSession().createQuery(hql)
                .setFirstResult(limit * (curr - 1))
                .setMaxResults(limit)
                .list();
    }

    /**
     * 通过 infoId 过去某一篇信息。
     *
     * @param infoId
     * @return
     */
    @Override
    public Info findByInfoId(String infoId) {
        String hql = "from Info i where i.infoId = :infoId";
        return (Info) getSession().createQuery(hql)
                .setString("infoId", infoId)
                .uniqueResult();
    }

    /**
     * 获取发布信息的总记录数
     *
     * @return
     */
    @Override
    public long getTotal() {
        String hql = "select count(infoId) from Info";
        return (long) getSession().createQuery(hql)
                .uniqueResult();
    }

    /**
     * 删除某个发布信息。
     *
     * @param info
     */
    @Transactional
    @Override
    public void delInfo(Info info) {
        getSession().delete(info);
    }
}
