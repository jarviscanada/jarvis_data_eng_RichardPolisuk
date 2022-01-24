package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.c10.IsAnagram;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class IsAnagramTest {

  private IsAnagram ia;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    ia = new IsAnagram();
  }

  @Test
  public void isAnagram() {
    System.out.println("Test case: test isAnagram method from the test class");
    assertTrue(ia.isAnagram("anagram", "nagaram"));
  }

  @Test
  public void isAnagramOn() {
    System.out.println("Test case: test isAnagramOn method from the test class");
    assertFalse(ia.isAnagramOn("rat", "car"));
  }
}