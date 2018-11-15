<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
<!DOCTYPE html >
<html>
<head>
    <link type="image/x-icon" rel="icon" href="">

    <title>按钮页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- style -->
    <!--<link rel="stylesheet" type="text/css" href="css/styles.css">-->
    <link rel="stylesheet" href="${ctx}/static/theme/layui/css/layui.css" media="all" >
    <%-- <script type="text/javascript" src="${ctx}/a-static/nc-jquery/jquery-1.4.3.js"></script> --%>
</head>
<style type="text/css">
    /** 样式定义在页面渲染前 **/



</style>
<body>

    <div class="layui-fluid">
        <div class="layui-row">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">卡片面板</div>
                    <div class="layui-card-body">
                        卡片式面板面板通常用于非白色背景色的主体内<br>
                        从而映衬出边框投影
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">卡片面板</div>
                    <div class="layui-card-body">
                        卡片式面板面板通常用于非白色背景色的主体内<br>
                        从而映衬出边框投影
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<%-- <script type="text/javascript" src="${ctx}/a-static/nc-jquery/jquery-1.4.3.js"></script> --%>
<script type="text/javascript" src="${ctx}/static/theme/layui/layui.js"></script>
<script type="text/javascript">
    /** js 放在 DOM 加载后执行 **/
</script>
</html>