package ca.jrvs.practice.codingChallenge.c08;

public class IsPalindrome {

  //A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
  // and removing all non-alphanumeric characters, it reads the same forward and backward.
  // Alphanumeric characters include letters and numbers.
  //
  // Given a string s, return true if it is a palindrome, or false otherwise.

  // Recursion
  public boolean isPalindromeRecursion(String s) {
    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    if (s.length() == 0 || s.length() == 1) {
      return true;
    }
    if (s.charAt(0) == s.charAt(s.length() - 1)) {
      return isPalindromeRecursion(s.substring(1, s.length() - 1));
    }
    return false;
  }

  // Two pointers
  public boolean isPalindromeTwoPointers(String s) {
    if (s == null) {
      return false;
    }
    if (s.length() == 0) {
      return false;
    }

    // Replace with empty string except the pattern "[^a-zA-Z0-9]"
    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      // If current points are the same then move to the next ones
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
        continue;
      }
      // If not the same, then not a palindrome
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
