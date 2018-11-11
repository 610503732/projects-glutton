<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
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
    <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/common.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/special.css" media="all" />
    <link rel="stylesheet" href="static/theme/css/transition.css" media="all" />
    <%--<link rel="stylesheet" href="static/theme/css/main.css" media="all" />--%>
</head>
<style type="text/css">
    /** 样式定义在页面渲染前 **/
</style>
<body>
<div class="layadmin-box layadmin-body">

    <div class="layui-layout layui-layout-admin">
        <!-- 顶部 -->
        <div class="layadmin-header-box layui-header layadmin-header-body">
            <a href="#" class="layadmin-logo text-center">LAYUI 后台管理</a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:;" class="layadmin-menu-toggle text-center float-left iconfont icon-menu1"></a>
            <!-- 头部搜索框 -->
            <div class="layui-form layadmin-header-search float-left ">
                <select name="modules" lay-verify="required" lay-search="" >
                    <option value="">直接选择或搜索选择</option>
                    <option value="1">layer</option>
                    <option value="2">form</option>
                    <option value="3">layim</option>
                </select>
                <i class="layui-icon">&#xe615;</i>
            </div>

            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav layui-layout-right layadmin-nav layadmin-header-menu">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"  data-url="page/user/changePwd.html"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>设置</cite></a>
                </li>
                <li class="layui-nav-item">
                    <a href="page/login/login.html" ><i class="iconfont icon-loginout"></i> 退出</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="iconfont icon-lock1"></i><cite>锁屏</cite></a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="static/theme/image/face.jpg" class="layui-circle" width="35" height="35">
                        <cite>请叫我马哥</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="page/user/userInfo.html"><i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i><cite>个人资料</cite></a></dd>
                        <dd><a href="javascript:;" data-url="page/user/changePwd.html"><i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i><cite>修改密码</cite></a></dd>
                        <dd><a href="javascript:;" class="changeSkin"><i class="iconfont icon-huanfu"></i><cite>更换皮肤</cite></a></dd>
                        <dd><a href="page/login/login.html" class="signOut"><i class="iconfont icon-loginout"></i><cite>退出</cite></a></dd>
                    </dl>
                </li>
            </ul>

        </div>
        <!-- 左侧导航 -->
        <div class="layadmin-side-left-box layui-side layui-bg-black layadmin-side-left-body ">
            <div class=" layui-side-scroll">
                <div class="layadmin-user-photo" lay-href="home/console.html">
                    <a class="img" title="我的头像" ><img src="${ctx}/static/theme/image/face.jpg"></a>
                    <p>你好！<span >用户XXX</span>, 欢迎登录</p>
                </div>
                <div class="layadmin-nav-bar"></div>
            </div>
        </div>
        <!-- 右侧内容 -->
        <div class="layadmin-side-right-box layui-body layui-form layadmin-side-right-body overflow-hidden">
            <div class="layui-tab layadmin-tab layadmin-container marg0" lay-filter="bodyTab" id="layadmin-container">
                <ul class="layui-tab-title layadmin-tab-pages" id="tab-pages">
                    <li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>后台首页</cite></li>
                </ul>
                <ul class="layui-nav layadmin-tab-ctrls">
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                            <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
                            <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
                        </dl>
                    </li>
                </ul>
                <div class="layui-tab-content layadmin-tab-content ">
                    <div class="layui-tab-item layui-show">
                        <iframe src="${ctx}/welcome/index"></iframe>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部 -->
        <div class="layadmin-footer-box layui-footer text-center">
            <p>copyright @2017</p>
        </div>
    </div>

</div>

