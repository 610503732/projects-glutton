package cn.com.git.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集群服务
 */
public class TestClusterRedis {

    private static Set<HostAndPort> jedisClusterNodes;
    private static JedisCluster jc;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.254.11", 7001));
        jc = new JedisCluster(jedisClusterNodes);


    }

    @Test
    public void testString() {
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println(value);
    }



}
