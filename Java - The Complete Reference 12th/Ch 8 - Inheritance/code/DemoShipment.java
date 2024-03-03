
class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}

// Add weight to Box
class BoxWeight extends Box {
    double weight;

    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    BoxWeight() {
        super();
        weight = -1;
    }

    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}

// Add shipping costs
class Shipment extends BoxWeight {
    double cost;

    // clone ctor
    Shipment(Shipment ob) {
        super(ob);
        cost = ob.cost;
    }

    // ctor when all params specified
    Shipment(double w, double h, double d, double m, double c) {
        super(w, h, d, m);
        cost = c;
    }

    Shipment() {
        super();
        cost = -1;
    }

    Shipment(double len, double m, double c) {
        super(len, m);
        cost = c;
    }
}

class DemoShipment {
    public static void main(String[] args) {
        Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
        Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);

        System.out.println("Volume of shipment1 is " + shipment1.volume());
        System.out.println("Weight of shipment1 is " + shipment1.cost);
        System.out.println("Shipping cost: $" + shipment1.cost);

        System.out.println("Volume of shipment2 is " + shipment2.volume());
        System.out.println("Weight of shipment2 is " + shipment2.cost);
        System.out.println("Shipping cost: $" + shipment2.cost);

    }
}

// Output

// Volume of shipment1 is 3000.0
// Weight of shipment1 is 10.0
// Shipping cost: $3.41

// Volume of shipment2 is 24.0
// Weight of shipment2 is 0.76
// Shipping cost: $1.28