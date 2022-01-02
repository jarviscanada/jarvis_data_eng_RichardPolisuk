package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SwapTwoNumbersTest {

  private SwapTwoNumbers swapTwo;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    swapTwo = new SwapTwoNumbers();
  }

  @Test
  public void swapMath() {
    int[] expected = {3, 2};
    System.out.println("Test case: test swapMath method from the test class");
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(swapTwo.swapMath(new int[]{2, 3})));
  }

  @Test
  public void swapBit() {
    int[] expected = {3, 2};
    System.out.println("Test case: test swapBit method from the test class");
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(swapTwo.swapBit(new int[]{2, 3})));
  }
}