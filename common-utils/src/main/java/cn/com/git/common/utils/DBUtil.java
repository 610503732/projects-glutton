package cn.com.git.common.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 该类负责管理数据库的链接
 * @author Administrator
 *
 */
public class DBUtil {
    //	private static String driverName ;
//	private static String host ;
//	private static String username ;
//	private static String password ;
    private static BasicDataSource ds ;//连接池
    //用于保存每个线程借走的连接
    /*
     * ThreadLocal内部是一个Map
     * key:调用ThreadLocal功能的线程
     * value:涉及到该线程使用需要保存的数据
     */
    private static ThreadLocal threadLocal ;

    /**
     * 类的静态成员初始化工作应当放在静态块里面完成
     * 非静态成员一般在构造方法中初始化
     * 注意分区
     */
    static{
        //1.加载配置文件
        /*
         * java.util.Properties
         * 该类可以读取后缀名为。properties的配置文件
         * 并解析其中的配置项，将其以类似Map的形式表示，解析后我们就可以通过
         * 该类根据“=”左边的内容获取对应的右边的值
         */
        Properties prop = new Properties() ;
        try {
            prop.load(
                    new FileInputStream(
                            "config.properties"
                    )
            ) ;
            String driverName = prop.getProperty("driver") ;
            String host = prop.getProperty("host") ;
            String username = prop.getProperty("username") ;
            String password = prop.getProperty("password" ) ;
            int maxActive = Integer.parseInt(
                    prop.getProperty("maxActive")
            );
            int maxWait = Integer.parseInt(
                    prop.getProperty("maxWait")
            ) ;
            //实例化连接池
            ds = new BasicDataSource() ;
            //设置驱动
            ds.setDriverClassName(driverName) ;
            //设置URL
            ds.setUrl(host) ;
            //设置用户名
            ds.setUsername(username) ;
            //设置密码
            ds.setPassword(password) ;
            //设置最大连接数
            ds.setMaxActive(maxActive) ;
            //设置最大准备时间
            ds.setMaxWait(maxWait) ;
            //

            threadLocal = new ThreadLocal() ;


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    /**
     * 获取一个数据库链接的方法
     * @return
     * @throws Exception 当获取链接失败时抛出异常
     */
    public static Connection getConnection() throws Exception{

        try {
            /**
             * Connection getConnection()
             * 连接池提供方法用来获取一个可用的控线连接
             * 若链接池设置了最大等待时间，那么当连接池
             * 没有可用的连接时，该方法会进入阻塞状态，阻塞时间为
             * 最大等待时间，在期间连接池若有空闲连接
             * 该方法就会立刻解除阻塞状态返回连接，若超时
             * 后还没有可用的连接，则该方法会抛出超时异常
             */
//			Class.forName(driverName) ;
//			Connection conn = DriverManager.getConnection(
//					host,
//					username,
//					password
//					) ;
            Connection conn = ds.getConnection() ;
            /*
             * 将当前调用set方法的线程作为key，参数作为
             * value存入ThreadLocal内部的Map中
             */
            threadLocal.set(conn) ;
            return conn ;

        } catch (Exception e) {
            //这里可以感知到异常，并记录日志等操作
            //抛出异常是通知调用者这里的失败
            throw e ;
        }
    }
    /**
     * 关闭数据库连接
     */
    public static void closeConnection(){
        try {
            Thread t = Thread.currentThread() ;
            Connection conn
                    = (Connection)threadLocal.get() ;
            conn.close() ;
            threadLocal.remove() ;
        } catch (Exception e) {

        }
    }


}
