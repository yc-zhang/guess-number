package game.service;

public class GuessNumberUtils {
    public static boolean isValid(String input) {
        input = input.trim();
        return input.length() == 4
                && input.chars().filter(i -> {
                    int t = Character.getNumericValue(i);
                    return t >= 0 && t < 10;
                }).distinct().count() == 4;
    }

    public static int[] parseInputGuessNumber(String input) {
        return input.chars().map(Character::getNumericValue).toArray();
    }
}
