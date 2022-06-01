package Behavioral;

interface MoveStrategy{
    public void move();
}

class RailLoadStrategy implements MoveStrategy{
    public void move(){
        System.out.println("기찻길로 이동");
    }
}

class CarLoadStrategy implements MoveStrategy{
    public void move(){
        System.out.println("차도로 이동");
    }
}
// ======================================================

class Movable{
    private MoveStrategy moveStrategy;

    public void move(){
        moveStrategy.move();
    }
    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }
}

class Train extends Movable{
}
class Car extends Movable{
}

public class Strategy {
    public static void main(String[] args) {
        Movable train = new Train();
        Movable car = new Car();

        train.setMoveStrategy(new RailLoadStrategy());
        train.move();

        car.setMoveStrategy(new CarLoadStrategy());
        car.move();

        // === 이 후 전략을 변경

        car.setMoveStrategy(new RailLoadStrategy());
        car.move();
    }
}
