package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.c04.StringToInteger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class StringToIntegerTest {

  @Test
  public void myAtoiParse() {
    System.out.println("Test case: test myAtoiParse method from the test class");
    Assert.assertEquals(4193, new StringToInteger().myAtoiParse("4193 with words"));
  }

  @Test
  public void myAtoi() {
    System.out.println("Test case: test myAtoi method from the test class");
    Assert.assertEquals(-42, new StringToInteger().myAtoi("   -42"));
  }
}