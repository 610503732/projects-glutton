<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common.taglib.jspf"%>
<!DOCTYPE html >
<html>
<head>
    <link type="image/x-icon" rel="icon" href="">

    <title>登录页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- style -->
    <!--<link rel="stylesheet" type="text/css" href="css/styles.css">-->
    <%-- <script type="text/javascript" src="${ctx}/a-static/nc-jquery/jquery-1.4.3.js"></script> --%>
    <link rel="stylesheet" href="static/theme/layui/css/layui.css" media="all" >
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="static/theme/css/layout.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/common.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/overall.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/theme.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/transition.css" media="all" />
</head>
<style type="text/css">
    /** 样式定义在页面渲染前 **/
</style>
<body class="layadmin-bk-dark-blue">

    <div class="layadmin-user-login-box">
        <div class="layadmin-user-login-body">
            <div class="layadmin-user-login-header text-center">
                <h2>LAYUI ADMIN</h2>
            </div>
            <div class="layadmin-user-login-body">
                <div class="layui-form-item">
                    <label class=" layui-icon layui-icon-username layadmin-login-icon" for="LAY-user-login-username"></label>
                    <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input"/>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password layadmin-login-icon" for="LAY-user-login-password"></label>
                    <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
                </div>
            </div>
        </div>
    </div>

</body>
<script type="text/javascript" src="static/theme/layui/layui.js"></script>
<script type="text/javascript">

    var $,tab,nav,element,layer,appIndex;

    appIndex = (function(window,document){

        var options = {} ;

        function extendOptions (param){
            $.extend(options,param);
        }

        var initRender = function(){

        };

        var initAction = function(){


        };

        //对外暴露的方法
        return {
            init:function(param){
                extendOptions(param);
                initRender();
                initAction();
            }
        } ;

    })(window,document);

    layui.config({
        base : "static/theme/js/"
    }).use(['form','element','layer','jquery'],function(){

        $ = layui.jquery,
        element = layui.element,
        layer = layui.layer;



    });
</script>
</html>