<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
    <script type="text/javascript" th:src="@{/layui/layui.js}"></script>
    <script type="text/javascript" th:src="@{/js/jquery-3.3.1.min.js}"></script>
    <script type="text/javascript">
        $(function () {
            $("#goods_manage").click(function(){
                $("iframe").attr("src","/goods/redirect/goods_manage");
            });
            $("#goods_add").click(function(){
                $("iframe").attr("src","/goods/redirect/goods_add");
            });
            $("#order_handler").click(function(){
                $("iframe").attr("src","/goods/redirect/buy_handler");
            });
            $("#user_manage").click(function(){
                $("iframe").attr("src","/goods/redirect/user_manage");
            });
            $("#user_add").click(function(){
                $("iframe").attr("src","/goods/redirect/user_add");
            });
        })
    </script>
</head>

<div class="layui-layout layui-layout-admin">
    <body class="layui-layout-body">
    <!-- 顶部菜单开始 -->
    <div class="layui-header">
        <div class="layui-logo">二手交易管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img th:src="@{/images/img.jpeg}" class="layui-nav-img">
                    <span th:text="${session.admin.admin_name}"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/account/logout">退出系统</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <!-- 顶部菜单结束 -->

    <!-- 左侧菜单开始 -->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a id="goods_manage" href="javascript:void(0)">查询商品</a></dd>
                        <dd><a id="goods_add" href="javascript:void(0)">添加商品</a></dd>
                        <dd><a id="order_handler" href="javascript:void(0)">处理订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a id="user_manage" href="javascript:void(0)">查询用户</a></dd>
                        <dd><a id="user_add" href="javascript:void(0)">添加用户</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 -->

    <!-- 主体开始 -->
    <div class="layui-body">

        <iframe src="/goods/redirect/goods_manage" style="width: 100%;height: 100%;border: 0px"></iframe>

    </div>
    <!-- 主体结束 -->

    <!-- 底部开始 -->
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © hai
    </div>
    <!-- 底部结束 -->
</div>
<script>
    //二级菜单联动
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>