package yyh.student.model;

public class Teacher extends Person{
    private String teachClass;
    private String t_name;
    private String t_password;
    private String kno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(String classID) {
        this.teachClass = classID;
    }

    public String getT_name() {
        return t_name;
    }
    public void setT_name(String t_name) {
        this.t_name = t_name;
    }
    public String getT_password() {
        return t_password;
    }
    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public Teacher(int id, String sno, String name, String sex, String teachClass) {
        super(id,sno,name,sex);
        this.teachClass = teachClass;
    }

    public Teacher(String sno, String name, String sex,String teachClass,String kno) {
        super(sno,name,sex);
        this.teachClass = teachClass;
        this.kno = kno;
    }

    public Teacher() {
        super();
    }

    @Override
    public String toString() {
        return "教师 ["  + "工号：" + sno + ", 姓名：" + name
                + ", 性别：" + sex +", 所授课程：" + teachClass +", 课程编号：" + kno + "  请牢记课程编号，此为改课依据]";
    }



}