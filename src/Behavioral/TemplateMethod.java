package Behavioral;

abstract class Parent{
    abstract void hook(); // 공통적으로 사용되어야할 메소드를 추상 메소드로 빼내어 분리

    public void method(){
        m1();
        hook(); // 추상 메소드, 구현체마다 다르게 작성될 내용
        m2();
    }

    public void m1(){
        System.out.println("공통 코드 1, m1() ");
    }

    public void m2(){
        System.out.println("공통 코드 2, m2() ");
    }
}

class Child_A extends Parent{
    public void hook(){
        System.out.println("Child_A에서 구현되어야할 부분");
    }
}

class Child_B extends Parent{
    public void hook(){
        System.out.println("Child_B에서 구현되어야할 부분");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Parent child_a = new Child_A();
        Parent child_b = new Child_B();

        child_a.method();
        System.out.println("==========================");
        child_b.method();
    }
}
