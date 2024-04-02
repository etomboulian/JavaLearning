public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void startEngine() {
        System.out.println("Car -> startEngine");
    }

    public void drive() {
        System.out.println("Car -> drive");
    }

    protected void runEngine() {
        System.out.println("Car -> runEngine");
    }
}
