package yyh.student.model;

public class Person {
    int id;
    String sno;// 学号或工号
    String name;// 姓名
    String sex;// 性别

    public Person(){

    }

    public Person(String sno,String name,String sex){
        this.sno = sno;
        this.name = name;
        this.sex = sex;
    }

    public Person(int id,String sno,String name,String sex){
        this.id = id;
        this.sno = sno;
        this.name = name;
        this.sex = sex;
    }
}
