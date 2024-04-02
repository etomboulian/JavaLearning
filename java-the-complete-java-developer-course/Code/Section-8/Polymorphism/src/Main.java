import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Movie movie = new Adventure("Star Wars");

        //Movie movie = Movie.getMovie("ScienceFiction", "Star Wars");
        //movie.watchMovie();

        Scanner s = new Scanner (System.in);
        while (true) {
            System.out.print("Enter Type (A for Advienture, C for Comedy, S for Science Fiction, or Q to Quit): ");
            String type = s.nextLine();
            if ("Qq".contains(type)) {
                break;
            }
            System.out.print("Enter movie title:" );
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
