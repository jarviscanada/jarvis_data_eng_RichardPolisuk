package ca.jrvs.practice.codingChallenge;

public class ReverseLinkedList {

  // Recursion
  public ListNode reverseList2(ListNode head) {
    return reverseRecursively(head, null);
  }

  public ListNode reverseRecursively(ListNode head, ListNode prevNode) {
    if (head == null) {
      return prevNode;
    }

    ListNode temp = head.next;
    head.next = prevNode;
    return reverseRecursively(temp, head);
  }

  // Iteration
  public ListNode reverseList1(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode prevNode = null;

    while (head != null) {
      ListNode temp = head.next;
      head.next = prevNode;
      prevNode = head;
      head = temp;
    }

    return prevNode;
  }
}
