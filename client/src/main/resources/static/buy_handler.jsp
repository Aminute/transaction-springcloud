<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-container" style="margin-top: 50px;width: 750px;width: 1070px">

    <table class="layui-hide" id="test" style="width: 300px" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="send">已派送</a>
    </script>
    <script th:src="@{/layui/layui.js}" charset="utf-8"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test'
                ,url:'/buy/findAllState'
                ,title: '订单列表'
                ,cols: [
                    [
                        {field:'id', width:80, title: '编号', sort: true}
                        , {
                        field: 'name', width: 160, title: '商品', templet: function (data) {
                                return data.goods.goods_name
                            }
                        }
                        , {
                        field: 'price', width: 80, title: '价格', templet: function (data) {
                                return data.goods.goods_price
                            }
                        }
                        ,{field:'user_name', width:80, title: '用户',templet:function(data){
                                return data.user.user_name
                            }
                        }
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:90}
                ]
                ]
                ,page: true
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'send'){
                    window.location.href="/buy/updateState/"+data.id+"/1";
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