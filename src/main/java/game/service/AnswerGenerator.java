package game.service;

import java.util.Random;
import java.util.stream.IntStream;

public class AnswerGenerator {
    private final Random random;

    public AnswerGenerator(Random random) {
        this.random = random;
    }

    public int[] generate() {
        int[] answer = new int[] {-1, -1, -1, -1};
        for (int i = 0; i < answer.length; i++) {
            int randomDigit = random.nextInt(10);
            if (IntStream.of(answer).noneMatch(n -> n == randomDigit)) {
                answer[i] = randomDigit;
            } else {
                i--;
            }
        }
        return answer;
    }
}
