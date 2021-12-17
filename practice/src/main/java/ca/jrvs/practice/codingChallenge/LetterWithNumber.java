package ca.jrvs.practice.codingChallenge;

public class LetterWithNumber {

  // Given a String which contains only lower and upper case letters, print letter index
  // after each character. For example, the index of a is 1,  b is 2, A is 27, and so on.

  /**
   * Big-O: O(n) Justification: one n loops required
   */
  void PrintLetterWithNumber(String input) {
    System.out.println("input: " + input);
    System.out.print("output: ");
    for (int i = 0; i < input.length(); i++) {
      System.out.print(input.charAt(i));

      char currentChar = input.charAt(i);
      if ((int) currentChar >= 97) {
        System.out.print((int) currentChar - 96);
      } else {
        System.out.print((int) currentChar - 64 + 26);
      }
    }
  }
}
