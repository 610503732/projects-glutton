package cn.com.git.framework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 日志aop
 */
@Aspect
@Component
public  class SystemLogAspect {

	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);


	//Controller层切点
	@Pointcut("@annotation(cn.com.git.framework.annotation.SystemLog)")
	public  void controllerAspect() {
	}

	/**  
	 * 前置通知 用于拦截Controller层记录用户的操作 
	 *
	 * @param joinPoint 切点
	 */
	@Before("controllerAspect()")
	public  void doBefore(JoinPoint joinPoint) {
		handleLog(joinPoint,null);
	}


	@AfterThrowing(value="controllerAspect()",throwing="e")
	public void doAfter(JoinPoint joinPoint,Exception e)
	{
		handleLog(joinPoint,e);
	}

	private void handleLog(JoinPoint joinPoint,Exception e) {
		logger.info("日志记录");
	}



}
