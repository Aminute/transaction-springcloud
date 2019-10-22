<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}" media="all">
</head>
<body>
<div class="layui-container" style="margin-top: 50px;">

    <div class="layui-container" style="width: 500px;height: 330px;padding-top: 60px;">
        <form class="layui-form" action="/user/save" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">身份证号：</label>
                <div class="layui-inline">
                    <input type="text" name="user_id" lay-verify="username" autocomplete="off" placeholder="请输入身份证号" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户名：</label>
                <div class="layui-inline">
                    <input type="text" name="user_name" lay-verify="username" autocomplete="off" placeholder="请输入用户名" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码：</label>
                <div class="layui-inline">
                    <input type="password" name="user_pwd" lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱：</label>
                <div class="layui-inline">
                    <input type="text" name="user_mail" lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学校：</label>
                <div class="layui-inline">
                    <input type="text" name="user_school" lay-verify="required" placeholder="请输入学校" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专业：</label>
                <div class="layui-inline">
                    <input type="text" name="user_major" lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学号：</label>
                <div class="layui-inline">
                    <input type="text" name="user_sid" lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" style="margin-left: 160px;">提交</button>
            </div>
        </form>
    </div>
</div>
<script th:src="@{/layui/layui.js}" charset="utf-8"></script>
<script>
    layui.use(['form', 'element'], function(){
        var form = layui.form;
        var element = layui.element;

        //自定义验证规则
        form.verify({
            username: function(value){
                if(value.length == 0){
                    return "用户名不能为空";
                }
            },
            password: [/^[A-Za-z0-9]+$/,"密码必须由数字和字母组成"],
            telephone: [/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/,"请输入正确的电话"]
        });

    });
</script>
</body>
</html>