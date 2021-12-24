package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String s) {
    // Needs to be even
    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c); // Save the open
      }
      else {
        if (stack.isEmpty()) {
          return false;
        }
        char pop = stack.pop(); // Get the open
        if (c == ')' && pop != '(') {
          return false; // No match
        }
        if (c == '}' && pop != '{') {
          return false; // No match
        }
        if (c == ']' && pop != '[') {
          return false; // No match
        }
      }
    }
    return stack.isEmpty();
  }
}
