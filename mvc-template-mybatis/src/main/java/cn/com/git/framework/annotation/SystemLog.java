package cn.com.git.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 *自定义日志注解
 */  
  
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemLog {  
  
	String module()  default "";  //模块名称 系统管理-系统用户
	String method()  default "";  //新增用户
    String memo()  default "";  //备注
    boolean isSaveReqData() default false;//是否保存请求参数
}  
  
