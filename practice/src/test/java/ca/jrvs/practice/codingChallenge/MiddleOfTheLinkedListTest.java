package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.c13.MiddleOfTheLinkedList;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MiddleOfTheLinkedListTest {

  @Test
  public void middleNode() {
    MiddleOfTheLinkedList linkedList = new MiddleOfTheLinkedList();
    for (int i = 7; i > 0; --i) {
      linkedList.push(i);
    }
    System.out.println("Test case: test middleNode method from the test class");
    Assert.assertEquals(4, linkedList.middleNode().data);
  }
}