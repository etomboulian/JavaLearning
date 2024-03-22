public class Main {
    public static void main(String[] args) {
        SmartKitchen kitchen = new SmartKitchen();

        kitchen.addWater();
        kitchen.pourMilk();
        kitchen.loadDishwasher();

        kitchen.doKitchenWork();
    }
}
