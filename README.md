# 计G202 2020322092 杨昀昊

*实验三：学生选课系统*
--
## 一、实验目的
 1.初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；<br>
 2.掌握面向对象的类设计方法（属性、方法）；<br>
 3.掌握类的继承用法，通过构造方法实例化对象；<br>
 4.学会使用super()，用于实例化子类；<br>
 5.掌握使用Object根类的toString（）方法,应用在相关对象的信息输出中。<br>

### challenge：
 - [x] 利用数据库完成各类对象的数据存储；
 - [x] 复习和巩固sql语句，如：多表联查、嵌入查询等；
 - [x] 设计一个简易的用户界面；
 - [x] 建立多个账户，如：本次中的2个以上学生、2个以上教师，他们可以独立进入系统，互不干扰。
 - [x] 尝试一位学生选多门课
 - [ ] 尝试一位老师教多门课


## 二、实验内容
#### 逻辑与业务要求:
  说明：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。<br>
  --从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。--
  本实验结果现已变成：每个学生可选多门课程，数据库自增长<br>
  每名教师仅教授一门课程，每门课程的授课教师也仅有一位，*但教师有权查看学生信息，并可以修改上课地点和时间。*

#### 对象:（具体请看设计）
    >人员：编号、姓名、性别
    >教师：编号、姓名、性别、所授课程、课程编号、登录账户、登录密码
    >学生：编号、姓名、性别、所选课程、登录账户、登录密码
    >课程：课程编号、课程名称、上课地点、时间、授课教师、序号

#### 实验要求
- [x] 1.编写上述实体类以及测试主类（注意类之间继承关系的适用）
- [x] 2.在测试主类中，实例化多个类实体，
- [x] 3.模拟学生选课操作、
- [x] 4.打印课程信息（信息包括：编号、课程名称、上课地点、时间、授课教师 等）
- [x] 5.模拟学生退课操作，再打印课程信息。
- [x] 6.编写实验报告。


## 三、实验设计
 #### 如图：
 #### 数据库（建表语句见 四、7）：
 *teacher表* <br>
![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/teachertable.png) <br>
*course表* <br>
![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/coursetable.png) <br>
*student表* <br>
![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/studenttable.png) <br>
*stu_course表* <br>
![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/stu_ctable.png) <br>

 ##### 流程图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/%E6%B5%81%E7%A8%8B%E5%9B%BE.png) <br>

 ##### 包图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/%E5%8C%85%E5%9B%BE.png) <br>

 ##### model包类图（含继承、多态、对象的属性和方法等）
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/model%E5%8C%85.png) <br>


 ##### Dao包所含类图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/Dao%E5%8C%85.png) <br>

 ##### Iml接口实现类图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/%E5%AF%B9%E5%BA%94Dao%E7%9A%84%E6%8E%A5%E5%8F%A3%E6%96%B9%E6%B3%95.png) <br>

 ##### service包类图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/serive%E5%8C%85.png) <br>

 ##### 关键方法tPrintResult的时序图
 ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/tPrintResult%E6%97%B6%E5%BA%8F%E5%9B%BE%E9%83%A8%E5%88%86.png) <br>


## 四、关键代码
1.父类Person：
```Java
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
```
2.子类Teacher、构造方法、super()以及复写toString方法
```Java
public class Teacher extends Person{
    private String teachClass;
    private String t_name;
    private String t_password;
    private String kno;

    public Teacher(String sno, String name, String sex,String teachClass,String kno) {
        super(sno,name,sex);
        this.teachClass = teachClass;
        this.kno = kno;
    }

    @Override
    public String toString() {
        return "教师 ["  + "工号：" + sno + ", 姓名：" + name
                + ", 性别：" + sex +", 所授课程：" + teachClass +", 课程编号：" + kno + "  请牢记课程编号，此为改课依据]";
    }

}
   ```
  3.关键方法tPrintResult（含toString方法的输出）
