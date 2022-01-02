package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindLargestSmallestTest {

  private FindLargestSmallest fls;
  Integer[] nums = new Integer[]{9, 6, 4, 2, -3, 5, 7, 0, 1};
  final int[] expected = {-3, 9};

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    fls = new FindLargestSmallest();
  }

  @Test
  public void findLargestSmallestOneLoop() {
    System.out.println("Test case: test findLargestSmallestOneLoop method from the test class");
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(fls.findLargestSmallestOneLoop(nums)));
  }

  @Test
  public void findLargestSmallestStreams() {
    System.out.println("Test case: test findLargestSmallestStreams method from the test class");
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(fls.findLargestSmallestStreams(nums)));
  }

  @Test
  public void findLargestSmallestCollections() {
    System.out.println("Test case: test findLargestSmallestCollections method from the test class");
    Assert.assertEquals(
        Arrays.toString(expected),
        Arrays.toString(fls.findLargestSmallestCollections(nums)));
  }
}