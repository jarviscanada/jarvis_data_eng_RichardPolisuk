package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesTest {

  private RemoveDuplicates removeDuplicates;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    removeDuplicates = new RemoveDuplicates();
  }

  @Test
  public void removeDuplicates() {
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 4, 4};
    int expected = 5;
    Assert.assertEquals(expected, removeDuplicates.removeDuplicates(nums));
  }
}