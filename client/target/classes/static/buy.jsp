<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
</head>
<body>
<div class="layui-container" style="width: 960px;height: 600px;margin-top: 0px;padding-top: 60px;">

    <div style="margin-left: 460px; width: 300px;">
        <a href="/goods/redirect/index">首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;欢迎回来！<a href="/account/redirect/buy" th:text="${session.user.user_name}"></a><a href="/account/logout">&nbsp;&nbsp;&nbsp;<button class="layui-btn layui-btn-warm layui-btn-radius">退出</button></a>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>
    <script th:src="@{/layui/layui.js}" charset="utf-8"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test'
                ,url:'/buy/findAllById'
                ,title: '订单列表'
                ,cols: [
                    [
                       {
                        field: 'goods_name', width: 200, title: '商品名称', templet: function (data) {
                                return data.goods.goods_name
                            }
                        }
                        , {
                        field: 'goods_price', width: 100, title: '商品价格', templet: function (data) {
                                return data.goods_price
                            }
                        }
                        ,{field:'trans_date',width:300,  title: '下单时间'}
                    ]
                ]
                ,page: true
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'buy'){
                    window.location.href="/buy/save/"+data.id;
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