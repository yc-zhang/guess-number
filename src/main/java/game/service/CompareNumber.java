package game.service;

import game.model.CompareResult;

public class CompareNumber {
    public CompareResult compare(int[] answer, int[] guessNumber) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < guessNumber.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (guessNumber[i] == answer[j]) {
                    if (i == j) {
                        ++a;
                    } else {
                        ++b;
                    }
                }
            }
        }

        return new CompareResult(a, b);
    }
}
