package game;

import game.service.AnswerGenerator;
import game.service.CompareNumber;
import game.service.Game;
import game.service.Guess;

import java.util.Random;

public class Main {
    public static void main(String... args) {
        Guess guess = new Guess(new AnswerGenerator(new Random(System.currentTimeMillis())), new CompareNumber());
        Game game = new Game(guess);
        game.play();
    }
}
