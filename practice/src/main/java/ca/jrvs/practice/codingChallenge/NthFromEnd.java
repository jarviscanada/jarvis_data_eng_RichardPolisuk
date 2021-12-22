package ca.jrvs.practice.codingChallenge;

// Given a linked list and an integer N, the task is to delete the Nth node from
// the end of the given linked list.

import java.util.ArrayList;
import java.util.List;

public class NthFromEnd {

  Node head; // Head of list

  // Linked list Node
  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  // Delete nth node
  void deleteNodeFromEnd(int n) {

    Node first = head; // First pointer starting at the head of the list
    Node second = head; // Second pointer starting at head

    // Process the list until the nth node
    for (int i = 0; i < n; i++) {
      if (second.next == null) { // Have we reached end?
        if (i == n - 1) { // Delete head node when n reached
          head = head.next;
        }
        return;
      }
      second = second.next;
    }

    // Increment both the pointers by one until second pointer reaches the end
    while (second.next != null) {
      first = first.next;
      second = second.next;
    }

    assert first.next != null;
    first.next = first.next.next; // Delete node
  }

  // Insert a new Node at front of the list
  public void push(int data) {
    Node node = new Node(data);
    node.next = head;
    head = node;
  }

  // Return the Linked List as an ArrayList
  public List<Integer> ListToArrayList() {
    List<Integer> results = new ArrayList<>();
    Node node = head;
    while (node != null) { // Traverse the list
      results.add(node.data);
      node = node.next;
    }
    return results;
  }
}
