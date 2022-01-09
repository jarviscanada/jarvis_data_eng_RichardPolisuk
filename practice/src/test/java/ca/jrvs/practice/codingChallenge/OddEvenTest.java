package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class OddEvenTest {

  private OddEven oddEven;

  @Before
  public void setUp() {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    oddEven = new OddEven();
  }

  @Test
  public void oddEvenMod() {
    System.out.println("Test case: test oddEvenMod method from the test class");
    String expected = "odd";
    Assert.assertEquals(expected, oddEven.oddEvenMod(3));
    expected = "even";
    Assert.assertEquals(expected, oddEven.oddEvenMod(4));
  }

  @Test
  public void oddEvenBit() {
    System.out.println("Test case: test oddEvenBit method from the test class");
    String expected = "odd";
    Assert.assertEquals(expected, oddEven.oddEvenBit(3));
    expected = "even";
    Assert.assertEquals(expected, oddEven.oddEvenBit(4));
  }
}