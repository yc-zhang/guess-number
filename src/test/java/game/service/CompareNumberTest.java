package game.service;

import game.model.CompareResult;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompareNumberTest {

    private CompareNumber comparator;

    @Before
    public void setUp() throws Exception {
        comparator = new CompareNumber();
    }

    @Test
    public void shouldReturnCorrectBIfValueMatchOnly() throws Exception {
        CompareResult result = comparator.compare(new int[]{1, 2, 3, 4}, new int[]{4, 2, 3, 9});
        assertThat(result.getB(), is(1));
    }

    @Test
    public void shouldReturnCorrectAIfValueAndPositionMatch() throws Exception {
        CompareResult result = comparator.compare(new int[]{1, 2, 3, 4}, new int[]{4, 2, 3, 9});
        assertThat(result.getA(), is(2));
    }

    @Test
    public void shouldReturn0IfNoneMatch() throws Exception {
        CompareResult result = comparator.compare(new int[]{1, 2, 3, 4}, new int[]{9, 9, 7, 6});
        assertThat(result.getA(), is(0));
        assertThat(result.getB(), is(0));
    }
}