```Java
 public void tPrintResult(String t_name){

            // TODO Auto-generated method stub
            Connection con = null;
            PreparedStatement ps= null;
            ResultSet rs=null;
            try {
                con=DaoUtil.getCon();
                String sql ="select * from teacher where t_name=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, t_name);
                rs=ps.executeQuery();
                while (rs.next()) {
                    String sno=rs.getString("sno");
                    String name=rs.getString("name");
                    String sex=rs.getString("sex");
                    String teachClass=rs.getString("teachClass");
                    String kno=rs.getString("kno");
                    Teacher teacher =new Teacher(sno,name,sex,teachClass,kno);
                    System.out.println(teacher);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



    }
   ```

  4.嵌入查询
    
 ```Java
     @Override
    public void getStuCourse(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql ="select * from course where c_id in (select c_id from stu_course where username=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            while (rs.next()) {
                String id =rs.getString("c_id");
                String c_name =rs.getString("c_name");
                String teacher =rs.getString("teacher");
                String c_no =rs.getString("c_no");
                String c_pos =rs.getString("c_pos");
                String c_time =rs.getString("c_time");
                Course course = new Course(c_name, teacher, c_no, c_pos,c_time);
                System.out.println(course);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
 ```

 5.修改课程时间和地点的方法
 ```Java
         @Override
    public void updateCourse(Course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=DaoUtil.getCon();
            String sql="update course set c_pos=?,c_time=? where c_no=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_pos());
            ps.setString(2, course.getC_time());
            ps.setString(3, course.getC_no());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程修改成功");
            }
            else{
                System.out.println("输入课号有误，课程修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
 ```

  6.多表联查（左嵌入）
 ```sql
      SELECT s.username,  c.c_id, s.sno, s.name, s.sex , c.c_no,  c.c_name, c.teacher, c.c_pos, c.c_time FROM course c
        LEFT JOIN  stu_course sc ON   sc.c_id= c.c_id
        LEFT JOIN  student s ON s.username=sc.username
        WHERE s.username='yyh';
 ```

 
   7.建库sql语句

##### course表
 ```sql
      CREATE TABLE `course` (
	`c_id` INT(11) NOT NULL,
	`c_name` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`c_no` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`c_pos` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`c_time` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`teacher` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`c_id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

 ```

  ##### student表
 ```sql
     CREATE TABLE `student` (
	`username` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`id` INT(11) NOT NULL,
	`sno` INT(20) NULL DEFAULT NULL,
	`sex` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`name` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;


 ```

  ##### stu_course表
 ```sql
    CREATE TABLE `stu_course` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(25) NOT NULL COLLATE 'utf8_general_ci',
	`c_id` INT(11) NOT NULL,
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=9
;


 ```
 ##### teacher表
 ```sql
 CREATE TABLE `teacher` (
	`t_name` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`t_password` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`id` INT(11) NOT NULL,
	`sno` INT(10) NULL DEFAULT NULL,
	`name` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`sex` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`teachClass` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`kno` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

 ```

## 五、系统运行截图

  #### 以学生身份进入
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/stuStart.gif) <br>

  ##### 选课
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/selectclass.gif) <br>
  
  ##### 退课
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/exitclass.gif) <br>


  #### 以教师身份进入
  ![]( https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/teachlogin.gif) <br>

  ##### 教师基础功能
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/basefun.gif) <br>
 
  ##### 变更课程部分信息
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/changeclass.gif) <br>

  ##### 以”修仙者“学生身份进入，看到课程已经变更时间和地点
  ![](https://github.com/Principles-Yang/StudentElectiveSystem/blob/master/pic/changeresult.gif) <br>
    
  
## 七、感想与体会
   >1.本次未按照软件开发流程进行，编写过程中异常困难，困难在于总有新想法加入，每次更改都是牵一发而动全身。<br>
   >2.学习并巩固了java知识点，如：封装、继承、多态等。 <br>
   >3.学习并巩固了sql语句。<br>
   >4.碰到困难多查字典、多上网浏览找解决方法。 <br>
   >5.下次一定要优先划定功能，做好系统需求分析，这次java实验占用了很多很多高数作业的时间（*难过(；′⌒`)*）。*都是自己一会儿一个想法，导致总是编写不完2333*<br>
