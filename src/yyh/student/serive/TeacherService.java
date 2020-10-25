package yyh.student.serive;


import yyh.student.dao.Impl.TeacherDaoImpl;
import yyh.student.dao.TeacherDao;
import yyh.student.model.Course;
import yyh.student.model.Teacher;
import yyh.student.utils.TeacherMenu;

import java.util.Scanner;

public class TeacherService {
    static Scanner sc = new Scanner(System.in);
    //教师登录
    public void tLogin(String username,String password){
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        teacher.setT_name(username);
        teacher.setT_password(password);
        dao.login(teacher);
        if(dao.login(teacher)!=null){
            System.out.println("登录成功");
            TeacherMenu.ShowMenu(teacher.getT_name());

        }
        else{
            System.out.println("用户名或密码错误");
        }
    }

    //修改课程
    public static void tUpdateCourse(String t_name){
        TeacherDao dao = new TeacherDaoImpl();
        Course course=new Course();
        System.out.println("请输入要修改的课程编号：");
        course.setC_no(sc.nextLine());
        System.out.println("请输入修改后的上课地点：");
        course.setC_pos(sc.nextLine());
        System.out.println("请输入修改后的上课时间：");
        course.setC_time(sc.nextLine());
        dao.updateCourse(course);
        TeacherMenu.ShowMenu(t_name);
    }

    //查看全部课程
    public static void tAllCourse(String t_name){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("已有课程如下：");
        dao.selectAllCourse(t_name);
        TeacherMenu.ShowMenu(t_name);
    }

    //查看全部学生
    public static void tAllUser(String t_name){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("已有学生信息如下：");
        dao.selectAllUser(t_name);
        TeacherMenu.ShowMenu(t_name);
    }

    //打印自己的课程
    public static void tPrintResult(String t_name) {
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("_________________________");
        System.out.println("您的打印结果为：");
        dao.tPrintResult(t_name);
        TeacherMenu.ShowMenu(t_name);

    }





}
