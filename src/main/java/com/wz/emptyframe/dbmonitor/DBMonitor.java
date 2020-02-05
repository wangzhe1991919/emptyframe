package com.wz.emptyframe.dbmonitor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 */
public class DBMonitor {

    private static Map<String,String> dbTypeMap = new HashMap<String,String>();

    /*static {
        dbTypeMap.put("ORACLE_DRIVER","oracle.jdbc.driver.OracleDriver");
        dbTypeMap.put("ORACLE_SQL","select * from user_tables;");
        dbTypeMap.put("ORACLE_URL","jdbc:oracle:thin:@127.0.0.1:1521:XE");

        dbTypeMap.put("SQLSERVER_DRIVER","com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dbTypeMap.put("SQLSERVER_SQL","select * from sys.tables");
        dbTypeMap.put("SQLSERVER_URL","jdbc:oracle:thin:@127.0.0.1:1521:XE");

    }*/

    public static void main(String[] args) throws SQLException {

        /*DBMonitor dbMonitor = new DBMonitor();

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

        List<CompareTable> compareTables = dbMonitor.compare(resultList);*/


    }

    /**
     * 获取需要对比的数据库信息
     * @param dbBaseInfo
     * @return
     */
    public List<DBMonitorResultSet> getInfos(List<DBBaseInfo> dbBaseInfo) throws SQLException {

        List<DBMonitorResultSet> dbInfo = new ArrayList<DBMonitorResultSet>();

        for (DBBaseInfo info : dbBaseInfo) {
            setResultSet(info,dbInfo);
        }

        return dbInfo;
    }


    public void setResultSet(DBBaseInfo dbBaseInfo, List<DBMonitorResultSet> dbInfo) {
        //数据库查询返回信息
        DBMonitorResultSet dbrs = new DBMonitorResultSet();

        List<String> tableNames = new ArrayList<>();

        Map<String,List<Field>> tableFieldMap = new HashMap<String,List<Field>>();

        // 连接驱动
        //String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DRIVER = "oracle.jdbc.OracleDriver";

        // 连接路径
        //String URL = "jdbc:sqlserver://"+dbBaseInfo.getIp()+":1433;databaseName=" + dbBaseInfo.getDbname();
        String URL = "jdbc:oracle:thin:@"+dbBaseInfo.getIp()+":1521:xe";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, dbBaseInfo.getUsername(), dbBaseInfo.getPassword());
            //sql-server
            //String sql = "select * from sys.tables";

            //oracle
            String sql = "SELECT * FROM DBA_TABLES WHERE OWNER='"+ dbBaseInfo.getDbname()+"';";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //sqlserver
                //String name = rs.getString("name");

