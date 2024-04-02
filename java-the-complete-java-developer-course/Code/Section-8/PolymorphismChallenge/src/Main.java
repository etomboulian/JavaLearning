public class Main {
    public static void main(String[] args) {
        Car car = new Car("Test");
        runRace(car);
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
