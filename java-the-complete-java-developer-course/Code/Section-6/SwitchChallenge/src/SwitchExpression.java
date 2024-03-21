public class SwitchExpression {
    public static void main(String[] args) {
        char letter = 'a';

        switch (letter) {
            case 'A' -> System.out.println("A = Able");
            case 'B' -> System.out.println("B = Baker");
            case 'C' -> System.out.println("C = Charlie");
            case 'D' -> System.out.println("D = Dog");
            case 'E' -> System.out.println("E = Easy");
            case 'F' -> System.out.println("F = Fox");
            case 'G' -> System.out.println("G = George");
            case 'H' -> System.out.println("H = How");
            case 'I' -> System.out.println("I = Item");
            case 'J' -> System.out.println("J = Jig");
            case 'K' -> System.out.println("K = King");
            case 'L' -> System.out.println("L = Love");
            case 'M' -> System.out.println("M = Mike");
            case 'N' -> System.out.println("N = Nan");
            case 'O' -> System.out.println("O = Oboe");
            case 'P' -> System.out.println("P = Peter");
            case 'Q' -> System.out.println("Q = Queen");
            case 'R' -> System.out.println("R = Roger");
            case 'S' -> System.out.println("S = Sugar");
            case 'T' -> System.out.println("T = Tare");
            case 'U' -> System.out.println("U = Uncle");
            case 'V' -> System.out.println("V = Victor");
            case 'W' -> System.out.println("W = William");
            case 'X' -> System.out.println("X = X-ray");
            case 'Y' -> System.out.println("Y = Yoke");
            case 'Z' -> System.out.println("Z = Zebra");
            default -> System.out.println(letter + " Not Found");
        }


    }
}
