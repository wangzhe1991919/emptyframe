package com.wz.emptyframe;

import com.wz.emptyframe.dao.UserDao;
import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyframeApplicationTests {


    /*@Autowired
    private UserDao userMapper;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;*/

    @Test
    public void contextLoads() {

    }


    @Test
    public void dbmonitor() {

        String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="tiger";

        Statement st = null;
        ResultSet rs = null;
        Connection conn = null;

        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得数据库链接
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            st=conn.createStatement();
            rs=st.executeQuery("select * from user");
            //4.处理数据库的返回结果(使用ResultSet类)
            while(rs.next()){
                System.out.println(rs.getString("user_name")+" "+rs.getString("user_password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    @Test
    public void testOracle()
    {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:XE";
            String user = "system";
            String password = "147";
            // 获取连接
            con = DriverManager.getConnection(url, user, password);

            String sql = "select * from student where name=?";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            pre.setString(1, "刘显安");
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

            while (result.next())
                // 当结果集不为空时
                System.out.println("学号:" + result.getInt("id") + "姓名:"
                        + result.getString("name"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSqlServer() {
        // 连接驱动
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // 连接路径
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=DLJC";
        // 用户名
        String USERNAME = "sa";
        // 密码
        String PASSWORD = "root";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "select * from sys.tables";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("====>" + name);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
