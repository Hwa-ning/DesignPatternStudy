package Creational;

class SingleTon_A{
    int num;
    static private SingleTon_A instance = null;
    private SingleTon_A(){}
    static SingleTon_A getInstance(){
        if(instance == null) {
            instance = new SingleTon_A();
        }
        return instance;
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum() {
        return num;
    }
}

class SingleTon_B{
    int num;
    static private SingleTon_B instance = new SingleTon_B();
    private SingleTon_B(){}
    static SingleTon_B getInstance(){
        return instance;
    }
    public void setNum(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
public class SingleTon {
    public static void main(String[] args) {
        SingleTon_A a1 = SingleTon_A.getInstance();
        SingleTon_A a2 = SingleTon_A.getInstance();

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        System.out.println(a1.getNum());
        a1.setNum(30);
        System.out.println(a2.getNum());
        a2.setNum(20);
        System.out.println("a1 : " + a1.getNum() + " a2 : " + a2.getNum());

        System.out.println("=========== example B===========");
        SingleTon_B b1 = SingleTon_B.getInstance();
        SingleTon_B b2 = SingleTon_B.getInstance();

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));

        System.out.println(b1.getNum());
        b1.setNum(30);
        System.out.println(b2.getNum());
        b2.setNum(20);
        System.out.println("b1 : " + b1.getNum() + " b2 : " + b2.getNum());
    }
}
