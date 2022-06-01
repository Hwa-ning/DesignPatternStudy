# Strategy 전략 패턴

객체의 function 중 실행이 가능한 행위 각각에 대해 전략 클래스를 생성</br>
유사한 행위들을 캡슐화하는 인터페이스를 정의</br>
객체의 행위를 변경(전략을 변경) 하는 경우 직접 코드를 수정하지 않고 전략을 바꿔주어 유연하게 확장하는 방법</br>

→ 객체가 할 수 있는 행위들을 각각의 전략으로 만들고 행위의 수정이 필요한 경우에는 이 전략들을 바꿔주어 동작을 수정하는 패턴

## 기존의 문제점

```Java
interface Movable{
	public void move()
}
```
Movable Interface 선언
```Java
class Train implements Movable{
	public void move(){
		System.out.println("기찻길을 통해 이동");
	}
}
```

```Java
class Car implements Movable{
	public void move(){
		System.out.println("차도를 통해 이동");
	}
}
```

```Java
	public static void main(String[] args){
		Movable train = new Train();
		Movable car = new Car();
		
		train.move();
		car.move();
	}
```
위와같이 Movable이라는 Interface를 구현해서 Car와 Train이라는 Class를 구현하게 된다면 차의 move() 메소드에 변화가 필요한 경우 Car의 move()메소드를 직접 수정해야 한다.

이는 SOLID 원칙 중 OCP(확장에는 열려있고 수정에는 닫혀 있어야함)에 위배된다.

시스템이 확장되는 경우 모든 Movable을 구현하는 객체들에 대해 move()메소드를 직접 수정해야할 뿐만 아니라, 같은 메소드를 여러 클래스에서 똑같이 정의하므로 메소드의 중복이 발생한다.

이를 해결하기 위해 전략 패턴을 적용하여 해결한다.</br></br>

## 전략 패턴 적용
### 1. 전략 정의
```Java
interface MoveStrategy{
    public void move();
}
```

```Java
class RailLoadStrategy implements MoveStrategy{
    public void move(){
        System.out.println("기찻길로 이동");
    }
}
```
```Java
class RailLoadStrategy implements MoveStrategy{
    public void move(){
        System.out.println("기찻길로 이동");
    }
}
```

### 2. 전략을 적용할 클래스 정의
```Java
class Movable{
    private MoveStrategy moveStrategy;

    public void move(){
        moveStrategy.move();
    }
    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }
}
```
```Java
class Train extends Movable{

}
```
```Java
class Car extends Movable{

}
```
### 3.메인 클래스 (코드 사용 예시)
```Java
    public static void main(String[] args) {
        Movable train = new Train();
        Movable car = new Car();

        train.setMoveStrategy(new RailLoadStrategy());
        train.move();

        car.setMoveStrategy(new CarLoadStrategy());
        car.move();

        // === Car의 move 전략을 변경

        car.setMoveStrategy(new RailLoadStrategy());
        car.move();
    }
```
![스크린샷 2022-06-01 오후 2 42 12](https://user-images.githubusercontent.com/69469529/171335667-82af9862-9dda-40cb-b24f-d645d131c8e5.png)

## 실코드 적용
.