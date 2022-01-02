package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest {

  private ValidParentheses validParentheses;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    validParentheses = new ValidParentheses();
  }

  @Test
  public void isValid() {
    assertTrue(validParentheses.isValid("()[]{}"));
  }
}