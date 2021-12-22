package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveElementTest {

  private RemoveElement removeElement;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    removeElement = new RemoveElement();
  }

  @Test
  public void removeElement() {
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    int expected = 5;
    Assert.assertEquals(expected, removeElement.removeElement(nums, val));
  }
}