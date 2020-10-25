package yyh.student.utils;

import yyh.student.serive.TeacherService;

import java.util.Scanner;

/**
 * 教师界面
 *
 */
public class TeacherMenu {
    public static void ShowMenu(String  t_name){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("      欢迎 "+t_name+"老师 使用选课系统         ");
        System.out.println("    1.课程修改");
        System.out.println("    2.查看所有选课");
        System.out.println("    3.查看所有学生情况");
        System.out.println("    4.打印自己所授课程");
        System.out.println("    5.退出系统");
        System.out.println("_________________________");
        int a =sc.nextInt();
        switch(a){
            case 1:
                TeacherService.tUpdateCourse(t_name);
                break;
            case 2:
                TeacherService.tAllCourse(t_name);
                break;
            case 3:
                TeacherService.tAllUser(t_name);
                break;
            case 4:
                TeacherService.tPrintResult(t_name);
                break;
            case 5:
                System.out.println("用户成功退出！");
                System.exit(0);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }
    }


}