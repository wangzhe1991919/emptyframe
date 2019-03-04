package com.wz.emptyframe.controller.system;

import com.wz.emptyframe.dbmonitor.CompareTable;
import com.wz.emptyframe.dbmonitor.DBBaseInfo;
import com.wz.emptyframe.dbmonitor.DBMonitor;
import com.wz.emptyframe.dbmonitor.DBMonitorResultSet;
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
        return compareTables;
    }
}
