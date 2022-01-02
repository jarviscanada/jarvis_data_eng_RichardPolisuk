package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateStringTest {

  private RotateString rotateString;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    rotateString = new RotateString();
  }

  @Test
  public void rotateString() {
    System.out.println("Test case: test rotateString method from the test class");
    String s = "abcde";
    String goal = "cdeab";
    Assert.assertTrue(rotateString.rotateString(s, goal));
    s = "abcde";
    goal = "abced";
    Assert.assertFalse(rotateString.rotateString(s, goal));
  }
}