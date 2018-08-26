package cn.com.git.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBUtil {

    private static final String MYSQL = "jdbc:mysql://";

    private static final String ORACLE = "jdbc:oracle:thin:@";

    private static final String SQLSERVER = "jdbc:microsoft:sqlserver://";


    private ConnectDBUtil() {

    }
    /**
     * 获取数据库的连接
     * @param DBType
     * @param url
     * @param user
     * @param password
     * @return
     * @throws SQLException
     */
    public static Connection getConnection(String DBType, String url,
                                           String user, String password) throws SQLException {
        if ("mysql".equalsIgnoreCase(DBType))
            return getMySqlConn(url, user, password);
        if ("oracle".equalsIgnoreCase(DBType))
            return getOracleConn(url, user, password);
        if ("sqlserver".equalsIgnoreCase(DBType)){
            return getSqlServerConn(url, user, password);

        }
        return null;
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * MySql连接的方法
     * @param url
     * @param user
     * @param password
     * @return
     * @throws SQLException
     */
    private static Connection getMySqlConn(String url, String user,
                                           String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(MYSQL + url, "root", "root");

        return conn;
    }
    /**
     * Oracle连接的方法
     * @param url
     * @param user
     * @param password
     * @return
     * @throws SQLException
     */
    private static Connection getOracleConn(String url, String user,
                                            String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(ORACLE + url, user, password);//zzf更改过用户名与密码两个参数

        return conn;
    }
    /**
     * SqlServer连接的方法
     * @param url
     * @param user
     * @param password
     * @return
     * @throws SQLException
     */
    private static Connection getSqlServerConn(String url, String user,
                                               String password) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");// 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(SQLSERVER + url, "root", "root");

        return conn;
    }
//    public static void main(String[] args) {
//        try {
//            Connection conn = getConnection("MySQL", "127.0.0.1", "root",
//                    "root");
//            if (conn == null) {
//                System.out.println("Connection the database is failled !(数据库连接失败!)");
//            } else {
//                System.out.println(conn.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
