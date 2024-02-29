public class FindPrime {
    public static void main(String[] args) {
        int num;
        boolean isPrime;

        num = 17;

        if (num < 2)
            isPrime = false;
        else
            isPrime = true;

        for (int i = 2; i <= num / i; i++) {
            if ((num % i) == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.print(num + " is ");
        if (isPrime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");
    }
}
