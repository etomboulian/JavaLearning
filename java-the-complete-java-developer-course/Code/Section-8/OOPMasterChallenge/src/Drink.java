public class Drink {
    private String type;
    private DrinkSize size;
    private double price;

    private enum DrinkSize {
        SMALL('S', 1.00),
        MEDIUM('M', 2.00),
        LARGE('L', 3.00);

        private char size;
        private double price;

        DrinkSize(char size, double price) {
            this.size = size;
            this.price = price;
        }

        public char getSize() {
            return this.size;
        }

        public double getPrice() {
            return this.price;
        }

        public static DrinkSize getDrinkSize(char drinkSizeCode) {
            switch(Character.toUpperCase(drinkSizeCode)) {
                case 'S':
                    return DrinkSize.SMALL;
                case 'M':
                    return DrinkSize.MEDIUM;
                case 'L':
                    return DrinkSize.LARGE;
                default:
                    return DrinkSize.SMALL;
            }
        }

    }


    public Drink(String type, char sizeCode) {
        this.type = type;
        this.size = DrinkSize.getDrinkSize(sizeCode);
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DrinkSize getSize() {
        return this.size;
    }

    public void setSize(char drinkSizeCode) {
        this.size = DrinkSize.getDrinkSize(drinkSizeCode);
    }

    public double getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size=" + size +
                ", price=" + getPrice() +
                '}';
    }
}
