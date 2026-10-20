import java.util.Random;
import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("=== New Game of Craps ===");

            // Initial roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            } else {
                int point = sum;
                System.out.println("The point is now " + point);

                boolean gameOver = false;
                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Play again? (y/n): ");
            playAgain = in.nextLine().trim();
            System.out.println();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        in.close();
    }
}