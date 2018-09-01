package cn.com.git.app.service;

import cn.com.git.app.dao.SysDictionarysMapper;
import cn.com.git.app.entity.pojo.SysDictionarys;
import cn.com.git.app.service.api.SysDictionarysApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典服务 实现类
 */
@Service
public class SysDictionarysService implements SysDictionarysApi {


    @Autowired
    private SysDictionarysMapper sysDictionarysMapper ;

    @Override
    public List<SysDictionarys> getAllDict() {
        SysDictionarys dict = sysDictionarysMapper.selectByPrimaryKey("201805191512001") ;
        List<SysDictionarys> dicts = new ArrayList<SysDictionarys>() ;
        dicts.add(dict) ;
        return dicts;
    }
}
