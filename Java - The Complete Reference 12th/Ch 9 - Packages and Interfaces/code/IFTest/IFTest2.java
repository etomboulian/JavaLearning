package IFTest;

class IFTest2 {
    public static void main(String[] args) {
        DynStack mystack1 = new DynStack(5);
        DynStack mystack2 = new DynStack(8);

        // these loops cause each stack to grow
        for (int i = 0; i < 12; i++)
            mystack1.push(i);
        for (int i = 0; i < 20; i++)
            mystack2.push(i);

        System.out.println("Stack in mystack1: ");
        for (int i = 0; i < 12; i++)
            System.out.print(mystack1.pop() + " ");

        System.out.println();

        System.out.println("Stack in mystack2: ");
        for (int i = 0; i < 20; i++)
            System.out.print(mystack2.pop() + " ");
    }
}

// Output

// Stack in mystack1:
// 11 10 9 8 7 6 5 4 3 2 1 0
// Stack in mystack2:
// 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0