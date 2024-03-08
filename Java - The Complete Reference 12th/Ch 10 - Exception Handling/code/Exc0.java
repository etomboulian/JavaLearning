
public class Exc0 {
    public static void main(String[] args) {
        int d = 0;
        int a = 42 / d;
    }
}

// Output
// Exception in thread "main" java.lang.ArithmeticException: / by zero
// at Exc0.main(Exc0.java:5)
