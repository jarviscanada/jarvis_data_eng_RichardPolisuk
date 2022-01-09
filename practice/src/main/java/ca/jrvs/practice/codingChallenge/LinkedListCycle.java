package ca.jrvs.practice.codingChallenge;

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
// There is a cycle in a linked list if there is some node in the list that can be reached again by
// continuously following the next pointer. Internally, pos is used to denote the index of the
// node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
// Return true if there is a cycle in the linked list. Otherwise, return false.

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    // ListNode current = head;
    if (head == null) {
      return false;
    }
    ListNode firstPointer = head;
    ListNode secondPointer = head.next;

    while (firstPointer != secondPointer) {
      if (secondPointer == null || secondPointer.next == null) {
        return false;
      }

      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next.next;
    }
    return true;
  }
}
