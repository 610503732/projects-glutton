//package cn.com.git.common.utils;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 请求（request）
// * 参考网址：http://www.cnblogs.com/xumengxuan/p/3761314.html
// * @author git
// *
// */
//public class RequestUtils {
//
//    /*           请求头常量                             */
//    /**
//     * Accept:表示浏览器支持的 MIME类型<br/>
//     * Text：用于标准化地表示的文本信息，文本消息可以是多种字符集和或者多种格式的;<br/>
//     * text/html表示 html文档  ;<br/>
//     * Application用于传输应用程序数据或者二进制数据;<br/>
//     * application/xhtml+xml表示 xhtml文档;<br/>
//     * application/xml表示 xml文档;
//     */
//    public static final String ACCEPT           = "Accept";
//
//    /**
//     * Accept-Encoding:浏览器支持的压缩类型
//     */
//    public static final String ACCEPT_ENCODING  = "Accept-Encoding";
//
//    /**
//     * Accept-Language:浏览器支持的语言类型
//     */
//    public static final String ACCEPT_LANGUAGE  = "Accept-Language";
//
//    /**
//     * Connection：当浏览器与服务器通信时对于长连接如何进行处理（close/keep-alive）
//     */
//    public static final String CONNECTION       = "Connection";
//
//    /**
//     * Content-Length:表示请求消息正文的长度
//     */
//    public static final String CONTENT_LENGTH   = "Content-Length";
//
//    /**
//     * Content-Type:数据的类型
//     */
//    public static final String CONTENT_TYPE     = "Content-Type";
//
//    /**
//     * Cookie：向服务器返回cookie，这些cookie是之前服务器发给浏览器的
//     */
//    public static final String COOKIE           = "Cookie";
//
//    /**
//     * Host:请求的服务器URL
//     */
//    public static final String HOST             = "Host";
//
//    /**
//     * Origin:主要是用来说明最初请求是从哪里发起的
//     */
//    public static final String ORIGIN           = "Origin";
//
//    /**
//     * Referer：包含一个URL，用户从该URL代表的页面出发访问当前请求的页面
//     */
//    public static final String REFERER          = "Referer";
//
//    /**
//     * User-Agent:用户客户端的一些必要信息（操作系统、浏览器及版本、浏览器渲染引擎）
//     */
//    public static final String USER_AGENT       = "User-Agent";
//
//    /**
//     * X-Requested-With:表示是ajax请求
//     */
//    public static final String X_REQUESTED_WITH = "X-Requested-With";
//
//    /**
//     * 打印请求信息
//     * @param request
//     */
//    public static void info(HttpServletRequest request) {
//
//        /*得到指定的head头的值*/
//        System.out.println("-------------------打印请求信息（request）-----------------------------");
//
//        //表示浏览器支持的 MIME类型
//        System.out.println("[浏览器支持的 MIME类型] Accept:" + request.getHeader("Accept"));
//        //浏览器支持的压缩类型
//        System.out.println("[浏览器支持的压缩类型] Accept-Encoding:" + request.getHeader("Accept-Encoding"));
//        //浏览器支持的语言类型
//        System.out.println("[浏览器支持的语言类型] Accept-Language:" + request.getHeader("Accept-Language"));
//        //当浏览器与服务器通信时对于长连接如何进行处理：close/keep-alive
//        System.out.println("[长连接如何进行处理] Connection:" + request.getHeader("Connection"));
//        //表示请求消息正文的长度
//        System.out.println("[请求消息正文的长度] Content-Length:" + request.getHeader("Content-Length"));
//        //数据的类型
//        System.out.println("[数据的类型] Content-Type:" + request.getHeader("Content-Type"));
//        //向服务器返回cookie，这些cookie是之前服务器发给浏览器的
//        System.out.println("[向服务器返回cookie] Cookie:" + request.getHeader("Cookie"));
//        //请求的服务器URL
//        System.out.println("[请求的服务器URL] Host:" + request.getHeader("Host"));
//        //主要是用来说明最初请求是从哪里发起的
//        System.out.println("[请求始发地] Origin:" + request.getHeader("Origin"));
//        //包含一个URL，用户从该URL代表的页面出发访问当前请求的页面
//        System.out.println("[发出访问的页面] Referer:" + request.getHeader("Referer"));
//        //用户客户端的一些必要信息
//        System.out.println("[客户端的一些必要信息] User-Agent:" + request.getHeader("User-Agent"));
//        //表示是ajax请求
//        System.out.println("[ajax请求标志] X-Requested-With:" + request.getHeader("X-Requested-With"));
//
//    }
//
//    /**
//     * 获取指定请求头信息
//     * @param request
//     * @param headerName
//     * @return
//     */
//    public static String getHeader(HttpServletRequest request, String headerName) {
//
//        return request.getHeader(headerName);
//    }
//
//    /**
//     * 判断是否为ajax请求
//     * @param request
//     * @return
//     */
//    public static boolean isAjax(HttpServletRequest request){
//
//        return getHeader(request, X_REQUESTED_WITH)==null?false:true;
//    }
//}
