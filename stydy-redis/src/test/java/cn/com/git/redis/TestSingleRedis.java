package cn.com.git.redis;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;

/**
 * 单机版 redis  服务
 */
public class TestSingleRedis {

    private static Jedis jedis;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // 单个节点
        jedis = new Jedis("192.168.254.106");

    }

    @Test
    public void testString() {
//        // -----添加数据----------
        jedis.set("name", "zzf");// 向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));// 执行结果：xinxin

        jedis.append("name", " is my lover"); // 拼接
        System.out.println(jedis.get("name"));

        jedis.del("name"); // 删除某个键
        System.out.println(jedis.get("name"));

        // 设置多个键值对
        jedis.mset("name", "bhz", "age", "27", "qq", "174754613");
        jedis.incr("age"); // 进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-"
                + jedis.get("qq"));

    }


    /**
     * 测试事务
     */
    @Test
    public void testTrans() {
//        long start = System.currentTimeMillis();
//        Transaction tx = jedis.multi();
//        for (int i = 0; i < 10; i++) {
//            tx.set("t" + i, "t" + i);
//        }
//        // System.out.println(tx.get("t1000").get());
//        //        tx.discard(); 取消事务，也是回滚事务
//        List<Object> results = tx.exec();
//        long end = System.currentTimeMillis();
//        System.out.println("Transaction SET: " + ((end - start) / 1000.0)
//                + " seconds");
    }

//
//    // @Test
//    public void testPipelined() {
//        Pipeline pipeline = jedis.pipelined();
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            pipeline.set("p" + i, "p" + i);
//        }
//        // System.out.println(pipeline.get("p1000").get());
//        List<Object> results = pipeline.syncAndReturnAll();
//        long end = System.currentTimeMillis();
//        System.out.println("Pipelined SET: " + ((end - start) / 1000.0)
//                + " seconds");
//    }
//
//    // @Test
//    public void testPipelineTrans() {
//        long start = System.currentTimeMillis();
//        Pipeline pipeline = jedis.pipelined();
//        pipeline.multi();
//        for (int i = 0; i < 100000; i++) {
//            pipeline.set("" + i, "" + i);
//        }
//        pipeline.exec();
//        List<Object> results = pipeline.syncAndReturnAll();
//        long end = System.currentTimeMillis();
//        System.out.println("Pipelined transaction SET: "
//                + ((end - start) / 1000.0) + " seconds");
//    }

}
