package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainsDuplicateTest {

  private ContainsDuplicate containsDuplicate;
  int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
  int[] nums2 = new int[]{2, 4, 6, 8, 10};

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    containsDuplicate = new ContainsDuplicate();
  }

  @Test
  public void containsDuplicateSorting() {
    System.out.println("Test case: test containsDuplicateSorting method from the test class");
    Assert.assertTrue(containsDuplicate.containsDuplicateSorting(nums1));
  }

  @Test
  public void containsDuplicateSet() {
    System.out.println("Test case: test containsDuplicateSet method from the test class");
    Assert.assertFalse(containsDuplicate.containsDuplicateSet(nums2));
  }
}