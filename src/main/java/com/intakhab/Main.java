package com.intakhab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        userLogin.login();
    }
}

class UserLogin {
    public void login() {
        GuessingGameCompany gameCompany = new GuessingGameCompany();
        gameCompany.checkCredentials();
    }
}

class GuessingGameCompany {

    public void checkCredentials() {
        int remainingAttempts = 3;
        GuessingGame game = new GuessingGame();
        try {
            game.getInput();
            game.validateCredentials();
        } catch (AuthenticationException e) {
            System.out.println("Error.....\nEnter again");
            System.out.println("Attempts left: " + --remainingAttempts);
            try {
                game.getInput();
                game.validateCredentials();
            } catch (AuthenticationException e1) {
                System.out.println("Error.....\nEnter again");
                System.out.println("Attempts left: " + --remainingAttempts);
                try {
                    game.getInput();
                    game.validateCredentials();
                } catch (AuthenticationException e2) {
                    System.out.println("Attempts left: " + --remainingAttempts);
                    System.out.println("You have exhausted all three attempts");
                    System.out.println("Please re-run the program to try again");
                }
            }
        }
    }

}

class RandomNumberGenerator {
    int generateRandomNumber() {
        Random rand = new Random();
        int max = 155, min = 0;
        return rand.nextInt(max - min + 1) + min;
    }
}

class GuesserPlayer {
    int guessedNumber;

    int guessNumber() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        guessedNumber = rng.generateRandomNumber();
        System.out.println(guessedNumber);
        return guessedNumber;
    }
}

class HumanPlayer {
    int guessedNumber;
    Scanner scanner = new Scanner(System.in);

    int guessNumber() {
        System.out.println("Player, please guess a number:");
        guessedNumber = scanner.nextInt();
        return guessedNumber;
    }
}

class Judge {
    int numberFromGuesser;
    int numberFromPlayer1;
    int numberFromPlayer2;
    int numberFromPlayer3;

    void collectNumberFromGuesser() {
        GuesserPlayer guesser = new GuesserPlayer();
        numberFromGuesser = guesser.guessNumber();
    }

    void collectNumberFromPlayer() {
        HumanPlayer player1 = new HumanPlayer();
        HumanPlayer player2 = new HumanPlayer();
        HumanPlayer player3 = new HumanPlayer();

        numberFromPlayer1 = player1.guessNumber();
        numberFromPlayer2 = player2.guessNumber();
        numberFromPlayer3 = player3.guessNumber();
    }

    void compareNumbers() {
        if (numberFromPlayer1 == numberFromGuesser) {
            if (numberFromPlayer2 == numberFromGuesser && numberFromPlayer3 == numberFromGuesser) {
                System.out.println("Players 1, 2, and 3 win");
            } else if (numberFromPlayer2 == numberFromGuesser) {
                System.out.println("Players 1 and 2 win");
            } else if (numberFromPlayer3 == numberFromGuesser) {
                System.out.println("Players 1 and 3 win");
            } else {
                System.out.println("Player 1 wins");
            }
        } else if (numberFromPlayer2 == numberFromGuesser) {
            if (numberFromPlayer3 == numberFromGuesser) {
                System.out.println("Players 2 and 3 win");
            } else {
                System.out.println("Player 2 wins");
            }
        } else if (numberFromPlayer3 == numberFromGuesser) {
            System.out.println("Player 3 wins");
        } else {
            System.out.println("None of the players guessed the correct number");
        }
        System.out.println("Guessed number: " + numberFromGuesser);
    }
}

class AuthenticationException extends Exception {

}

class GuessingGame {
    String validUsername = "admin";
    String validPassword = "password";
    String enteredUsername;
    String enteredPassword;
    Scanner scanner = new Scanner(System.in);

    public void getInput() {

        System.out.print("Enter your username: ");
        enteredUsername = scanner.next();
        System.out.println("Enter your password:");
        enteredPassword = scanner.next();

    }

    public void validateCredentials() throws AuthenticationException {
        if (enteredUsername.equalsIgnoreCase(validUsername) && enteredPassword.equals(validPassword)) {
            Judge judge = new Judge();
            judge.collectNumberFromGuesser();
            judge.collectNumberFromPlayer();
            judge.compareNumbers();
        } else {
            throw new AuthenticationException();

        }
    }

}
