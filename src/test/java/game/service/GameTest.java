package game.service;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Random;

import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void startGameThenPrintCongratulations() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1234");

        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);

        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        Guess guess = new Guess(new AnswerGenerator(random), new CompareNumber());

        Game game = new Game(guess, reader);

        game.play();

        verify(printStream).println("Welcome!");
        verify(printStream).println("Round 1 please input your number: ");
        verify(printStream).println("Congratulations!");
    }

    @Test
    public void startGameThenPrintGameOver() throws Exception {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5678", "9043", "1243", "2345", "9871", "2354");

        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        Guess guess = new Guess(new AnswerGenerator(random), new CompareNumber());
        Game game = new Game(guess, bufferedReader);

        game.play();

        verify(printStream).println("Welcome!");
        verify(printStream).println("Round 1 please input your number: ");
        verify(printStream).println("0A0B");
        verify(printStream).println("Round 2 please input your number: ");
        verify(printStream).println("0A2B");
        verify(printStream).println("Round 3 please input your number: ");
        verify(printStream).println("2A2B");
        verify(printStream).println("Round 4 please input your number: ");
        verify(printStream).println("0A3B");
        verify(printStream).println("Round 5 please input your number: ");
        verify(printStream).println("0A1B");
        verify(printStream).println("Round 6 please input your number: ");
        verify(printStream).println("1A2B");
        verify(printStream).println("Game Over!");
    }

    @Test
    public void startGameThenPrintRepeatError() throws Exception {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5678", "9043", "1242", "1243", "2345", "9871", "2354");

        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        Guess guess = new Guess(new AnswerGenerator(random), new CompareNumber());
        Game game = new Game(guess, bufferedReader);

        game.play();

        verify(printStream).println("Welcome!");
        verify(printStream).println("Round 1 please input your number: ");
        verify(printStream).println("0A0B");
        verify(printStream).println("Round 2 please input your number: ");
        verify(printStream).println("0A2B");
        verify(printStream, times(2)).println("Round 3 please input your number: ");
        verify(printStream).println("Please input valid numbers!");
        verify(printStream).println("2A2B");
        verify(printStream).println("Round 4 please input your number: ");
        verify(printStream).println("0A3B");
        verify(printStream).println("Round 5 please input your number: ");
        verify(printStream).println("0A1B");
        verify(printStream).println("Round 6 please input your number: ");
        verify(printStream).println("1A2B");
        verify(printStream).println("Game Over!");
    }
}
