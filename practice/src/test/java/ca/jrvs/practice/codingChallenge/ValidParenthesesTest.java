package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.c07.ValidParentheses;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
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