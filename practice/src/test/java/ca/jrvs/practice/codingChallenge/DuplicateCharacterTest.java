package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.c21.DuplicateCharacter;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DuplicateCharacterTest {

  private DuplicateCharacter duplicateCharacter;

  @Before
  public void setUp() throws Exception {
    System.out.println("--@Before method runs before each @Test method");
    //instantiate a test class for each @Test method
    duplicateCharacter = new DuplicateCharacter();
  }

  @Test
  public void findDuplicate() {
    System.out.println("Test case: test findDuplicate method from the test class");

    ArrayList<String> expected = new ArrayList<>();
    expected.add("\"" + 'a' + "\"");
    expected.add("\"" + 'c' + "\"");

    Assert.assertEquals(expected, duplicateCharacter.findDuplicate("A black cat"));
  }
}