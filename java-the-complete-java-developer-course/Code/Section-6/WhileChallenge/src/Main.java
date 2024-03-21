public class Main {

    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    }

    public static void main(String[] args) {

        int counter = 5;
        int total = 0;
        while(counter <= 20) {
            if(isEvenNumber(counter)) {
                System.out.print(counter + " ");
                total++;
            }
            counter += 1;
            if (total >= 5) {
                break;
            }
        }
        System.out.println();
        System.out.println("Total number of evens found: " + total);


    }
}