</body>
<script type="text/javascript" src="static/theme/layui/layui.js"></script>
<script type="text/javascript">

    var $,tab,element,layer,appIndex;

    appIndex = (function(window,document){

        var options = {} ;

        function extendOptions (param){
            $.extend(options,param);
        }

        var initRender = function(){
            //渲染左侧菜单
            tab.render();
        };

        var initAction = function(){
            //退出
            $(".signOut").click(function(){
                window.sessionStorage.removeItem("menu");
                menu = [];
                window.sessionStorage.removeItem("curmenu");
            })

            //隐藏左侧导航
            $(".layadmin-menu-toggle").click(function(){
                $(".layui-layout-admin").toggleClass("layadmin-menu-toggle-show");
                //渲染顶部窗口
                tab.tabMove();
            })


            // 添加新窗口
            $("body").on("click",".layui-nav .layui-nav-item a",function(){
                //如果不存在子级
                if($(this).siblings().length == 0){
                    tab.tabAdd($(this));
                    $('body').removeClass('site-mobile');  //移动端点击菜单关闭菜单层
                }
                $(this).parent("li").siblings().removeClass("layui-nav-itemed");
            })



            //刷新当前
            $(".refresh").on("click",function(){  //此处添加禁止连续点击刷新一是为了降低服务器压力，另外一个就是为了防止超快点击造成chrome本身的一些js文件的报错(不过貌似这个问题还是存在，不过概率小了很多)
                if($(this).hasClass("refreshThis")){
                    $(this).removeClass("refreshThis");
                    $(".layadmin-tab-content .layui-tab-item.layui-show").find("iframe")[0].contentWindow.location.reload(true);
                    setTimeout(function(){
                        $(".refresh").addClass("refreshThis");
                    },2000)
                }else{
                    layer.msg("您点击的速度超过了服务器的响应速度，还是等两秒再刷新吧！");
                }
            })

            //关闭其他
            $(".closePageOther").on("click",function(){
                if($("#tab-pages li").length>2 && $("#tab-pages li.layui-this cite").text()!="后台首页"){
                    var menu = JSON.parse(window.sessionStorage.getItem("menu"));
                    $("#tab-pages li").each(function(){
                        if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                            element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                            //此处将当前窗口重新获取放入session，避免一个个删除来回循环造成的不必要工作量
                            for(var i=0;i<menu.length;i++){
                                if($("#tab-pages li.layui-this cite").text() == menu[i].title){
                                    menu.splice(0,menu.length,menu[i]);
                                    window.sessionStorage.setItem("menu",JSON.stringify(menu));
                                }
                            }
                        }
                    })
                }else if($("#tab-pages li.layui-this cite").text()=="后台首页" && $("#tab-pages li").length>1){
                    $("#tab-pages li").each(function(){
                        if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                            element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                            window.sessionStorage.removeItem("menu");
                            menu = [];
                            window.sessionStorage.removeItem("curmenu");
                        }
                    })
                }else{
                    layer.msg("没有可以关闭的窗口了@_@");
                }
                //渲染顶部窗口
                tab.tabMove();
            })
            //关闭全部
            $(".closePageAll").on("click",function(){
                if($("#tab-pages li").length > 1){
                    $("#tab-pages li").each(function(){
                        if($(this).attr("lay-id") != ''){
                            element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                            window.sessionStorage.removeItem("menu");
                            menu = [];
                            window.sessionStorage.removeItem("curmenu");
                        }
                    })
                }else{
                    layer.msg("没有可以关闭的窗口了@_@");
                }
                //渲染顶部窗口
                tab.tabMove();
            })


            $(document).on('keydown', function() {
                if(event.keyCode == 13) {
                    $("#unlock").click();
                }
            });

            //刷新后还原打开的窗口
            if(window.sessionStorage.getItem("menu") != null){
                menu = JSON.parse(window.sessionStorage.getItem("menu"));
                curmenu = window.sessionStorage.getItem("curmenu");
                var openTitle = '';
                for(var i=0;i<menu.length;i++){
                    openTitle = '';
                    if(menu[i].icon){
                        if(menu[i].icon.split("-")[0] == 'icon'){
                            openTitle += '<i class="iconfont '+menu[i].icon+'"></i>';
                        }else{
                            openTitle += '<i class="layui-icon">'+menu[i].icon+'</i>';
                        }
                    }
                    openTitle += '<cite>'+menu[i].title+'</cite>';
                    openTitle += '<i class="layui-icon layui-unselect layui-tab-close" data-id="'+menu[i].layId+'">&#x1006;</i>';
                    element.tabAdd("bodyTab",{
                        title : openTitle,
                        content :"<iframe src='"+menu[i].href+"' data-id='"+menu[i].layId+"'></frame>",
                        id : menu[i].layId
                    })
                    //定位到刷新前的窗口
                    if(curmenu != "undefined"){
                        if(curmenu == '' || curmenu == "null"){  //定位到后台首页
                            element.tabChange("bodyTab",'');
                        }else if(JSON.parse(curmenu).title == menu[i].title){  //定位到刷新前的页面
                            element.tabChange("bodyTab",menu[i].layId);
                        }
                    }else{
                        element.tabChange("bodyTab",menu[menu.length-1].layId);
                    }
                }
                //渲染顶部窗口
                tab.tabMove();
            }

        };

        /**
         * 通过json字符串，解析菜单html
         * @param strData
         * @returns {string}
         */
        var parseNavBar = function (strData){
            var data;
            if(typeof(strData) == "string"){
                var data = JSON.parse(strData); //部分用户解析出来的是字符串，转换一下
            }else{
                data = strData;
            }
            var ulHtml = '<ul class="layui-nav layui-nav-tree">';
            for(var i=0;i<data.length;i++){
                if(data[i].spread){
                    ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
                }else{
                    ulHtml += '<li class="layui-nav-item">';
                }
                if(data[i].children != undefined && data[i].children.length > 0){
                    ulHtml += '<a href="javascript:;">';
                    if(data[i].icon != undefined && data[i].icon != ''){
                        if(data[i].icon.indexOf("icon-") != -1){
                            ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                        }else{
                            ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                        }
                    }
                    ulHtml += '<cite>'+data[i].title+'</cite>';
                    ulHtml += '<span class="layui-nav-more"></span>';
                    ulHtml += '</a>';
                    ulHtml += '<dl class="layui-nav-child">';
                    for(var j=0;j<data[i].children.length;j++){
                        if(data[i].children[j].target == "_blank"){
                            ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'" target="'+data[i].children[j].target+'">';
                        }else{
                            ulHtml += '<dd><a href="javascript:;" data-url="'+data[i].children[j].href+'">';
                        }
                        if(data[i].children[j].icon != undefined && data[i].children[j].icon != ''){
                            if(data[i].children[j].icon.indexOf("icon-") != -1){
                                ulHtml += '<i class="iconfont '+data[i].children[j].icon+'" data-icon="'+data[i].children[j].icon+'"></i>';
                            }else{
                                ulHtml += '<i class="layui-icon" data-icon="'+data[i].children[j].icon+'">'+data[i].children[j].icon+'</i>';
                            }
                        }
                        ulHtml += '<cite>'+data[i].children[j].title+'</cite></a></dd>';
                    }
                    ulHtml += "</dl>";
                }else{
                    if(data[i].target == "_blank"){
                        ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'" target="'+data[i].target+'">';
                    }else{
                        ulHtml += '<a href="javascript:;" data-url="'+data[i].href+'">';
                    }
                    if(data[i].icon != undefined && data[i].icon != ''){
                        if(data[i].icon.indexOf("icon-") != -1){
                            ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                        }else{
                            ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                        }
                    }
                    ulHtml += '<cite>'+data[i].title+'</cite></a>';
                }
                ulHtml += '</li>';
            }
            ulHtml += '</ul>';
            return ulHtml;
        };

        //对外暴露的方法
        return {
            init:function(param){
                extendOptions(param);
                initRender();
                initAction();
            },
            parseNavBar:parseNavBar
        } ;

    })(window,document);

    layui.config({
        base : "static/theme/js/"
    }).use(['tab','form','element','layer','jquery'],function(){

        $ = layui.jquery;
        tab = layui.tab({
            openTabNum : "50",  //最大可打开窗口数量
            url : "static/json/navs.json", //获取菜单json地址
            parseNavBar:appIndex.parseNavBar,
            navBar:".layadmin-nav-bar"
        });
        element = layui.element;
        layer = layui.layer;

        //模块加载后
        appIndex.init();

    });
</script>
</html>