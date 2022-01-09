package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ContainsDigitsTest {

  private ContainsDigits containsDigits;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    containsDigits = new ContainsDigits();
  }

  @Test
  public void containsDigitsASCII() {
    System.out.println("Test case: test containsDigitsASCII method from the test class");
    Assert.assertFalse(containsDigits.containsDigitsASCII("0123,456789"));
  }

  @Test
  public void containsDigitsValueOf() {
    System.out.println("Test case: test containsDigitsValueOf method from the test class");
    Assert.assertFalse(containsDigits.containsDigitsValueOf("0123,456789"));
  }

  @Test
  public void containsDigitRegEx() {
    System.out.println("Test case: test containsDigitRegEx method from the test class");
    Assert.assertTrue(containsDigits.containsDigitsValueOf("0123456789"));
  }
}