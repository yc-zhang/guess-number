package game.service;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnswerGeneratorTest {
    @Test
    public void shouldReturn4UniqueDigits() throws Exception {
        AnswerGenerator generator = new AnswerGenerator();
        int[] answer = generator.generate();

        assertThat(answer.length, is(4));
        assertThat(IntStream.of(answer).distinct().count(), is(4L));
    }
}