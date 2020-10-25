package yyh.student.serive;

import yyh.student.dao.Impl.StudentDaoImpl;
import yyh.student.dao.StudentDao;
import yyh.student.model.Student;
import yyh.student.utils.StuMenu;

import java.util.Scanner;

public class StudentService {
    static Scanner sc = new Scanner(System.in);



    public void userLogin(String username,String password){
        StudentDao dao = new StudentDaoImpl();
        Student user =new Student();
        user.setUsername(username);
        user.setPassword(password);
        dao.login(user);
        if(dao.login(user)!=null){
            System.out.println("登录成功");
            StuMenu.showMenu(username);
        }
        else{
            System.out.println("用户名或密码错误");
        }

    }
    public static void userChangePassWord(String username){
        StudentDao dao = new StudentDaoImpl();
        Student user =new Student();
        System.out.println("请输入新密码");
        String password = sc.nextLine();
        if(password==""||password.length()>10){
            System.exit(0);
        }
        else{
            user.setUsername(username);
            user.setPassword(password);
            dao.changePass(user);
            System.out.println("修改密码成功，新密码为："+password);
            StuMenu.showMenu(username);
        }

    }
    public static void userStuCourse(String username){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("已选课程为：");
        dao.getStuCourse(username);
        StuMenu.showMenu(username);
    }
    public static void userDeleteCourse(String username){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要删除的课程ID为：");
        String c_id=sc.nextLine();
        dao.deleteCourse(username, c_id);
        StuMenu.showMenu(username);

    }
    public static void userAvaCourse(String username){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("可选课程为：");
        dao.getAvaCourse(username);
        StuMenu.showMenu(username);
    }
    public static void userChooserCourse(String username){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要选择的课程ID为：");
        String c_id=sc.nextLine();
        dao.chooseCourse(username, c_id);
        StuMenu.showMenu(username);
    }

    public static void userPrintResult(String username) {
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("打印最终选课结果：");
        dao.userPrintResult(username);
        dao.getStuCourse(username);
        StuMenu.showMenu(username);

    }

}
