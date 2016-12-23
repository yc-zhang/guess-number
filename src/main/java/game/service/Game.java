package game.service;

import game.model.CompareResult;

import java.io.BufferedReader;
import java.io.IOException;

import static game.service.GuessNumberUtils.isValid;
import static game.service.GuessNumberUtils.parseInputGuessNumber;

public class Game {
    private final Guess guess;
    private final BufferedReader reader;

    public Game(Guess guess, BufferedReader reader) {
        this.guess = guess;
        this.reader = reader;
    }

    public void play() {
        System.out.println("Welcome!");
        int round = 6;
        try {
            for (int i = 0; i < round; i++) {
                System.out.println("Round " + (i + 1) + " please input your number: ");
                String input = reader.readLine();
                if (isValid(input)) {
                    int[] inputDigits = parseInputGuessNumber(input);
                    CompareResult compareResult = this.guess.guess(inputDigits);
                    if (compareResult.getA() == 4) {
                        System.out.println("Congratulations!");
                        return;
                    } else {
                        System.out.println(compareResult.toString());
                    }
                } else {
                    System.out.println("Please input valid numbers!");
                    i--;
                }
            }
            System.out.println("Game Over!");
        } catch (IOException e) {
            System.out.println("IOException while input sth. " + e.getMessage());
        }
    }
}
