public class Main {

    public static void main(String[] args) {
        MealOrder mealOrder = new MealOrder();
        mealOrder.addTopping("Cheese");
        mealOrder.addTopping("Bacon");
        mealOrder.setDrinkSize('M');
        System.out.println(mealOrder);
    }

}
