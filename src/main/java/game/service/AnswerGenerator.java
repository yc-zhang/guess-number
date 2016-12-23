package game.service;

public class AnswerGenerator {
    public int[] generate() {
        int[] answer = new int[4];
        for (int i = 0; i < answer.length; i++) {
            int randomDigit = (int) (Math.random() * 10);
            boolean contain = false;
            for (int existedDigit : answer) {
                if (existedDigit == randomDigit) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                answer[i] = randomDigit;
            }
        }
        return answer;
    }
}
