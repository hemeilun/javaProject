package work1;

public class Student extends Person{

    public Student(){
        super();
    }

    public Student(String name,int age){
        super(name,age);
    }

    public void print(){
        System.out.println("name："+name);
        System.out.println("age："+age);
    }
}
