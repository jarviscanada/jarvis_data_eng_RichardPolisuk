package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissingNumberTest {

  private MissingNumber missingNumber;
  int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    missingNumber = new MissingNumber();
  }

  @Test
  public void missingNumberSum() {
    System.out.println("Test case: test missingNumberSum method from the test class");
    Assert.assertEquals(8, missingNumber.missingNumberSum(nums));
  }

  @Test
  public void missingNumberSet() {
    System.out.println("Test case: test missingNumberSet method from the test class");
    Assert.assertEquals(8, missingNumber.missingNumberSet(nums));
  }

  @Test
  public void missingNumberGauss() {
    System.out.println("Test case: test missingNumberGauss method from the test class");
    Assert.assertEquals(8, missingNumber.missingNumberGauss(nums));
  }
}