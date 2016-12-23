package game.service;

import game.model.CompareResult;

public class Guess {
    private final int[] answer;
    private final CompareNumber comparator;
    public Guess(AnswerGenerator generator, CompareNumber comparator) {
        this.answer = generator.generate();
        this.comparator = comparator;
    }

    public CompareResult guess(int[] input) {
        return comparator.compare(answer, input);
    }
}
