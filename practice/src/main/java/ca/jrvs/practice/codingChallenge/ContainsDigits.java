package ca.jrvs.practice.codingChallenge;

// Check if a String contains only digits

public class ContainsDigits {

  boolean containsDigitsASCII(String str) {
    for (int i = 0; i < str.length(); i++) {
      int ch = str.charAt(i);
      if (ch < 48 || ch > 57) {
        return false;
      }
    }
    return true;
  }

  // Use Java API (e.g Integer.valueOf)
  boolean containsDigitsValueOf(String str) {
    try {
      Integer.valueOf(str, 10);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  // Use regex
  boolean containsDigitRegEx(String str) {
    // The + means "one or more times" and \d means "a digit".
    return str.matches("\\d+");
  }

}
