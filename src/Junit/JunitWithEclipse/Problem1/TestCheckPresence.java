package Junit.JunitWithEclipse.Problem1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestCheckPresence {

    @Test
    public void testCheckPresence() {
        DailyTasks dt = new DailyTasks();

        assertTrue(dt.checkPresence("Welcome to Wipro", "Wipro"));
    }
}