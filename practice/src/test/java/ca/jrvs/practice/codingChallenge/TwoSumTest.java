package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

  TwoSum ts = new TwoSum();
  int[] nums = new int[]{2, 11, 15, 7};
  int target = 9;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    ts = new TwoSum();
  }

  @Test
  public void twoSumBrute() {
    System.out.println("Test case: test twoSumBrute method from the test class");
    int[] expected = {0, 3};
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(ts.twoSumBrute(nums, target)));
  }

  @Test
  public void twoSumBruteOn() {
    System.out.println("Test case: test twoSumBruteOn method from the test class");
    int[] expected = {0, 3};
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(ts.twoSumBruteOn(nums, target)));
  }
}