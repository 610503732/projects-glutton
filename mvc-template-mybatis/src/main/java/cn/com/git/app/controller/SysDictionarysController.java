package cn.com.git.app.controller;

import cn.com.git.app.entity.pojo.SysDictionarys;
import cn.com.git.app.service.SysDictionarysService;
import cn.com.git.app.service.SysUserService;
import cn.com.git.common.entity.DataResult;
import cn.com.git.framework.annotation.SystemLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 数据字典路由
 */
@RequestMapping("/dict")
@Controller
public class SysDictionarysController {

    private static Logger logger = LoggerFactory.getLogger(SysDictionarysController.class);// slf4j日志记录器

    /**
     * 数据字典服务
     */
    @Autowired
    private SysDictionarysService sysDictionarysService ;

    /**
     * 数据字典
     * @return
     */
    @RequestMapping(value="/all",method=RequestMethod.GET)
    @ResponseBody
    public List<SysDictionarys> dict(){
        return sysDictionarysService.getAllDict();
    }



    @SystemLog(module="数据字典保存")
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public DataResult add(SysDictionarys dict){
        return sysDictionarysService.addDict(dict);
    }
}
