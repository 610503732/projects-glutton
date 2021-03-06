package cn.com.git.study.mq.rabbit.work;

import cn.com.git.study.mq.rabbit.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息消费者
 */
public class ConsumerB {

    //队列名称
    private static final String QUEUE_NAME = "mq_work_queue" ;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        ConsumerB.newConsumer();
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
                System.out.println("[B] msg:" + msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[B] done");
                }
            }
        };

        //是否自动回复
        //回复后消息将清除
        boolean autoAck = true ;
        //监听队列
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);

    }


}
