package ca.jrvs.practice.codingChallenge.c06;

import java.util.Stack;

class MyQueue {

  private final Stack<Integer> push;
  private final Stack<Integer> pop;

  public MyQueue() {
    push = new Stack<>();
    pop = new Stack<>();
  }

  public void push(int x) {
    push.push(x);
  }

  public int pop() {
    load();
    return pop.pop();
  }

  public int peek() {
    load();
    return pop.peek();
  }

  public boolean empty() {
    return pop.size() + push.size() == 0;
  }

  private void load() {
    if (pop.isEmpty()) {
      while (!push.isEmpty()) {
        pop.add(push.pop());
      }
    }
  }
}

public class QueueUsingStack {

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    System.out.println(myQueue.peek()); // return 1
    System.out.println(myQueue.pop()); // return 1, queue is [2]
    System.out.println(myQueue.empty()); // return false
  }
}
