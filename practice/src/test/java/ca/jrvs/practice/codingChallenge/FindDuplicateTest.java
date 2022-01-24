package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.c22.FindDuplicate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FindDuplicateTest {

  private FindDuplicate findDuplicate;
  int[] nums = new int[]{14, 3, 4, 2, 14};

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    findDuplicate = new FindDuplicate();
  }

  @Test
  public void findDuplicateSorting() {
    System.out.println("Test case: test findDuplicateSorting method from the test class");
    Assert.assertEquals(14, findDuplicate.findDuplicateSorting(nums));
  }

  @Test
  public void findDuplicateSet() {
    System.out.println("Test case: test findDuplicateSet method from the test class");
    Assert.assertEquals(14, findDuplicate.findDuplicateSet(nums));
  }
}