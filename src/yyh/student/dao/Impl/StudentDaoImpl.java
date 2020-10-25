package yyh.student.dao.Impl;


import yyh.student.dao.StudentDao;
import yyh.student.model.Course;
import yyh.student.model.Student;
import yyh.student.utils.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student login(Student user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql="select * from student where username=? and password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();
            Student users=null;
            if(rs.next()){
                users=new Student();
                //从数据库中获取值设置到实体类的setter方法中
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                return users;
            }else{
                return null;
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changePass(Student user) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql = "update student set password=? where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            int a =ps.executeUpdate();

        }    catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void chooseCourse(String username,String c_id) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql ="insert into stu_course (username,c_id) values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("选课成功");
            }
            else{
                System.out.println("输入ID有误，选课失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除选课
    @Override
    public void deleteCourse(String username,String c_id) {
        // TODO Auto-generated method stub

        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= DaoUtil.getCon();
            String sql="delete from stu_course where username=? and c_id=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查询已选课程
    @Override
    public void getStuCourse(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();

            String sql ="select * from course where c_id in (select c_id from stu_course where username=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            while (rs.next()) {
                String id =rs.getString("c_id");
                String c_name =rs.getString("c_name");
                String teacher =rs.getString("teacher");
                String c_no =rs.getString("c_no");
                String c_pos =rs.getString("c_pos");
                String c_time =rs.getString("c_time");

                Course course = new Course(c_name, teacher, c_no, c_pos,c_time);
                System.out.println(course);



            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public StudentDaoImpl() {
        super();
    }

    //查询可选课程
    @Override
    public void getAvaCourse(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql = "select * from course where c_id not in (select c_id from stu_course where username=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setTeacher(rs.getString("teacher"));

                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getTeacher());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //打印选课结果
    public void userPrintResult(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();

//            String sql ="SELECT s.username,  c.c_id, s.sno, s.name, s.sex , c.c_no,  c.c_name, c.teacher, c.c_pos, c.c_time \n" +
//                    "FROM course c\n" +
//                    "LEFT JOIN  stu_course sc ON   sc.c_id= c.c_id\n" +
//                    "LEFT JOIN  student s ON s.username=sc.username=?\n" +
//                    "WHERE s.username='yyh'";

            String sql ="select * from student where username=?";

            ps=con.prepareStatement(sql);
            ps.setString(1, username);
//            ps.setString(2, username);
            rs=ps.executeQuery();

            while (rs.next()) {
//                String id =rs.getString("c_id");
//                String c_name =rs.getString("c_name");
//                String teacher =rs.getString("teacher");
//                String c_no =rs.getString("c_no");
//                String c_pos =rs.getString("c_pos");
//                String c_time =rs.getString("c_time");
//
//                Course course = new Course(c_name, teacher, c_no, c_pos,c_time);
//                course.setC_id(rs.getString("c_id"));
//                course.setC_name(rs.getString("c_name"));
//                course.setTeacher(rs.getString("teacher"));
//                course.setC_no(rs.getString("c_no"));
//                course.setC_pos(rs.getString("c_pos"));
//                course.setC_time(rs.getString("c_time"));

                Student student = new Student();
                student.setSno(rs.getString("sno"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));

                System.out.println(student);
//                System.out.println(course);
//                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getTeacher()+" "+course.getC_no()+" "+course.getC_pos()+" "+course.getC_time());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
