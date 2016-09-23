package Emp;

import java.util.TreeSet;


 
class Tree_set 
{
    public static void main(String[] args)  
    {
        TreeSet ts = new TreeSet();
 
        ts.add(new Student("aaa",1));
        ts.add(new Student("ccc",2));
        ts.add(new Student("bbb",2));
        ts.add(new Student("aaa",1));
        ts.add(new Student("lisixx",29));
        ts.add(new Student("lisi4",14));
        //ts.add(new Student(39));
        ts.add(new Student("lisi7",27));
        ts.add(new Student("bbb",2));
 
 
 
        System.out.println(ts);
    }
}
 
//同姓名同年龄的学生视为同一个学生。按照学生的年龄排序。
class Student implements Comparable
{
    private int age;
    private String name;
    Student(String name,int age)
    {
        this.age = age;
        this.name = name;
    }
 
    public int compareTo(Object obj)
    {
        
        Student stu = (Student)obj;
        
        int num = new Integer(this.age).compareTo(new Integer(stu.age));
 
        return num==0?this.name.compareTo(stu.name):num;
 
        /*
        if(this.age>stu.age)
            return 1;
        if(this.age==stu.age)
            return this.name.compareTo(stu.name);
        return -1;
        */
        /**/
        
    }
    
 
    public int getAge()
    {
        return age;
    }
    public String toString()
    {
        return name+"::"+age;
    }
}

 

