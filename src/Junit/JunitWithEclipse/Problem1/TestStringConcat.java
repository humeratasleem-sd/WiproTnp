package Junit.JunitWithEclipse.Problem1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestStringConcat {

    @Test
    public void testDoStringConcat() {

        DailyTasks dt = new DailyTasks();

        String expected = "Hello World";
        String actual = dt.doStringConcat("Hello", "World");

        assertEquals(expected, actual);
    }
}