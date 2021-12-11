package ca.jrvs.practice.codingChallenge;

// Given two strings s and goal, return true if and only if s can become goal
// after some number of shifts on s.
//
// A shift on s consists of moving the leftmost character of s to the rightmost position.
//
// Requirements: Simple Check (use String.contains)

public class RotateString {

  public static void main(String[] args) {
    RotateString rs = new RotateString();
    System.out.println(rs.rotateString("abcde", "cdeab"));
    System.out.println(rs.rotateString("abcde", "abced"));
  }

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
