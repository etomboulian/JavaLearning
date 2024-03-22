public class CoffeeMaker extends IOTDevice {
    public CoffeeMaker() { }

    public void brewCoffee() {
        if (isHasWorkToDo()) {
            System.out.println("Brewing coffee ...");
        }
    }
}
