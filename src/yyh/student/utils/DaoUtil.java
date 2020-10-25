package yyh.student.utils;

import java.sql.*;

public class DaoUtil {

    private static String driver="org.mariadb.jdbc.Driver";
    private static String url="jdbc:mariadb://localhost:3306/test";
    private static String user="root";
    private static String password="mariadb";

    /**
     * 连接数据库
     * @throws Exception
     */
    public static Connection getCon () throws Exception{
        Class.forName(driver);
        //System.out.println("加载");
        Connection con =DriverManager.getConnection(url, user, password);
        //System.out.println("连接");
        return con;
    }
    /**
     * 关闭数据库
     */
    public static void close(Connection con,PreparedStatement ps,ResultSet rs){
        if(rs!=null){//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){//关闭资源，避免出现异常
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con!=null){//关闭资源，避免出现异常
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
        //检测连接成功与否，经常出现连接失败的问题在于没有正确导入maridb-connect包，请检查Libraries
//        public static void main(String[] args) {
//        try {
//            DaoUtil.getCon();
//            System.out.println("成功");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

}