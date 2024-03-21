public class BankAccount {
    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        // constructor chaining with this()
        this("0000", 0.0, "Default User", "Default Address", "Default Phone");
        System.out.println("Empty ctor called");
    }

    public BankAccount(String number, double balance, String customerName, String email, String phone) {
        this.accountNumber = number;
        this.accountBalance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phone;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("99999", 100.55, customerName, email, phoneNumber);
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void deposit(double amount) {
        System.out.println("Depositing: " + amount);
        setAccountBalance(getAccountBalance() + amount);
        System.out.println("New balance is " + getAccountBalance());
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawing: " + amount);

        if (getAccountBalance() >= amount) {
            setAccountBalance(getAccountBalance() - amount);
        } else {
            System.out.println("Unable to withdraw " + amount + " as it exceeds the current balance of " + getAccountBalance());
        }
        System.out.println("New balance is " + getAccountBalance());
    }
}
