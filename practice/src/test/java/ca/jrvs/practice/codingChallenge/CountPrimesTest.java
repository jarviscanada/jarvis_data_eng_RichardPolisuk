package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CountPrimesTest {

  private CountPrimes countPrimes;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    countPrimes = new CountPrimes();
  }

  @Test
  public void countPrimes() {
    int n = 5000000;
    int expected = 348513;
    Assert.assertEquals(expected, countPrimes.countPrimes(n));
  }
}