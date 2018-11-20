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
    <link rel="stylesheet" href="${ctx}/static/theme/css/common.css" media="all" />
    <link rel="stylesheet" href="${ctx}/static/theme/css/overall.css" media="all" />
</head>
<style type="text/css">
    /** 样式定义在页面渲染前 **/



</style>
<body>

    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮主题</div>
                    <div class="layui-card-body">
                        <button class="layui-btn layui-btn-primary">原始按钮</button>
                        <button class="layui-btn">默认按钮</button>
                        <button class="layui-btn layui-btn-normal">百搭按钮</button>
                        <button class="layui-btn layui-btn-warm">暖色按钮</button>
                        <button class="layui-btn layui-btn-danger">警告按钮</button>
                        <button class="layui-btn layui-btn-disabled">禁用按钮</button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮圆角</div>
                    <div class="layui-card-body">
                        <button class="layui-btn layui-btn-radius layui-btn-primary">原始按钮</button>
                        <button class="layui-btn layui-btn-radius">默认按钮</button>
                        <button class="layui-btn layui-btn-radius layui-btn-normal">百搭按钮</button>
                        <button class="layui-btn layui-btn-radius layui-btn-warm">暖色按钮</button>
                        <button class="layui-btn layui-btn-radius layui-btn-danger">警告按钮</button>
                        <button class="layui-btn layui-btn-radius layui-btn-disabled">禁用按钮</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮尺寸</div>
                    <div class="layui-card-body">
                        <button class="layui-btn  layui-btn-lg layui-btn-primary">大型按钮</button>
                        <button class="layui-btn layui-btn-primary">默认按钮</button>
                        <button class="layui-btn layui-btn-sm layui-btn-primary">小型按钮</button>
                        <button class="layui-btn layui-btn-xs layui-btn-primary ">迷你按钮</button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮图标</div>
                    <div class="layui-card-body">
                        <button class="layui-btn">
                            <i class="layui-icon">&#xe608;</i> 默认按钮
                        </button>
                        <button class="layui-btn">
                            <i class="layui-icon">&#x1002;</i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮组合</div>
                    <div class="layui-card-body">
                        <div class="layui-btn-group">
                            <button class="layui-btn">增加</button>
                            <button class="layui-btn">编辑</button>
                            <button class="layui-btn">删除</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">按钮铺满</div>
                    <div class="layui-card-body">
                        <button class="layui-btn layui-btn-fluid">流体按钮（最大化适应）</button>
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