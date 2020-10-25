package yyh.student.model;

public class Student extends Person  {

    private String username;
    private String password;
    private String className;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String classID) {
        this.className = classID;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Student(int id, String sno, String name, String sex, String className) {
        super(id,sno,name,sex);
        this.className = className;
    }

    public Student(String sno, String name, String sex) {
        super(sno,name,sex);
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "学生 [" + "学 号：" + sno + ", 姓名：" + name
                + ", 性别：" + sex + "]";
    }




}
