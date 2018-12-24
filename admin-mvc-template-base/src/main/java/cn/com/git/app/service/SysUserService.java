package cn.com.git.app.service;

import cn.com.git.app.dao.SysUserMapper;
import cn.com.git.app.entity.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper ;


    public SysUser findUserById(int id){
        return sysUserMapper.selectByPrimaryKey(id) ;
    }



}
