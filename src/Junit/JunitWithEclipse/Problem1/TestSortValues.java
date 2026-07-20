package Junit.JunitWithEclipse.Problem1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestSortValues {

    @Test
    public void testSortValues() {
        DailyTasks dt = new DailyTasks();

        int[] input = {5, 2, 4, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, dt.sortValues(input));
    }
}