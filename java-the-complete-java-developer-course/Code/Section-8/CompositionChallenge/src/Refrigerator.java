public class Refrigerator extends IOTDevice {

    public Refrigerator() { }

    public void orderFood() {
        if (isHasWorkToDo()) {
            System.out.println("Ordering food ...");
        }
    }
}
