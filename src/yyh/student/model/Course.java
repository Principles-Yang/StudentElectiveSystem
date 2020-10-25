package yyh.student.model;

public class Course {
    private String c_id;
    private String c_name;
    private String teacher;
    private String c_no;
    private String c_pos;
    private String c_time;

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getC_time() {
        return c_time;
    }

    public String getC_pos() {
        return c_pos;
    }

    public void setC_pos(String c_pos) {
        this.c_pos = c_pos;
    }

    public String getC_no() {
        return c_no;
    }

    public String getC_id() {
        return c_id;
    }
    public void setC_id(String i) {
        this.c_id = i;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setC_no(String c_no) {
        this.c_no= c_no;
    }

    public Course(String c_name, String teacher, String c_no, String c_pos, String c_time) {
        this.c_name = c_name;
        this.teacher = teacher;
        this.c_no= c_no;
        this.c_pos = c_pos;
        this.c_time = c_time;
    }
    public Course(){

    }

    @Override
    public String toString() {
        return "课程 [课程名："+  c_name + ", 授课教师：" + teacher + ", 课程号：" + c_no
                + ", 地点：" +  c_pos + ", 时间：" +  c_time + "]";
    }
}
