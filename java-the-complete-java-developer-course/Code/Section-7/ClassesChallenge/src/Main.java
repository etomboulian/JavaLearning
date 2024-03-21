import javax.swing.text.BadLocationException;

public class Main {
    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("12345", 1000.00, "Bob Brown", "myemail@bob.com", "(090) 123-4567");
        acct1.setAccountBalance(50.00);
        System.out.println();
        acct1.deposit(50.00);
        System.out.println();
        acct1.withdraw(25.00);
        System.out.println();
        acct1.withdraw(100.00);
        System.out.println();

        BankAccount evanAccount = new BankAccount("Evavn", "evan@example.com", "12345");
        System.out.println(evanAccount.getAccountNumber());

    }
}
