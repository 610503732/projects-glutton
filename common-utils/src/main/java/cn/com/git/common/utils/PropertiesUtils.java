package cn.com.git.common.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	
	/**
	 * 获取配置文件对象
	 * 
	 * @param confUrl
	 * @return
	 */
	public static Properties getProperties(String confPath) {
		try {
			//1 加载配置文件
			/*
			 * java.util.Properties
			 * 该类可以读取后缀名为.properties的
			 * 配置文件，并解析其中的配置项，将其以
			 * 类似Map的形式表示，解析后我们就可以
			 * 通过该类根据"="左面的内容获取对应的
			 * 右面的值。
			 */
			Properties props = new Properties();
			props.load(new FileInputStream(confPath));
			return props;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
