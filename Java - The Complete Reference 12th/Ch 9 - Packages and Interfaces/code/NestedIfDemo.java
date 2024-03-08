// A nested interface example

// This class contains the nested interface
class A {
    public interface NestedIF {
        boolean isNotNegative(int x);
    }
}

// B implements the nested interface from A
class B implements A.NestedIF {
    public boolean isNotNegative(int x) {
        return x < 0 ? false : true;
    }
}

public class NestedIfDemo {
    public static void main(String[] args) {
        A.NestedIF nif = new B();

        if (nif.isNotNegative((10)))
            System.out.println("10 is not negative");
        if (nif.isNotNegative(-12))
            System.out.println("This won't be displayed");
    }
}

// Output
// 10 is not negative