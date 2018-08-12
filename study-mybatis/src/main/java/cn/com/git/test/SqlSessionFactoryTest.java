package cn.com.git.test;

import cn.com.git.dao.SysUserMapper;
import cn.com.git.entity.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 原生       dao ====> daoimpl
 * mybatis      mapper =====>xxMapper.xml
 *
 * SqlSession 代表和数据库的一次回话，非线程安全的，用完要释放资源
 * SqlSession 和 connect 都是非线程安全的，在多线程情况下会发生资源竞争，
 * 所以每次使用都要重新获取 ；
 *
 * mapper 接口没有实现类，到时候mybatis为其创建一个代理对象（将接口和xml 绑定）、
 *
 * 两个重要的配置文件
 *  1、mybatis 全局配置文件：包括数据库连接池信息、事务管理器信息、。。系统运行环境信息
 *  2、sql 映射文件：
 */
public class SqlSessionFactoryTest {


    /**
     * 1 、 根据xml 配置文件(全局配置文件) 创建一个 sqlSessionFactory
     * @param arg
     * @throws IOException
     */
    public static void main(String [] arg) throws IOException {
        SqlSessionFactoryTest t =  new SqlSessionFactoryTest() ;
        t.selectOne() ;
        t.selectOneByMapper();
    }

    public void selectOne () throws IOException {
        SqlSession sqlSession = getSqlSession() ;
        try{
            System.out.print("------- 普通查询 ----");
            SysUser sysUser = sqlSession.selectOne("cn.com.git.dao.SysUserMapper.selectSysUser","1") ;
            System.out.print(sysUser);
        }finally {
            sqlSession.close();
        }

    }

    /**
     * 通过 Mapper 接口查询数据
     * 接口式变成
     * @throws IOException
     */
    public void selectOneByMapper() throws IOException {
        SqlSession sqlSession = getSqlSession() ;

        try{
            System.out.print("------- Mapper 接口查询 ----");
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class) ;
            SysUser sysUser = sysUserMapper.selectSysUser(1) ;
            System.out.print(sysUser);
        }finally {
            sqlSession.close();
        }
    }


    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession() ;
        return sqlSession ;
    }
}
