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

<table id="genTable" lay-filter="genFilter"></table>

<script type="text/html" id="operTool">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../../../static/layui/layui.js" charset="utf-8"></script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;

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

    });
</script>

</body>
</html>