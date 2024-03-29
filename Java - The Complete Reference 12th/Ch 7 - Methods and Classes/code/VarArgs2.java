public class VarArgs2 {
    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " Contents: ");

        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("One vararg: ", 10);
        vaTest("Three Varargs: ", 1, 2, 3);
        vaTest("No varargs: ");
    }
}

// Output

// One vararg: 1 Contents: 10
// Three Varargs: 3 Contents: 1 2 3
// No varargs: 0 Contents: