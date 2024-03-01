
class Box {
    double width;
    double height;
    double depth;

    void volume() {
        System.out.print("Volume is ");
        System.out.println(width * height * depth);
    }
}

public class BoxDemo3 {
    public static void main(String[] args) {
        Box mybox1 = new Box();
        Box mybox2 = new Box();

        // assign values to mybox1's instance vars
        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        // different values to mybox2
        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        // Display volume of first box
        mybox1.volume();

        // Display volume of second box
        mybox2.volume();
    }
}
