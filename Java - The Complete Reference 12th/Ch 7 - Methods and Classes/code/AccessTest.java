class Test {
    int a; // default access
    public int b; // public access
    private int c; // private access

    // set c's value
    void setc(int i) {
        c = i;
    }

    // get c's value
    int getc() {
        return c;
    }
}

public class AccessTest {
    public static void main(String[] args) {
        Test ob = new Test();

        ob.a = 10;
        ob.b = 20;

        // This is not OK and will cause an error
        // ob.c = 100; // Error!

        // You must access c through its methods
        ob.setc(100); // OK
        System.out.println("a, b, and c: " + ob.a + " " + ob.b + " " + ob.getc());
    }
}
