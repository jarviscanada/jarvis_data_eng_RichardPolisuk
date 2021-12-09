package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Sample-Check-if-a-number-is-even-or-odd-e93e25bb7c5547debefe3a2f217fcd88
 */

public class OddEven {

  /**
   * Big-O: O(1) Justification: it's an arithmetic operation
   */
  public String oddEvenMod(int i) {
    return ((i % 2) == 0) ? "even" : "odd";
  }

  /**
   * Big-O: O(1) Justification: it's an arithmetic operation
   */
  public String oddEvenBit(int i) {
    // The bitwise ^ operator performs a bitwise exclusive OR operation.
    // The bitwise exclusive OR operator (^) compares each bit of its first operand to the
    // corresponding bit of its second operand. If the bit in one of the operands is 0 and
    // the bit in the other operand is 1, the corresponding result bit is set to 1.
    // Otherwise, the corresponding result bit is set to 0.
    //
    // 14      = 1110       | 21 = 010101      <= Example for i
    // 1       = 0001       | 1  = 000001
    // Bitwise = 1111 = 15  |    = 010101 = 21
    return (i ^ 1) == i + 1 ? "even" : "odd";
  }
}
