<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-container" style="margin-top: 50px;width: 1000px;">

    <table class="layui-hide" id="test" style="width: 300px" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script th:src="@{/layui/layui.js}" charset="utf-8"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test'
                ,url:'/user/findAll'
                ,title: '用户列表'
                ,cols: [
                    [
                        {field:'user_id', width:70, title: '身份证号', sort: true}
                        ,{field:'user_name', width:100, title: '用户名'}
                        ,{field:'user_pwd', width:100, title: '密码'}
                        ,{field:'user_mail', width:100, title: '邮箱'}
                        ,{field:'user_school', width:70, title: '学校'}
                        ,{field:'user_major', width:160, title: '专业'}
                        ,{field:'user_sid', width:220, title: '学号'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:80}
                ]
                ]
                ,page: true
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('确定要删除吗？', function(index){
                        window.location.href="/user/deleteById/"+data.user_id;
                        layer.close(index);
                    });
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