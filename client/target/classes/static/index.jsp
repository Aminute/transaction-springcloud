<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
</head>
<body>
<div class="layui-container" style="width: 700px;height: 600px;margin-top: 0px;padding-top: 60px;">

    <div style="margin-left: 460px; width: 200px;">
        欢迎回来！<a href="/goods/redirect/buy" th:text="${session.user.user_name}"></a><a href="/account/logout">&nbsp;&nbsp;&nbsp;<button class="layui-btn layui-btn-warm layui-btn-radius">退出</button></a>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="order">购买</a>
    </script>
    <script th:src="@{/layui/layui.js}" charset="utf-8"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#test'
                ,url:'/goods/findAll'
                ,title: '商品列表'
                ,cols: [
                    [
                        {field:'goods_id', width:100, title: '编号', sort: true}
                        ,{field:'goods_name', width:150, title: '名称'}
                        ,{field:'goods_price', width:100, title: '价格'}
                        ,{field:'goods_comment', width:100, title: '商品描述'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:120}
                    ]
                ]
                ,page: true
            });
            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'order'){
                    window.location.href="/buy/save/"+data.goods_id;
                }
            });
        });
    </script>

</div>
<script>
    //二级菜单联动
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>