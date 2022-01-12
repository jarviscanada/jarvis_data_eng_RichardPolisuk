package ca.jrvs.practice.codingChallenge.c05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// One Queue
class MyOneQueueStack {

  Queue<Integer> queue;

  public MyOneQueueStack() {
    queue = new LinkedList<>();
  }

  // O(N)
  public void push(int x) {
    queue.add(x);
    int size = queue.size();
    while (size-- > 1) {
      queue.add(queue.remove());
    }
  }

  //O(1)
  public int pop() {
    return queue.remove();
  }

  // O(1)
  public int top() {
    return queue.element();
  }

  // O(1)
  public boolean empty() {
    return queue.isEmpty();
  }
}


// Two Queues - push and pop
class MyTwoQueueStack {

  Queue<Integer> q1;
  Queue<Integer> q2;

  public MyTwoQueueStack() {
    q1 = new ArrayDeque<>();
    q2 = new ArrayDeque<>();
  }

  //O(n)
  public void push(int x) {
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    q1.add(x);
    while (!q2.isEmpty()) {
      q1.add(q2.remove());
    }
  }

  //O(1)
  public int pop() {
    return q1.remove();
  }

  //O(1)
  public int top() {
    return q1.element();
  }

  //O(1)
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}

public class StackUsingQueue {

  public static void main(String[] args) {
    MyOneQueueStack myOneStack = new MyOneQueueStack();
    myOneStack.push(3);
    myOneStack.push(4);
    System.out.println(myOneStack.top()); // return 4
    System.out.println(myOneStack.pop()); // return 4
    System.out.println(myOneStack.empty()); // return False

    MyTwoQueueStack myTwoStack = new MyTwoQueueStack();
    myTwoStack.push(1);
    myTwoStack.push(2);
    System.out.println(myTwoStack.top()); // return 2
    System.out.println(myTwoStack.pop()); // return 2
    System.out.println(myTwoStack.empty()); // return False
  }

}
