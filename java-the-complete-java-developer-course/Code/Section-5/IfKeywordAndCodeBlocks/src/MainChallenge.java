public class MainChallenge {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        // calculate and display final score the first time
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        // reassign some variables to new values
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        // calculate and display final score again
        finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("The next final score is " + finalScore);
        }
    }
}

