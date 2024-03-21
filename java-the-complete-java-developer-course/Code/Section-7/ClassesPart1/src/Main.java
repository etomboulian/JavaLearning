public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Corolla");
        car1.setDoors(4);
        car1.setColor("Pink");
        car1.setConvertible(true);

        Car car2 = new Car("Mazda", "6", "Black", 4, false);

        car1.describeCar();
        car2.describeCar();
    }
}
