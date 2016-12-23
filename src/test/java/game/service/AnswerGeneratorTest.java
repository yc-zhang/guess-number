package game.service;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest {
    @Test
    public void shouldReturn4UniqueDigits() throws Exception {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1, 2, 2, 4, 3, 3);

        AnswerGenerator generator = new AnswerGenerator(random);
        int[] answer = generator.generate();

        assertThat(answer.length, is(4));
        assertThat(answer, is(new int[] {1, 2, 4, 3}));
    }
}