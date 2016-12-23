package game;

import game.service.AnswerGenerator;
import game.service.CompareNumber;
import game.service.Game;
import game.service.Guess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String... args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Guess guess = new Guess(new AnswerGenerator(new Random(System.currentTimeMillis())), new CompareNumber());
        Game game = new Game(guess, reader);
        game.play();
    }
}
