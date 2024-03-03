
class Box {
    private double width;
    private double height;
    private double depth;

    // construct clone of an object
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // ctor used when all dimesions are specified
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // ctor used when no dimensions specified
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // ctor used when a cube is created
    Box(double len) {
        width = height = depth = len;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}

class BoxWeight extends Box {
    double weight; // weight of box

    // construct a clone of an object
    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    // default ctor
    BoxWeight() {
        super();
        weight = -1;
    }

    // ctor used when cube is created
    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}

public class DemoSuper {
    public static void main(String[] args) {
        BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
        BoxWeight mybox3 = new BoxWeight();
        BoxWeight mycube = new BoxWeight(3, 2);
        BoxWeight myclone = new BoxWeight(mybox1);

        double vol;

        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);
        System.out.println("Weight of mybox1 is " + mybox1.weight);

        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);
        System.out.println("Weight of mybox2 is " + mybox2.weight);

        vol = mybox3.volume();
        System.out.println("Volume of mybox3 is " + vol);
        System.out.println("Weight of mybox3 is " + mybox3.weight);

        vol = myclone.volume();
        System.out.println("Volume of myclone is " + vol);
        System.out.println("Weight of myclone is " + myclone.weight);

        vol = mycube.volume();
        System.out.println("Volume of mycube is " + vol);
        System.out.println("Weight of mycube is " + mycube.weight);
    }
}

// Output:

// Volume of mybox1 is 3000.0
// Weight of mybox1 is 34.3

// Volume of mybox2 is 24.0
// Weight of mybox2 is 0.076

// Volume of mybox3 is -1.0
// Weight of mybox3 is -1.0

// Volume of myclone is 3000.0
// Weight of myclone is 34.3

// Volume of mycube is 27.0
// Weight of mycube is 2.0