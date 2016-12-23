package game.service;

import game.model.CompareResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessIntegrateTest {
    private Guess guess;

    @Before
    public void setUp() throws Exception {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);
        guess = new Guess(new AnswerGenerator(random), new CompareNumber());
    }

    @Test
    public void shouldReturn0A4BIfValuesMatchOnly() throws Exception {
        CompareResult result = guess.guess(new int[] {4, 3, 2, 1});
        assertThat(result.getA(), is(0));
        assertThat(result.getB(), is(4));
    }

    @Test
    public void shouldReturn4A0BIfValuesAndPositionMatch() throws Exception {
        CompareResult result = guess.guess(new int[] {1, 2, 3, 4});
        assertThat(result.getA(), is(4));
        assertThat(result.getB(), is(0));
    }

    @Test
    public void shouldReturn0A0BIfNoneMatch() throws Exception {
        CompareResult result = guess.guess(new int[]{9, 8, 7, 6});
        assertThat(result.getA(), is(0));
        assertThat(result.getB(), is(0));
    }
}