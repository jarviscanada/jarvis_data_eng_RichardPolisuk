package ca.jrvs.practice.codingChallenge.c09;

// Given two strings s and goal, return true if and only if s can become goal
// after some number of shifts on s.
//
// A shift on s consists of moving the leftmost character of s to the rightmost position.
//
// Requirements: Simple Check (use String.contains)

/**
 * Big-O: O(n) Justification: Array will be processed n times
 */
public class RotateString {

  public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) { // Return false right away if not equal size
      return false;
    }
    int len = s.length();
    char b;
    String a = s;
    for (int i = 0; i < len - 1; i++) {
      b = a.charAt(0);
      String c = a.substring(1, len) + b;
      if (c.equals(goal)) {
        return true;
      }
      a = c;
    }
    return false;
  }
}
