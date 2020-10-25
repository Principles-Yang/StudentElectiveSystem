package yyh.student.dao;

import yyh.student.model.Student;


public interface StudentDao {
    public Student login(Student user);

    public void changePass(Student user);

    public void getStuCourse(String username);

    public void getAvaCourse(String username);

    public void chooseCourse(String username, String c_id);

    public void deleteCourse(String username, String c_id);

    public void userPrintResult(String username);

}