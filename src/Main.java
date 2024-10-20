import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Rolling the dice...");
            int die1 = rollDie(random);
            int die2 = rollDie(random);
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                System.out.println("Point is now " + sum + ".");
                int point = sum;
                boolean pointMade = false;

                while (!pointMade) {
                    System.out.println("Rolling again to try for point...");
                    die1 = rollDie(random);
                    die2 = rollDie(random);
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made the point! You win.");
                        pointMade = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        pointMade = true;
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
    }

    public static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }
}
