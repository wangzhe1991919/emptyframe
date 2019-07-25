package com.wz.emptyframe.controller.system;

import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.wz.emptyframe.dbmonitor.*;
import com.wz.emptyframe.query.system.UserQuery;
import com.wz.emptyframe.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2018/12/28
 */
@Controller
@RequestMapping("/system")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object getUserList(UserQuery query) {
        Object data = userService.list();
        //Object data = userMapper.selectList(null);

        Map map = new HashMap();
        map.put("code",0);
        map.put("data",data);
        return map;
    }

    @RequestMapping(value = "/dbmonitor",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object dbmonitor() throws SQLException {
        DBMonitor dbMonitor = new DBMonitor();

        List<DBBaseInfo> dbs = new ArrayList<DBBaseInfo>(){};

        DBBaseInfo db1 = new DBBaseInfo();
        DBBaseInfo db2 = new DBBaseInfo();

        db1.setDbname("DLJC");
        db1.setIp("127.0.0.1");
        db1.setUsername("sa");
        db1.setPassword("root");
        db1.setIsbasic(true);
        dbs.add(db1);

        db2.setDbname("DLYSXY");
        db2.setIp("127.0.0.1");
        db2.setUsername("sa");
        db2.setPassword("root");
        db2.setIsbasic(false);
        dbs.add(db2);


        List<DBMonitorResultSet> resultList = dbMonitor.getInfos(dbs);

        List<CompareTable> compareTables = dbMonitor.compare(resultList);



        String result="【基准表：127.0.0.1_DLJC，对比表：127.0.0.1_DLYSXY】";

        String more = "";
        String less = "";


        String moreField = "";
        String lessField = "";

        String diffField = "";

        for (CompareTable compare : compareTables) {
            if (compare.getStatus() == -1) {
                more += compare.getName() + ",";
            }
            if (compare.getStatus() == 1) {
                less += compare.getName() + ",";
            }
            if (compare.getStatus() == 0) {
                List<CompareField> fieldList = compare.getCompareFieldList();
                for (CompareField cf : fieldList) {
                    if (cf.getStatus() == -1) {
                        moreField += ("[表:"+ compare.getName() + "删除字段：" + cf.getName() + "],");
                    }
                    if (cf.getStatus() == 1) {
                        lessField += ("[表：" + compare.getName() + "新增字段："+cf.getName()+ "],");
                    }
                    if (cf.getStatus() == 2) {
                        diffField += ("{表：" + cf.getName() +"}----->"
                                + "[基准库字段类型："+cf.getBasicType()+"]"
                                + "[对比库字段类型："+cf.getFollowType()+"]"
                                + "[基准库字段长度："+cf.getBasicLength()+"]"
                                + "[对比库字段长度："+cf.getFollowLength()+"]"
                                + "[基准库字段描述："+cf.getBasicDesc()+"]"
                                + "[对比库字段描述："+cf.getFollowDesc()+"]");
                    }
                }
            }
        }
        result = result + "【删除了表："+more+"】【新增了表："+less+"】" + "【删除字段："+moreField+"】" + "【新增字段："+lessField+"】" +
                "【字段不同："+diffField+"】";


        return result;
    }
}