                //oracle
                String name = rs.getString("TABLE_NAME");
                if (StringUtils.isNotBlank(name)) {
                    tableNames.add(name);
                }
            }

            for(String table : tableNames) {
                String fieldSql = "SELECT" +
                        " convert(varchar(100),C.NAME) AS field_name," +
                        " convert(varchar(100),T.NAME) AS field_type," +
                        " convert(varchar(100), COLUMNPROPERTY ( C.id, C.NAME, 'PRECISION' )) AS field_length," +
                        " convert(varchar(100),isnull( ETP.VALUE, '' )) AS field_desc" +
                        " FROM" +
                        " syscolumns C" +
                        " INNER JOIN systypes T ON C.xusertype = T.xusertype" +
                        " LEFT JOIN sys.extended_properties ETP ON ETP.major_id = c.id " +
                        " AND ETP.minor_id = C.colid " +
                        " AND ETP.NAME = 'MS_Description'" +
                        " LEFT JOIN syscomments CM ON C.cdefault = CM.id " +
                        " WHERE" +
                        " C.id = object_id ( '"+table+"' )";

                PreparedStatement fieldPs = conn.prepareStatement(fieldSql);
                //搜索字段的结果集
                ResultSet fieldRs = fieldPs.executeQuery();
                while (fieldRs.next()) {
                    String fieldName = fieldRs.getString("field_name");
                    String fieldType = fieldRs.getString("field_type");
                    String field_length = fieldRs.getString("field_length");
                    String field_desc = fieldRs.getString("field_desc");

                    List<Field> fieldList = new ArrayList<Field>();
                    Field field = new Field();
                    field.setName(fieldName);
                    field.setType(fieldType);
                    field.setLength(field_length);
                    field.setDesc(field_desc);
                    fieldList.add(field);
                    tableFieldMap.put(table,fieldList);
                }
                fieldRs.close();
                fieldPs.close();
            }
            dbrs.setIp_dbname(dbBaseInfo.getIp().concat(dbBaseInfo.getDbname()));
            dbrs.setTableList(tableNames);
            dbrs.setTableFields(tableFieldMap);
            dbrs.setIsbasic(dbBaseInfo.getIsbasic());
            dbInfo.add(dbrs);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(rs,ps,conn);
        }
    }


    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     */
    public void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 比对
     * @param resultList
     */
    public  List<CompareTable> compare(List<DBMonitorResultSet> resultList) {
        //基准数据库结果集
        DBMonitorResultSet basicResultSet = resultList.stream().filter(obj -> obj.getIsbasic()).findFirst().get();

        List<CompareTable> list = null;

        for (DBMonitorResultSet drs : resultList) {
            if (!drs.getIp_dbname().equals(basicResultSet.getIp_dbname())) {
                list = compareDetail(basicResultSet,drs);
            }
        }
        return list;
    }

    /**
     * 对比详细数据
     * @param basic
     * @param follow
     */
    public List<CompareTable> compareDetail(DBMonitorResultSet basic,DBMonitorResultSet follow) {
        List<CompareTable> compareTable = new ArrayList<CompareTable>();

        //基准表字段
        List<String> basicTables = basic.getTableList();
        //对比表
        List<String> followTables = follow.getTableList();

        //获取两个结果集中相同的部分
        List<String> sameTable = getSame(basicTables,followTables);
        sameTable.forEach(table -> {
            CompareTable c = new CompareTable();
            c.setName(table);
            c.setStatus(0);
            //对比此表中的字段
            List<Field> basicFields = basic.getTableFields().get(table);
            List<Field> followFields = follow.getTableFields().get(table);
            List<CompareField> compareFieldList = compareFields(basicFields,followFields);
            c.setCompareFieldList(compareFieldList);
            compareTable.add(c);
        });

        DiffList<String> diffList = removeDuplication(basicTables,followTables);
        diffList.getBasicList().forEach(table -> {
            //基准库有的表，而对比库没有(对比库有可能已经删除 delete table)
            CompareTable c = new CompareTable();
            c.setName(table);
            c.setStatus(-1);
            compareTable.add(c);
        });
        diffList.getFollowList().forEach(table -> {
            //对比库有，基本库没有，属于新增（insert）
            CompareTable c = new CompareTable();
            c.setName(table);
            c.setStatus(1);
            compareTable.add(c);
        });

        return compareTable;

    }

    /**
     * 对比表中所有字段的情况
     * @param basic
     * @param follow
     */
    public List<CompareField> compareFields(List<Field> basic,List<Field> follow) {
        List<CompareField> result = new ArrayList<CompareField>();

        List<String> sameNameList = getSameField(basic,follow);
        sameNameList.forEach(name -> {
            //基准表字段信息
            Field basicField = basic.stream().filter(field -> field.getName().equals(name)).findFirst().get();
            //对比表字段信息
            Field followField = follow.stream().filter(field -> field.getName().equals(name)).findFirst().get();

            CompareField compareField = new CompareField();
            compareField.setName(name);
            //设置对比字段类型
            compareField.setBasicType(basicField.getType());
            compareField.setFollowType(followField.getType());
            //设置对比字段长度
            compareField.setBasicLength(basicField.getLength());
            compareField.setFollowLength(followField.getLength());
            //设置对比字段描述
            compareField.setBasicDesc(basicField.getDesc());
            compareField.setFollowDesc(followField.getDesc());
            //如果字段对比中，出现不一样的情况，设置状态位为2【使用枚举类】
            if (!basicField.getType().equals(followField.getType()) || !basicField.getLength().equals(followField.getLength()) ||
                !basicField.getDesc().equals(followField.getDesc())) {
                compareField.setStatus(2);
            } else {
                compareField.setStatus(0);
            }
            result.add(compareField);
        });

        //获取当前表中不同的字段对象
        DiffList<Field> diffList = getDiffField(basic,follow);

        diffList.getBasicList().forEach(field -> {
            //基准库有的表，而对比库没有(对比库有可能已经删除 delete table)
            CompareField c = new CompareField();
            c.setName(field.getName());
            c.setStatus(-1);
            result.add(c);
        });

        diffList.getFollowList().forEach(field -> {
            //基准库有的表，而对比库没有(对比库有可能已经删除 delete table)
            CompareField c = new CompareField();
            c.setName(field.getName());
            c.setStatus(1);
            result.add(c);
        });

        return result;
    }

    /**
     * /获取当前表中不同的字段对象
     * @param basic     基本表的字段
     * @param follow    对比表的字段
     * @return
     */
    private DiffList<Field> getDiffField(List<Field> basic, List<Field> follow) {
        DiffList<Field> diffList = new DiffList<Field>();
        List<Field> sameList = getSameFieldObj(basic,follow);
        //去除相同的就剩不同的了
        basic.removeAll(sameList);
        follow.removeAll(sameList);
        diffList.setList(basic,follow);
        return diffList;
    }


    /**
     * 获取两个集合中Field name（字段名相同的集合）
     * @param basic
     * @param follow
     * @return
     */
    private List<Field> getSameFieldObj(List<Field> basic, List<Field> follow) {
        List<Field> sameList = new ArrayList<Field>();
        basic.forEach(basicField -> {
            follow.forEach(followField -> {
                if (basicField.getName().equals(followField.getName())) {
                    sameList.add(basicField);
                }
            });
        });
        return sameList;
    }

    /**
     * 获取两个集合中Field name（字段名相同的集合）
     * @param basic
     * @param follow
     * @return
     */
    private List<String> getSameField(List<Field> basic, List<Field> follow) {
        List<String> sameList = new ArrayList<String>();
        basic.forEach(basicField -> {
            follow.forEach(followField -> {
                if (basicField.getName().equals(followField.getName())) {
                    sameList.add(basicField.getName());
                }
            });
        });
        return sameList;
    }

    /**
     * 获取两个list集合中重复的数据
     * @param list1
     * @param follow
     * @return
     */
    public List<String> getSame(List<String> list1,List<String> follow) {
        List<String> list = new ArrayList<String>();
        list1.forEach(o -> {follow.forEach(o2 -> {if (o.equals(o2)) {list.add(o);}});});
        return list;
    }


    /**
     * 获取两个list集合中不重复的数据
     * @param basic
     * @param follow
     */
    public DiffList<String> removeDuplication(List<String> basic,List<String> follow) {
        DiffList<String> diffList = new DiffList<String>();
        List<String> sameList = getSame(basic,follow);
        //去除相同的就剩不同的了
        basic.removeAll(sameList);
        follow.removeAll(sameList);
        diffList.setList(basic,follow);
        return diffList;
    }
}
