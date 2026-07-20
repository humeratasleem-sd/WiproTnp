package Junit.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Junit.AssertMethodsAndAnnotations.Problem1.TestSort;
import Junit.AssertMethodsAndAnnotations.Problem2.TestCheckPresence;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestSort.class,
    TestCheckPresence.class
})

public class TestSuite {

}
