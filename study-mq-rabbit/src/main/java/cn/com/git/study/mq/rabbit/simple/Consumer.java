package cn.com.git.study.mq.rabbit.simple;

import cn.com.git.study.mq.rabbit.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息消费者
 */
public class Consumer {

    //队列名称
    private static final String QUEUE_NAME = "mq_simple_queue" ;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //老 api
        //Consumer.oldConsumer();
        Consumer.newConsumer();
    }

    /**
     * 老的 API
     * @throws IOException
     * @throws TimeoutException
     */
    public static void oldConsumer() throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection() ;

        //从连接中获取一个通道
        Channel channel = connection.createChannel() ;

        //定义队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer) ;

        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msgString = new String(delivery.getBody()) ;
            System.out.println("[recv] msg:" + msgString);
        }

    }

    /**
     * 新的 API
     * @throws IOException
     * @throws TimeoutException
     */
    public static void newConsumer() throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection() ;

        //从连接中获取一个通道
        Channel channel = connection.createChannel() ;

        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;

        //定义消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String msg = new String(body,"utf-8") ;
                System.out.println("[recv new] msg:" + msg);
            }
        };

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }


}
