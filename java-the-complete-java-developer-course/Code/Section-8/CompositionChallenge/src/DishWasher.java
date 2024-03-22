public class DishWasher extends IOTDevice {
    public DishWasher() { }

    public void doDishes() {
        if (isHasWorkToDo()) {
            System.out.println("Doing the dishes ...");
        }
    }
}
