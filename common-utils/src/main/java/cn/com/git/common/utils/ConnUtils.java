///**
// * @author 作者 lenovo
// * @Time 文件创建时间 2016年12月21日 下午11:00:46
// */
//package cn.com.git.common.utils;
//
//import java.sql.Connection;
//import java.util.Properties;
//
//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
//
///**
// * <b>描述：</b> 数据库操作帮助类
// *
// * @author 作者 lenovo
// * @version 版本号 2016年12月21日 下午11:00:46
// * @since 适用版本
// */
//public class ConnUtils {
//	// 连接池
//	private static BasicDataSource ds;
//	// 用于保存每个线程借走的连接
//	/*
//	 * ThreadLocal内部是一个Map key:调用ThreadLocal功能的线程 value:涉及到该线程使用的需要保存的数据
//	 */
//	private static ThreadLocal<Connection> threadLocal;
//	/*
//	 * 类的静态成员初始化工作应当放在静态块中完成 非静态成员一般在构造方法中初始化。 注意区分。
//	 */
//	static {
//		// 1 加载配置文件
//		/*
//		 * java.util.Properties 该类可以读取后缀名为.properties的 配置文件，并解析其中的配置项，将其以
//		 * 类似Map的形式表示，解析后我们就可以 通过该类根据"="左面的内容获取对应的 右面的值。
//		 */
//		try {
//			Properties prop = PropertiesUtils.getProperties("src/conf/dbConfig.properties");
//			String driverName = prop.getProperty("driver");
//			String host = prop.getProperty("host");
//			String username = prop.getProperty("username");
//			String password = prop.getProperty("password");
//			int maxActive = Integer.parseInt(prop.getProperty("maxActive"));
//			int maxWait = Integer.parseInt(prop.getProperty("maxWait"));
//			// 实例化连接池
//			ds = new BasicDataSource();
//			// 设置驱动
//			ds.setDriverClassName(driverName);
//			// 设置URL
//			ds.setUrl(host);
//			// 设置用户名
//			ds.setUsername(username);
//			// 设置密码
//			ds.setPassword(password);
//			// 设置最大连接数
//			ds.setMaxActive(maxActive);
//			// 设置最大等待时间
//			ds.setMaxWait(maxWait);
//
//			threadLocal = new ThreadLocal<Connection>();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 获取一个数据库的连接
//	 *
//	 * @return
//	 * @throws 当获取连接失败时抛出该异常
//	 */
//	public static Connection getConnection() throws Exception {
//		try {
//			/*
//			 * Connection getConnection() 连接池提供该方法用来获取一个可用的空闲
//			 * 连接。若连接池设置了最大等待时间，那么 当连接池没有可用连接时，该方法会进入阻塞 ，阻塞时间是最大等待时间，在期间连接池若
//			 * 有空闲连接该方法会立刻解除阻塞返回连接。 若超时后还没有可用连接，该方法会抛出超时 异常。
//			 */
//			Connection conn = ds.getConnection();
//			/*
//			 * 将当前调用set方法的线程作为key,参数作为 value存入ThreadLocal内部的Map中。
//			 */
//			threadLocal.set(conn);
//
//			return conn;
//		} catch (Exception e) {
//			// 这里可以感知异常，并记录日志等操作
//			// 抛出异常是通知调用者这里失败了。
//			throw e;
//		}
//	}
//
//	/**
//	 * 关闭数据库连接
//	 */
//	public static void closeConnection() {
//		try {
//			Connection conn = (Connection) threadLocal.get();
//			threadLocal.remove();
//			conn.close();
//		} catch (Exception e) {
//
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		System.out.println(ConnUtils.getConnection());
//	}
//}
