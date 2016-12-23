package game.service;

import game.model.CompareResult;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessTest {
    @Test
    public void shouldReturnCompareResult() throws Exception {
        CompareResult mockResult = new CompareResult(2, 2);
        int[] answer = new int[] {1, 2, 3, 4};
        int[] input = new int[] {1, 2, 4, 3};

        AnswerGenerator generator = mock(AnswerGenerator.class);
        when(generator.generate()).thenReturn(answer);

        CompareNumber comparator = mock(CompareNumber.class);
        when(comparator.compare(answer, input)).thenReturn(mockResult);

        Guess guess = new Guess(generator, comparator);
        CompareResult result = guess.guess(input);

        assertSame(result, mockResult);
    }
}
