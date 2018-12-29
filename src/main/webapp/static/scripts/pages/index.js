/**
 * index.jsp 使用的js
 */


layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#demo'
        ,url: common.url.getData
        ,toolbar: '#toolbarDemo'
        ,title: '用户数据表'
        ,height: 'full-140' //高度最大化减去差值
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
            ,{field:'name', title:'用户名', width:120}
            ,{field:'email', title:'邮箱', width:150,
                templet: function(res){
                    return '<em>'+ res.email +'</em>'
                }}
            ,{field:'age', title:'年龄', width:80, sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(demo)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;
        };
    });

    //监听行工具事件
    table.on('tool(demo)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.prompt({
                formType: 2
                ,value: data.email
            }, function(value, index){
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});