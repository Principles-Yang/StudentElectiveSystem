package yyh.student.dao.Impl;

import yyh.student.dao.TeacherDao;
import yyh.student.model.Course;
import yyh.student.model.Student;
import yyh.student.model.Teacher;
import yyh.student.utils.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl implements TeacherDao {
    //教师登录
    @Override
    public Teacher login(Teacher teacher) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= DaoUtil.getCon();
            String sql="select * from teacher where t_name=? and t_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getT_name());
            ps.setString(2, teacher.getT_password());
            rs=ps.executeQuery();
            Teacher  teachers=null;
            if(rs.next()){
                teachers=new Teacher();
                teachers.setT_name(rs.getString("t_name"));
                teachers.setT_password(rs.getString("t_password"));
                return teachers;

            }
            else
                return null;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    //查看全部课程
    @Override
    public void selectAllUser(String t_name) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql ="select * from student ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getString("sno"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));

                System.out.println(student);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


        //修改课程
    @Override
    public void updateCourse(Course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql="update course set c_pos=?,c_time=? where c_no=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_pos());
            ps.setString(2, course.getC_time());
            ps.setString(3, course.getC_no());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程修改成功");
            }
            else{
                System.out.println("输入课号有误，课程修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

        //查看全部课程
    @Override
    public void selectAllCourse(String t_name) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql ="select * from course ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            Course course=null;
            while(rs.next()){
                course = new Course();
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


        public void tPrintResult(String t_name){

            // TODO Auto-generated method stub
            Connection con = null;
            PreparedStatement ps= null;
            ResultSet rs=null;
            try {
                con=DaoUtil.getCon();
                String sql ="select * from teacher where t_name=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, t_name);
                rs=ps.executeQuery();
                while (rs.next()) {
                    String sno=rs.getString("sno");
                    String name=rs.getString("name");
                    String sex=rs.getString("sex");
                    String teachClass=rs.getString("teachClass");
                    String kno=rs.getString("kno");
                    Teacher teacher =new Teacher(sno,name,sex,teachClass,kno);
                    System.out.println(teacher);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



    }


}
