package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.c01.CompareMaps;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CompareMapsTest {

  private CompareMaps compareMaps;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    compareMaps = new CompareMaps();
  }

  @Test
  public void compareMapsEquals() {
    Map<String, String> map1 = new HashMap<>();
    map1.put("key1","element 1");
    map1.put("key2","element 2");
    map1.put("key3","element 3");

    Map<String, String> map2 = new HashMap<>();
    map2.put("key1","element 1");
    map2.put("key2","element 2");
    map2.put("key3","element 3");

    System.out.println("Test case: test compareMapsEquals method from the test class");
    assertTrue(compareMaps.compareMapsEquals(map1, map2));
  }

  @Test
  public void compareMapsStream() {
    Map<String, String> map1 = new HashMap<>();
    map1.put("key1","element 1");
    map1.put("key2","element 2");
    map1.put("key3","element 3");

    Map<String, String> map2 = new HashMap<>();
    map2.put("key1","element 1");
    map2.put("key2","element 2");
    map2.put("key3","element 3");

    System.out.println("Test case: test compareMapsStream method from the test class");
    assertTrue(compareMaps.compareMapsStream(map1, map2));
  }
}