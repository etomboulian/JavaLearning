public class Burger {
    private String burgerType;
    private double basePrice;
    private Topping topping1;
    private Topping topping2;
    private Topping topping3;

    public Burger(String burgerType, double basePrice) {
        this.burgerType = burgerType;
        this.basePrice = basePrice;
    }

    public void addTopping(String toppingName) {
        Topping topping = Topping.getToppingByName(toppingName);

        if (topping1 == null && topping != null) {
            topping1 = topping;
        } else if (topping2 == null && topping != null) {
            topping2 = topping;
        } else if (topping3 == null && topping != null) {
            topping3 = topping;
        } else {
            System.out.println("Unable to add more toppings");
        }
    }

    public double getPrice() {
        return basePrice
                + ((topping1 != null) ? topping1.getPrice() : 0)
                + (((topping2 != null))? topping2.getPrice() : 0)
                + (((topping3 != null)) ? topping3.getPrice() : 0);
    }

    @Override
    public String toString() {
        return "Burger{" +
                "burgerType='" + burgerType + '\'' +
                ", basePrice=" + basePrice +
                ", topping1=" + topping1 +
                ", topping2=" + topping2 +
                ", topping3=" + topping3 +
                ", totalPrice=" + getPrice() + "}";
    }
}
