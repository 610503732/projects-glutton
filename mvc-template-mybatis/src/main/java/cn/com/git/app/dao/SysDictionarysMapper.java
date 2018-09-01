package cn.com.git.app.dao;

import cn.com.git.app.entity.pojo.SysDictionarys;

public interface SysDictionarysMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDictionarys record);

    int insertSelective(SysDictionarys record);

    SysDictionarys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDictionarys record);

    int updateByPrimaryKey(SysDictionarys record);
}