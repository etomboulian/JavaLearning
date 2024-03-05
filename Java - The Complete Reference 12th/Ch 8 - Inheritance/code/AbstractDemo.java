
abstract class A {
    abstract void callme();

    // concrete method still allowed in abstract class
    void callmetoo() {
        System.out.println("This is a concrete method");
    }
}

class B extends A {
    void callme() {
        System.out.println("B's implementation of callme.");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        B b = new B();
        b.callme();
        b.callmetoo();
    }
}

// Output
// B's implementation of callme.
// This is a concrete method