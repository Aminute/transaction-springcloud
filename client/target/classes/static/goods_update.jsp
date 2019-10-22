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
        <form class="layui-form" action="/goods/update" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户编号：</label>
                <div class="layui-inline">
                    <input type="text" name="user_id" th:value="${goods.user_id}" lay-verify="required" readonly autocomplete="off" placeholder="请输入用户ID" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品编号：</label>
                <div class="layui-inline">
                    <input type="text" name="goods_id" th:value="${goods.goods_id}" lay-verify="required" placeholder="请输入商品id" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品名称：</label>
                <div class="layui-inline">
                    <input type="text" name="goods_name" th:value="${goods.goods_name}" lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品价格：</label>
                <div class="layui-inline">
                    <input type="text" name="goods_price" th:value="${goods.goods_price}" lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品描述：</label>
                <div class="layui-inline">
                    <input type="text" name="goods_comment" th:value="${goods.goods_comment}" lay-verify="required" placeholder="请输入商品描述" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="demo2" style="margin-left: 160px;">提交</button>
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
            price: [/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/, "请输入正确的价格"]
        });

    });
</script>
</body>
</html>