package yyh.student.dao;

import yyh.student.model.Course;
import yyh.student.model.Teacher;

public interface TeacherDao {
    public Teacher login(Teacher teacher);

    public void selectAllUser(String t_name);
    public void updateCourse(Course course);
    public void tPrintResult(String t_name);
    public void selectAllCourse(String t_name);




}