package cn.com.git.redis;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;


public class TestSingleRedis {

    private static Jedis jedis;
    private static ShardedJedis shard;
    private static ShardedJedisPool pool;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // 单个节点
        jedis = new Jedis("192.168.254.11", 6379);

        // 分片
//         List<JedisShardInfo> shards = Arrays.asList(new JedisShardInfo(
//         "192.168.254.11", 6379));
//         shard = new ShardedJedis(shards);
//
//         GenericObjectPoolConfig goConfig = new GenericObjectPoolConfig();
//         goConfig.setMaxTotal(100);
//         goConfig.setMaxIdle(20);
//         goConfig.setMaxWaitMillis(-1);
//         goConfig.setTestOnBorrow(true);
//         pool = new ShardedJedisPool(goConfig, shards);
    }

    @Test
    public void testString() {
        // -----添加数据----------
        jedis.set("name", "bhz");// 向key-->name中放入了value-->xinxin
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

    // @Test
    public void testTrans() {
        long start = System.currentTimeMillis();
        Transaction tx = jedis.multi();
        for (int i = 0; i < 1000; i++) {
            tx.set("t" + i, "t" + i);
        }
        // System.out.println(tx.get("t1000").get());

        List<Object> results = tx.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start) / 1000.0)
                + " seconds");
    }

    // @Test
    public void testPipelined() {
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            pipeline.set("p" + i, "p" + i);
        }
        // System.out.println(pipeline.get("p1000").get());
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined SET: " + ((end - start) / 1000.0)
                + " seconds");
    }

    // @Test
    public void testPipelineTrans() {
        long start = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        for (int i = 0; i < 100000; i++) {
            pipeline.set("" + i, "" + i);
        }
        pipeline.exec();
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined transaction SET: "
                + ((end - start) / 1000.0) + " seconds");
    }

    // @Test
    public void testShard() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String result = shard.set("shard" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("shard SET: " + ((end - start) / 1000.0)
                + " seconds");
    }

    // @Test
    public void testShardpipelined() {
        ShardedJedisPipeline pipeline = shard.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            pipeline.set("sp" + i, "p" + i);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("shardPipelined SET: " + ((end - start) / 1000.0)
                + " seconds");
    }

    // @Test
    public void testShardPool() {
        ShardedJedis sj = pool.getResource();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String result = sj.set("spn" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        pool.returnResource(sj);
        System.out.println("shardPool SET: " + ((end - start) / 1000.0)
                + " seconds");
    }



}
