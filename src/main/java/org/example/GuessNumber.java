package org.example;

import java.util.Scanner;

/*
 *
 *     Generate a random number 1 to 100,
 *      ask the user to guess the number
 *      and print if inserted number is higher,
 *      lower or equal to the number.
 *      Ask question until user has entered "exit"*
 *      Hint: Math.random()
 * */
public class GuessNumber {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 100) + 1;
        System.out.println("Guess a random number from 1 to 100 or type exit to stop");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("The number is out of range, please guess a number between 0 and 100!");
                } else if (randomNumber > userGuess) {
                    System.out.println("The correct number is bigger. Guess again!");
                } else if (randomNumber < userGuess) {
                    System.out.println("The correct number is smaller. Guess again!");
                } else {
                    System.out.println("You guessed correctly, you are the master!");
                    return;
                }
            } else if (scanner.next().equals("exit")) {
                System.out.println("Pity to see you going, see you soon!");
                return;
            } else {
                System.out.println("Bad input, try Again.");
            }
        }
    }
}
