package ca.jrvs.practice.codingChallenge;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.[

public class IsAnagram {

  // Requirements: Sorting
  public boolean isAnagram(String s, String t) {
    String ss = s.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    String tt = t.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    return ss.equals(tt);
  }

  // Time: O(N)
  // Space: O(1)
  public boolean isAnagramOn(String s, String t) {
    int[] map = new int[126];
    for (char c : s.toCharArray()) { // Count the letters
      map[c]++;
    }
    for (char c : t.toCharArray()) {
      map[c]--;
    }
    for (int i : map) { // Are they the same?
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
}
