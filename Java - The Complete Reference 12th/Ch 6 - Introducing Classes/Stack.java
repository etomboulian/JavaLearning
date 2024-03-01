
class Stack {
    int[] stack = new int[10];
    int topOfStack;

    // Initialize top-of-stack
    Stack() {
        topOfStack = -1;
    }

    // Push an item onto the stack
    void push(int item) {
        if (topOfStack == 9)
            System.out.println("Stack is full.");
        else
            stack[++topOfStack] = item;
    }

    // Pop and item from the stack
    int pop() {
        if (topOfStack < 0) {
            System.out.println("Stack underflow.");
            return 0;
        } else
            return stack[topOfStack--];
    }
}

class TestStack {
    public static void main(String[] args) {
        Stack mystack1 = new Stack();
        Stack mystack2 = new Stack();

        for (int i = 0; i < 10; i++)
            mystack1.push(i);
        for (int i = 10; i < 20; i++)
            mystack2.push(i);

        System.out.println("Stack in mystack1:");
        for (int i = 0; i < 10; i++) {
            System.out.println(mystack1.pop());
        }

        System.out.println("Stack in mystack2:");
        for (int i = 0; i < 10; i++) {
            System.out.println(mystack2.pop());
        }
    }
}
