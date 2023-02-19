// package Lab5;

public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setCarInfo(60, "High", "Disel");
        c1.showCarInfo();
        c1.move();
        c1.showCarInfo();
        c1.move();
        c1.showCarInfo();
    }
}
