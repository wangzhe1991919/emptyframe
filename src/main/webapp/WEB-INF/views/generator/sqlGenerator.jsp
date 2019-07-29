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

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>初始化</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">表名</label>
        <div class="layui-input-block">
            <input type="text" id="tableName" name="tableName" lay-verify="title" autocomplete="off" placeholder="表名" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生成条数</label>
        <div class="layui-input-block">
            <input type="text" id="counts" name="counts" lay-verify="title" autocomplete="off" placeholder="生成条数" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">字段类型</label>
        <div class="layui-input-block">
            <select id="dataBaseType" name="dataBaseType" lay-filter="typeFilter">
                <option value="1" selected="">ORACLE</option>
                <option value="2">SQLSERVER</option>
                <option value="3">MYSQL</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="genBtn">生成</button>
        </div>
    </div>
</form>


<!-- 数据列表 -->
<table id="genTable" class="layui-table" lay-filter="genFilterTable"></table>


<!-- 字段表单 -->
<div id="formDiv" style="padding:10px;display: none;">
    <form class="layui-form" action="" id="fieldForm">
        <div class="layui-form-item">
            <label class="layui-form-label">字段名*</label>
            <div class="layui-input-block">
                <input type="text" id="name" name="name" lay-verify="title" autocomplete="off" placeholder="请输入字段名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">字段类型*</label>
            <div class="layui-input-block">
                <select id="type" name="type" lay-filter="typeFilter">
                    <option value="0">主键</option>
                    <option value="1">用户名</option>
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
        <div class="layui-form-item">
            <label class="layui-form-label">长度(可选)</label>
            <div class="layui-input-block">
                <input type="text" id="length" name="length" lay-verify="title" autocomplete="off" placeholder="长度为0则不生成" class="layui-input" value="8">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">默认值(可选)</label>
            <div class="layui-input-block">
                <input type="text" id="value" name="value" lay-verify="title" autocomplete="off" placeholder="请输入默认值" class="layui-input">
            </div>
        </div>
    </form>
</div>

<!-- 列表内按钮 -->
<script type="text/html" id="operTool">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../../../static/layui/layui.js" charset="utf-8"></script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table','layer','form'], function(){
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery
        var layer = layui.layer; //独立版的layer无需执行这一句


        var tableOption = {
            elem: '#genTable',
            toolbar: 'default',
            height: 500,
            url: '', //数据接口
            page: false, //开启分页
            cols: [[ //表头
                {field: 'name', title: '字段名',sort: true, fixed: 'left'},
                {field: 'type', title: '字段类型'},
                {field: 'length', title: '长度'},
                {field: 'value', title: '默认值'},
                {field: 'toolbar', title: '操作', toolbar:'#operTool'}
            ]],
            data : []
        }
        //渲染列表
        table.render(tableOption);

        //监听头工具栏事件
        table.on('toolbar(genFilterTable)', function(obj){
            var data = obj.data;
            switch(obj.event){
                case 'add':
                    layer.open({
                        type: 1,
                        content: $('#formDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                        btn: ['确定', '取消'],
                        area: ['500px', '400px'],
                        offset: 't',
                        yes: function(index, layero){
                            tableOption.data = table.cache.genTable;
                            tableOption.data.push({"name":$("#name").val(),"type":$("#type").val(),"length":$("#length").val(),"value":$("#value").val()});
                            table.reload('genTable',tableOption);
                            layer.close(index);
                        }
                    });
                    break;
            };
        });

        table.on('tool(genFilterTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('确定删除？', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });

        //生成提交
        form.on('submit(genBtn)', function(data){
            var param = data.field;
            param.fields = table.cache.genTable;

            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/generator/genInsertSql',
                data : JSON.stringify(param),
                contentType: "application/json;charset=utf-8",
                dataType: 'json',
                success: function(o) {
                    layer.alert(o.data, {
                        title: '生成的数据'
                    })
                }
            });
            return false;
        });
    });
</script>

</body>



</html>