package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.c12.NthFromEnd;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class NthFromEndTest {

  @Test
  public void ListToArrayList() {
    System.out.println("Test case: test ListToArrayList method from the test class");

    // Start Data
    NthFromEnd linkedList = new NthFromEnd();
    linkedList.push(7);
    linkedList.push(1);
    linkedList.push(3);
    linkedList.push(2);

    // End data
    List<Integer> expected = new ArrayList<>();
    expected.add(3);
    expected.add(1);
    expected.add(7);

    linkedList.deleteNodeFromEnd(4);
    Assert.assertEquals(expected, linkedList.ListToArrayList());

  }
}