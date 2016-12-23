package game.service;

import org.junit.Test;

import static game.service.GuessNumberUtils.isValid;
import static game.service.GuessNumberUtils.parseInputGuessNumber;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GuessNumberUtilsTest {
    @Test
    public void shouldValidateTheInput() throws Exception {
        assertTrue(isValid("1234"));
        assertFalse(isValid("1233"));
        assertFalse(isValid("1234AA"));
        assertFalse(isValid("Something"));
    }

    @Test
    public void shouldParseInputToIntArray() throws Exception {
        int[] input = parseInputGuessNumber("1234");
        assertThat(input.length, is(4));
    }
}