public class MealOrder {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public MealOrder() {
        this.burger = new Burger("regular", 2.99);
        this.drink = new Drink("coke", 'S');
        this.sideItem = new SideItem("fries", 3.99);
    }

    public void addTopping(String toppingName) {
        this.burger.addTopping(toppingName);
    }

    public void setDrinkSize(char drinkSize) {
        drink.setSize(drinkSize);
    }

    public double getTotalPrice() {
        return this.burger.getPrice()
                + this.drink.getPrice()
                + this.sideItem.getPrice();
    }

    @Override
    public String toString() {
        return "MealOrder{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", sideItem=" + sideItem +
                ", price=" + getTotalPrice() +"}";
    }
}
