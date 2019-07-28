<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


<!-- 数据列表 -->
<table id="genTable" lay-filter="genFilterTable"></table>


<!-- 字段表单 -->
<div id="formDiv" style="padding:10px;">
    <form class="layui-form" action="" id="fieldForm">
        <div class="layui-form-item">
            <label class="layui-form-label">字段名</label>
            <div class="layui-input-block">
                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入字段名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">字段类型</label>
            <div class="layui-input-block">
                <select name="interest" lay-filter="aihao">
                    <option value="0">主键</option>
                    <option value="1" >用户名</option>
                    <option value="2">整数</option>
                    <option value="3">日期-年月日时分秒</option>
                    <option value="4">日期-年月日</option>
                    <option value="6">邮箱</option>
                    <option value="7">地址</option>
                    <option value="9">手机号</option>
                    <option value="9">身份证号</option>
                    <option value="10">英文字符串</option>
                </select>
            </div>
        </div>

        <%--<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>--%>

    </form>
</div>

<!-- 列表内按钮 -->
<script type="text/html" id="operTool">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../../../static/layui/layui.js" charset="utf-8"></script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table','layer','form'], function(){
        var form = layui.form;

        var table = layui.table;
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句


        //第一个实例
        table.render({
            elem: '#genTable',
            toolbar: 'default',
            height: 500,
            url: '', //数据接口
            page: false, //开启分页
            cols: [[ //表头
                {field: 'name', title: '字段名', width:200, sort: true, fixed: 'left'},
                {field: 'type', title: '字段类型', width:200},
                {field: 'toolbar', title: '操作', width:200, toolbar:'#operTool'}
            ]],
            data : [
                {"name":"","type":""}
            ]
        });

        //监听头工具栏事件
        table.on('toolbar(genFilterTable)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        type: 1,
                        content: $('#formDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                        btn: ['确定', '取消'],
                        area: ['500px', '400px'],
                        yes: function(index, layero){
                            //按钮【确定】的回调
                        }
                    });
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });

        form.render('select');

    });
</script>

</body>



</html>