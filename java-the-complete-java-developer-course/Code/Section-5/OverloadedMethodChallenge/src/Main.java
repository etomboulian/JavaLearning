public class Main {

    public static void main(String[] args) {
        System.out.println("60 inches is " + convertToCentimeters(60) + " cm");
        System.out.println("1 inches is " + convertToCentimeters(1) + " cm");
        System.out.println("6 feet and 5 inches is " + convertToCentimeters(6, 5) + " cm");
        System.out.println("6 feet " + convertToCentimeters(6, 0) + " cm");
    }

    public static double convertToCentimeters(int heightInInches) {
        return heightInInches * 2.54d;
    }

    public static double convertToCentimeters(int heightInFeet, int remainingInches) {
        int totalInches = (heightInFeet * 12) + remainingInches;
        return convertToCentimeters(totalInches);
    }
}
