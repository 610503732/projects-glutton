package cn.com.git.study.mq.rabbit;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 获取 RabbitMQ 连接的工具类
 */
public class ConnectionUtils {


    /**
     * 获取 MQ 连接
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException, TimeoutException {

        //获取连接工厂
        ConnectionFactory factory = new ConnectionFactory() ;

        //设置服务地址
        factory.setHost("127.0.0.1");

        //AMQP 5672
        factory.setPort(5672);

        //vhost
        factory.setVirtualHost("001_vhost");

        //用户名
        factory.setUsername("mq_zzf");

        //密码
        factory.setPassword("123456");

        return factory.newConnection();

    }

}
