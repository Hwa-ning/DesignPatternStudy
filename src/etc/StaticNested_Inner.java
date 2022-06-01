package etc;

class Inner_Outer{
    int num;
    String str;

    void printOut() {
        System.out.println(num);
    }

    void printInner() {
        // System.out.println(innerNum);
        // 외부 클래스에서 내부 클래스로의 접근이 불가능함.
    }
    void createInner(){
        Inner inner = new Inner();
    }
    class Inner{
        public int innerNum;
        String innerStr;
        void printOut(){
            System.out.println(num);
        }
        void printInner() {
            System.out.println(innerNum);
            // 내부 클래스에선 외부 클래스로의 접근이 가능함.
        }
        void createOuter(){
            Inner_Outer Outer = new Inner_Outer();
            Inner inner = new Inner();
        }
    }
}

class StaticNested_Outer{
    int num;
    static String str;

    void printOut() {
        System.out.println(num);
    }

    void printInner() {
        // System.out.println(innerNum);
        // 외부 클래스에서 내부 클래스로의 접근이 불가능함.
    }
    static class Inner{
        public int innerNum;
        String innerStr;
        void printOut(){
            // System.out.println(num);
            // 내부 클래스에서 외부 클래스로의 접근이 불가능함.
        }
        void printStrOut(){
            System.out.println(str);
            // static이 붙은 경우 외부 클래스로의 접근이 가능함. 메소드도 동일함.
        }
        void printInner(){
            System.out.println(innerNum);
        }
        // 내부 클래스에선 외부 클래스로의 접근이 가능함.
    }
}
public class StaticNested_Inner {
    public static void main(String[] args) {
        Inner_Outer innerClass = new Inner_Outer();
        // StaticNested_Outer.Inner static_inner = StaticNested_Outer.new Inner();
    }
}
