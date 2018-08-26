package cn.com.git.common.utils;

import java.net.*;
import java.io.*;

public class SocketUtil {
}


/**
 *
 * 功能描述：<br />
 * 客户端SOCKET应用程序与服务器端SOCKET应用程序的流程很相似，最大的差别在于：<br />
 * 1、服务器端SOCKET应用程序主要用于侦听及接收客户端的连接，而客户端的SOCKET 应用程序则用于尝试与服务器端建立连接
 *
 * 2、客户端SOCKET应用程序发送信息指令至服务器端，并接收服务器端所返回的结果；
 * 而服务器端SOCEKT应用程序则处理指令逻辑，并将结果或错误信息发送至客户端
 *
 * 常见的客户端应用有：<br />
 * CHAT客户端，FTP客户端，POP3客户端，SMTP客户端和TELNET客户端<br />
 *
 * 建立客户端SOCKET应用程序的步骤大致如下：
 *
 * 1、建立客户端SOCKET，在建立时需指定欲连接服务器端的主机名称（或IP）与INTERNET 通信端口 <br />
 *
 * 2。发送特定信息或指令至服务器端
 *
 * 3、接收服务器端返回的执行结果或错误信息，并以特定格式显示，例如HTTP通信协议会通过 HTML显示
 *
 * 4、当客户端不需服务器端的处理时，便关闭SOCEKT通信链接
 *
 *
 * @author Administrator
 * @Date Jul 19, 2008
 * @Time 9:53:47 AM
 * @version 1.0
 *
 */
 class simpleClient {

    private static Socket socket;

    public static void main(String[] args) throws Exception {
        String host;
        int port;
        if (args.length < 2) {
            System.out
                    .println("Usage:java simpleClient [remote IP/Host] [port]");
            System.exit(1);
        }
        host = args[0];
        port = Integer.parseInt(args[1]);
        connectServer(host, port);
    }

    /**
     * 功能描述：连接服务器
     *
     * @param host
     *            服务器端的主机名称或者IP地址
     * @param port
     *            服务器端通信端口
     */
    public static void connectServer(String host, int port) {
        try {
            socket = new Socket(InetAddress.getByName(host), port);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            @SuppressWarnings("unused")
            DataOutputStream out = new DataOutputStream(socket
                    .getOutputStream());// 建立通信通道

            byte[] inByte = new byte[1024];
            in.read(inByte);
            String response = new String(inByte, 0, inByte.length);
            System.out.println("Message from server: ");
            System.out.println(response.trim());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 *
 * 功能描述：<br />
 * socket是网络应用程序的核心，在服务器端或客户端网络应用程序中，socket皆为不可缺少的要素
 * 在服务器常见的应用有：FTP服务器，MAIL服务器（SMTP，POP3，IMAP4协议），WEB（HTTP协议）。
 *
 * 建立服务器端SOCKET的应用程序步骤如下：<br />
 *
 * 1、建立服务器端的SOCKET，并且以此侦听客户端的连接请求 <br />
 *
 * 2、当服务器端侦测到来自客户端的连接请求时则接收此请求并建立客户端的SOCKET，该SOCEKT将作为
 * 客户端连接及后续处理发送及接收数据的依据，至此则完成服务器端与客户端的SOCKET通信链接
 *
 * 3、处理来自客户端的信息，一般称为请求，可视为客户端的指令需求。例如HTTP通信协议的URL请求，<br />
 * 或FTP通信协议的FTP命令（如GET，PUT）等;<br />
 *
 * 4、根据客户端传来的请求服务器端需经过程序逻辑处理之后，发送回相对应的招待结果或错误信息至
 * 客户端如HTTP服务器须发送回HTML网页内容，而FTP服务器则发送回FTP指令的结果 <br />
 *
 * 5、当程序完成数据或命令的处理之后，便关闭SOCKET通信链接
 *
 * @author Administrator
 * @Date Jul 19, 2008
 * @Time 9:45:54 AM
 * @version 1.0
 */
 class simpleServer {

    private static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        int port;

        if (args.length == 0) {
            System.out.println("Usage:java simpleServer [port]");
            System.exit(1);
        }
        port = Integer.parseInt(args[0]);
        startServer(port);
    }

    /**
     * 功能描述：启动服务器
     *
     * @param port
     *            服务器端口
     * @throws Exception
     */
    public static void startServer(int port) throws Exception {
        try {
            serverSocket = new ServerSocket(port);
            Thread thread = new Thread(new ListenClient(serverSocket));
            thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/**
 *
 * 功能描述：监听程序
 *
 * @author FangHewei
 * @Date Jul 19, 2008
 * @Time 9:57:53 AM
 * @version 1.0
 *
 */
class ListenClient implements Runnable {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    DataInputStream in;
    DataOutputStream out;

    public ListenClient(ServerSocket serverSocket) throws Exception {
        this.serverSocket = serverSocket;
    }

    @SuppressWarnings("static-access")
    public void run() {
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connection from "
                        + clientSocket.getInetAddress().getHostAddress());
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                String lineSep = System.getProperty("line.separator");// 行分隔符，即回车换行
                @SuppressWarnings("unused")
                InetAddress addr = serverSocket.getInetAddress().getLocalHost();

                String outData = "Server Information: " + lineSep
                        + "  Local Host: "
                        + serverSocket.getInetAddress().getLocalHost()
                        + lineSep + " port  :" + serverSocket.getLocalPort();
                byte[] outByte = outData.getBytes();
                out.write(outByte, 0, outByte.length);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
};