
class A {
    A() {
        System.out.println("Inside A's ctor");
    }
}

class B extends A {
    B() {
        System.out.println("Inside B's ctor");
    }
}

class C extends B {
    C() {
        System.out.println("Inside C's ctor");
    }
}

public class CallingCons {
    public static void main(String[] args) {
        C c = new C();
    }
}

// Output

// Inside A's constructor
// Inside B's constructor
// Inside C's constructor