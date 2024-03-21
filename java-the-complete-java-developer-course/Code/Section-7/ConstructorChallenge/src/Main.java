public class Main {
    public static void main(String[] args) {

        // Using the default ctor
        Customer cust1 = new Customer();
        System.out.println(cust1);

        // Using the ctor with all args
        Customer cust2 = new Customer("Evan", 1000, "evan@example.com");
        System.out.println(cust2);

        // Using the ctor with only two args
        Customer cust3 = new Customer("Chapo", "chapo@example.com");
        System.out.println(cust3);
    }
}
