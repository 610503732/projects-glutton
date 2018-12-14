package cn.com.git.study.mq.rabbit.work;

import cn.com.git.study.mq.rabbit.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Procudt {

    //队列名称
    private static final String QUEUE_NAME = "mq_work_queue" ;

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection() ;

        //从连接中获取一个通道
        Channel channel = connection.createChannel() ;

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;

        for(int i=0;i<50;i++){
            //待发送的消息
            String msg = "hello work "+ i +"!" ;

            //发送消息
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

            System.out.println("--- 消息已经发送 [WQ] -- ：" + msg);
        }



        //关闭连接
        channel.close();
        connection.close();

    }

}
