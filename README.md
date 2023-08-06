# GuesserGame
Guessing Game

A Java-based guessing game that involves a Guesser, Players, and an Umpire. The game centers around a Guesser who generates a random number, Players who attempt to guess this number, and an Umpire who determines the winner of the game.


## How to Run

Make sure you have Java installed.

Compile and run the code using the following commands in the terminal:

### ```javac LaunchGame.java```
### ```java LaunchGame```


Follow the prompts provided by the program.


## Code Description

- `LaunchGame` is the main class that initiates the game by calling the `login()` method of the `UserLogin` class.

- `UserLogin` is responsible for authenticating user login credentials by invoking the `checkCredentials()` method from the `GuessingGameCompany` class.

- `GuessingGameCompany` class manages the user authentication and communicates with the `Judge` class to initiate the guessing game.

- `Judge` class contains methods for collecting guesses from the Guesser and Players, and determining the winner of the game based on the guesses.

- `GuesserPlayer` class generates a random number that the Players need to guess.

- `HumanPlayer` class provides a method for Players to input their guesses.

- `AuthenticationException` class is a custom exception used to handle invalid login credentials provided by the user.

- `GuessingGame` handles the input of login credentials and throws `AuthenticationException` if the credentials are invalid.

This refactored code improves the clarity of the program's structure and enhances its readability.
