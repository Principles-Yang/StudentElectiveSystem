package yyh.student.utils;

import yyh.student.serive.StudentService;

import java.util.Scanner;

/**
 * 学生界面
 * @author yyh
 * @date 2020-10-24
 */
public class StuMenu {
    public static void showMenu(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("      欢迎 "+username+"用户 使用选课系统         ");
        System.out.println("    1.修改学生密码");
        System.out.println("    2.查看已选课程");
        System.out.println("    3.选择可选课程");
        System.out.println("    4.查看可选课程");
        System.out.println("    5.删除已选课程");
        System.out.println("    6.打印选课结果");
        System.out.println("    7.退出选课系统");
        System.out.println("_________________________");
        int a = sc.nextInt();
        switch(a){
            case 1:  StudentService.userChangePassWord(username);
                break;
            case 2:  StudentService.userStuCourse(username);
                break;
            case 3:     StudentService.userChooserCourse(username);
                break;
            case 4:     StudentService.userAvaCourse(username);
                break;
            case 5:     StudentService.userDeleteCourse(username);
                break;
            case 6:     StudentService.userPrintResult(username);
                break;
            case 7:  System.out.println("用户成功退出！");
                System.exit(0);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }


    }

}