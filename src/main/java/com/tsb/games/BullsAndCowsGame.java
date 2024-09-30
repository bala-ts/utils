package com.tsb.games;
import java.util.*;

public class BullsAndCowsGame {

    private static final int NUMBER_LENGTH = 4;

    public static void main(String[] args) {
        System.out.println("Welcome to Bulls and Cows Game!");
        System.out.println("Try to guess the secret 4-digit number with unique digits.");

        Scanner scanner = new Scanner(System.in);
        String secretNumber = generateSecretNumber();

        boolean guessedCorrectly = false;
        int attempts = 0;

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (!isValidGuess(guess)) {
                System.out.println("Invalid guess. Please enter a 4-digit number with unique digits.");
                continue;
            }

            attempts++;
            Result result = getBullsAndCows(secretNumber, guess);

            if (result.getBulls() == NUMBER_LENGTH) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number " + secretNumber + " in " + attempts + " attempts.");
            } else {
                System.out.println("Bulls: " + result.getBulls() + ", Cows: " + result.getCows());
            }
        }

        scanner.close();
    }

    private static String generateSecretNumber() {
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();

        while (digits.size() < NUMBER_LENGTH) {
            int digit = random.nextInt(10);
            digits.add(digit);
        }

        StringBuilder secretNumber = new StringBuilder();
        for (int digit : digits) {
            secretNumber.append(digit);
        }

        return secretNumber.toString();
    }

    private static boolean isValidGuess(String guess) {
        if (guess.length() != NUMBER_LENGTH) {
            return false;
        }

        Set<Character> uniqueDigits = new HashSet<>();
        for (char ch : guess.toCharArray()) {
            if (!Character.isDigit(ch) || !uniqueDigits.add(ch)) {
                return false;
            }
        }

        return true;
    }

    private static Result getBullsAndCows(String secretNumber, String guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (secretNumber.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                cows++;
            }
        }

        return new Result(bulls, cows);
    }

    private static class Result {
        private final int bulls;
        private final int cows;

        public Result(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }
}
