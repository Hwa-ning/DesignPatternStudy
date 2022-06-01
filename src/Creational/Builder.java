package Creational;

class Person {
    private String name;
    private String address;
    private int age;
    private int salary;
    public Person(PersonBuilder personBuilder){
        this.name = personBuilder.name;
        this.address = personBuilder.address;
        this.age = personBuilder.age;
        this.salary = personBuilder.salary;
    }
    public String getName(){
        return name;
    }
    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static class PersonBuilder{
        private String name;
        private String address="버들1길 130"; // Default Value
        private int age;
        private int salary = 0; // Default Value

        PersonBuilder(String name, int age){
            // 필수 입력값은 Builder를 생성할때 선언하도록 하여 필수값은 꼭 선언될 수 있도록
            this.name = name;
            this.age = age;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Person p1 = new Person.PersonBuilder("오정환",26)
                .setAddress("대구 동호로 132")
                .setSalary(9999)
                .build();
        System.out.println(p1.toString());

        String s1 = new String();

        Person p2 = new Person.PersonBuilder("화니",26).build();
        System.out.println(p2.toString());

        Person p3 = new Person.PersonBuilder("정환",26).setAddress("동호로").build();
        System.out.println(p3.toString());

        p1.setAddress("거제대로 37");
        System.out.println(p1.toString());

        // Person.PersonBuilder personBuilder = new Person.PersonBuilder("dd",11);
    }
}
