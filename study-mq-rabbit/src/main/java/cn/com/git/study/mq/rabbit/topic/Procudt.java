package cn.com.git.study.mq.rabbit.topic;

import cn.com.git.study.mq.rabbit.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Procudt {

    //交换机名称
    private static final String EXCHANGE_NAMG = "mq_exchange_topic" ;

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection() ;

        //从连接中获取一个通道
        Channel channel = connection.createChannel() ;

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAMG,"topic");

        //发送消息
        String msg = "商品 添加 .ee。。。。" ;
        channel.basicPublish(EXCHANGE_NAMG,"sale.aa",null,msg.getBytes());
        System.out.println("--- 消息已经发送 -- ：" + msg);

        //关闭连接
        channel.close();
        connection.close();
    }
}