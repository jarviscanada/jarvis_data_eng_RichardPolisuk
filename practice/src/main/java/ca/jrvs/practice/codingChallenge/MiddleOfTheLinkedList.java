package ca.jrvs.practice.codingChallenge.c13;

// Two pointers trick
public class MiddleOfTheLinkedList {

  ListNode head;

  public static class ListNode {

    public int data;
    ListNode next;

    ListNode(int d) {
      data = d;
      next = null;
    }
  }

  public ListNode middleNode() {
    ListNode first_ptr = head;
    ListNode second_ptr = head;
    if (head != null) {
      while (second_ptr != null && second_ptr.next != null) {
        second_ptr = second_ptr.next.next;
        first_ptr = first_ptr.next;
      }
      return first_ptr;
    }
    return null;
  }

  public void push(int new_data) {
    ListNode new_node = new ListNode(new_data);
    new_node.next = head;
    head = new_node;
  }
}
