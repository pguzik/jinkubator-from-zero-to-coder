package testing.junitVsSpock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * @author Piotrek
 */
@RunWith(Parameterized.class)
public class MyUrlValidatorJUnitTest{

    private MyUrlValidator myValidator = null;
    private String uriTestedNow = null;
    private boolean expectedResult = false;

    public MyUrlValidatorJUnitTest(String uriTestedNow, boolean expectedResult)
    {
        this.uriTestedNow = uriTestedNow;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	/* First element is the URI, second is the expected result */
        List<Object[]> uriToBeTested =  Arrays.asList(new Object[][]{
                {"http://www.google.com", true},
                {"file://home/users", true},
                {"http://localhost:8080/", false}});
        return uriToBeTested;
    }

    @Before
    public void beforeEachTest() {
        myValidator = new MyUrlValidator();
        myValidator.allowFileUrls(true);
    }

    @Test
    public void testCurrentUri() {
        assertEquals("Testing for " + uriTestedNow, expectedResult, myValidator.isValidUrl(uriTestedNow));
    }

    @Test
    public void testCurrentUriModernWay() {
        assertThat(myValidator.isValidUrl(uriTestedNow), is(expectedResult));
    }

}
