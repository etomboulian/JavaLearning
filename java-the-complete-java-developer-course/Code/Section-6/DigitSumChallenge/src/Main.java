public class Main {

    public static int sumDigits(int number) {
        if (number < 0) {
            return -1;
        }

        int sumDigits = 0;

        while (number > 0) {
            sumDigits += number % 10;
            number = number / 10;
        }
        return sumDigits;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(32123));
    }
}
