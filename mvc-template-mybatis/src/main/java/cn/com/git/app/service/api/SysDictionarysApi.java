package cn.com.git.app.service.api;


import cn.com.git.app.entity.pojo.SysDictionarys;

import java.util.List;

/**
 * 数据字典
 */
public interface SysDictionarysApi {


    /**
     * 获取所有的字典
     * @return
     */
    public List<SysDictionarys> getAllDict();


}
