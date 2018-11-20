<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common.taglib.jspf"%>
<!DOCTYPE html >
<html>
<head>
    <link type="image/x-icon" rel="icon" href="">

    <title>应用默认首页</title>

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
<body>
    <div class="layui-layout layui-layout-admin layui-bg-black">
        <!-- 顶部 -->
        <div class="layui-header">
            <!-- logo -->
            <div class="layui-logo">layui 后台布局</div>

            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;" title="侧边伸缩" id="LAY_menu_toggle" class="layui-icon layui-icon-shrink-right"></a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;" layadmin-event="refresh" title="清除缓存">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="">
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;"><i class="layui-icon layui-icon-notice"></i><cite>系统公告</cite></a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;"><i class="layui-icon layui-icon-password"></i><cite>锁屏</cite></a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;">
                        <img src="static/theme/image/face.jpg" class="layui-circle" width="35" height="35">
                        <cite>老坛酸菜</cite>
                    </a>
                    <dl class="layui-nav-child" lay-unselect="" >
                        <dd ><a href="javascript:;" data-url="page/user/userInfo.html"><i class="layui-icon layui-icon-username" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd>
                        <dd><a href="javascript:;" data-url="page/user/changePwd.html"><i class="layui-icon layui-icon-password" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd>
                        <dd><a href="javascript:;" class="changeSkin"><i class="layui-icon layui-icon-theme"></i><cite>更换主题</cite></a></dd>
                        <dd><a href="page/login/login.html" class="signOut"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
                    </dl>
                </li>
            </ul>


        </div>
        <!-- 左侧导航 -->
        <div class="layui-side">
            <div class=" layui-side-scroll">
                <div class="layadmin-user-photo" lay-href="home/console.html">
                    <a class="img" title="我的头像" ><img src="${ctx}/static/theme/image/face.jpg"></a>
                    <p>你好！<span >用户XXX</span>, 欢迎登录</p>
                </div>
                <div id="LAY_nav_menu" class="cursor-pointer">
                    <%--<ul class="layui-nav layui-nav-tree">--%>
                        <%--<li class="layui-nav-item">--%>
                            <%--<a data-url="page/main.html" data-id="10000">--%>
                                <%--<i class="layui-icon" data-icon=""></i>--%>
                                <%--<cite>后台首页</cite>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="layui-nav-item layui-this">--%>
                            <%--<a data-url="page/news/newsList.html" data-id="20000">--%>
                                <%--<i class="seraph icon-text" data-icon="icon-text">--%>
                                <%--</i><cite>文章列表</cite>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="layui-nav-item">--%>
                            <%--<a data-url="page/img/images.html" data-id="30000">--%>
                                <%--<i class="layui-icon" data-icon="">--%>
                                <%--</i><cite>图片管理</cite>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="layui-nav-item">--%>
                            <%--<a data-id="40000">--%>
                                <%--<i class="layui-icon" data-icon=""></i>--%>
                                <%--<cite>其他页面</cite>--%>
                                <%--<span class="layui-nav-more"></span>--%>
                            <%--</a>--%>
                            <%--<dl class="layui-nav-child">--%>
                                <%--<dd>--%>
                                    <%--<a data-url="page/404.html"  data-id="40100">--%>
                                        <%--<i class="layui-icon" data-icon=""></i>--%>
                                        <%--<cite>404页面</cite>--%>
                                    <%--</a>--%>
                                <%--</dd>--%>
                                <%--<dd>--%>
                                    <%--<a data-url="page/login/login.html" data-id="40200" data-target="_blank">--%>
                                        <%--<i class="layui-icon" data-icon=""></i>--%>
                                        <%--<cite>登录</cite>--%>
                                    <%--</a>--%>
                                <%--</dd>--%>
                            <%--</dl>--%>
                        <%--</li>--%>
                    <%--</ul>--%>

                </div>
            </div>
        </div>
        <!-- 右侧内容 一个大的 tab -->
        <div class="layui-body overflow-hidden">
            <div class="layui-tab layui-tab-brief" lay-filter="bodyTab">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li class="layui-this" lay-id="10000"><i class="layui-icon layui-icon-home"></i> <cite>主页</cite></li>
                </ul>
                <ul class="layui-nav layadmin-tab-ctrls">
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-down"></i> 页面操作</a>
                        <dl class="layui-nav-child" id="LAY_tab_ctrls">
                            <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon layui-icon-refresh"></i> 刷新当前</a></dd>
                            <dd><a href="javascript:;" class="closePageOther"><i class="layui-icon layui-icon-circle-dot"></i> 关闭其他</a></dd>
                            <dd><a href="javascript:;" class="closePageAll"><i class="layui-icon layui-icon-close-fill"></i> 关闭全部</a></dd>
                        </dl>
                    </li>
                </ul>
                <div class="layui-tab-content" id="LAY_tab_content">
                    <div class="layui-tab-item layui-show">
                        <iframe src="${ctx}/welcome/index" frameborder="0"></iframe>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部 -->
        <div class="layui-footer text-center">
            <p>copyright @2017</p>
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
    }).use(['tab','nav','form','element','layer','jquery'],function(){

        $ = layui.jquery,
            tab = layui.tab({
                container : "#LAY_app_tabsheader",
                tabFilter:"bodyTab"
            }),
            nav = layui.nav({
                container : "#LAY_nav_menu",
                url:"static/json/navs.json"
            }),
        element = layui.element,
        layer = layui.layer;


        /**
         * 菜单点击事件
         */
        $("#LAY_nav_menu").on("click",".layui-nav .layui-nav-item a",function(){

            var $item = $(this) ,
                _menu = {};

            //如果不存在子级
            if($item.siblings().length == 0){
                _menu.id = $item.data("id");
                _menu.url = $item.data("url");
                _menu.target = $item.data("target");
                _menu.icon = $item.find("i").data("icon");
                _menu.title = $item.find("cite").text();

                //访问远程地址
                if(_menu.target == "_blank"){
                    window.location.href = _menu.url;
                    return ;
                }
                //添加标签
                tab.show(_menu);

            }
            $item.parent("li").siblings().removeClass("layui-nav-itemed");
        })
            //添加菜单的二次监听
            //如果当前菜单隐藏，则更换成显示菜单的布局
        $("#LAY_nav_menu").on("click",".layui-nav .layui-nav-item a",function(){
            if($(".layui-layout-admin").hasClass("layadmin-layout-mune-hide")) $(".layui-layout-admin").toggleClass("layadmin-layout-mune-hide");
        })

        /**
         * 菜单分页操作
         */
            //关闭所有分页
        $("#LAY_tab_ctrls .closePageAll").click(function () {
            tab.deleteAll();
        });
            //关闭其他
        $("#LAY_tab_ctrls .closePageOther").click(function () {
            tab.deleteOth();
        });
            //刷新当前
        $("#LAY_tab_ctrls .refresh").on("click",function(){

            if($(this).hasClass("refreshThis")){
                $(this).removeClass("refreshThis");
                $("#LAY_tab_content .layui-tab-item.layui-show iframe")[0].contentWindow.location.reload(true);
                setTimeout(function(){
                    $("#LAY_tab_ctrls .refresh").addClass("refreshThis");
                },2000)
            }else{
                layer.msg("操作过于频繁！");
            }
        })

        /**
         * 菜单伸缩
         */
        $("#LAY_menu_toggle").click(function(){
            $(".layui-layout-admin").toggleClass("layadmin-layout-mune-hide");
        })

    });
</script>
</html>