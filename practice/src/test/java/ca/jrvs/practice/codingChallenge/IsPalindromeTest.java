package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsPalindromeTest {

  private IsPalindrome isp;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    isp = new IsPalindrome();
  }

  @Test
  public void isPalindromeRecursion() {
    System.out.println("Test case: test isPalindromeRecursion method from the test class");
    Assert.assertEquals(true, isp.isPalindromeRecursion("A man, a plan, a canal: Panama"));
  }

  @Test
  public void isPalindromeTwoPointers() {
    System.out.println("Test case: test isPalindromeTwoPointers method from the test class");
    Assert.assertEquals(true, isp.isPalindromeTwoPointers("A man, a plan, a canal: Panama"));
  }
}