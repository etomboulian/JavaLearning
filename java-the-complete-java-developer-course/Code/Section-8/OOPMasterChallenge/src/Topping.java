public enum Topping {
    CHEESE("Cheese", 0.50),
    BACON("Bacon", 1.00),
    CHILLI("Chilli", 1.50),
    EGG("Egg", 0.50);

    private String name;
    private double price;

    private Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public static Topping getToppingByName(String toppingName) {
        Topping foundTopping = null;
        for(Topping t : Topping.values()) {
            if (t.getName().toLowerCase().equals(toppingName.toLowerCase())) {
                foundTopping = t;
            }
        }
        return foundTopping;
    }


}
