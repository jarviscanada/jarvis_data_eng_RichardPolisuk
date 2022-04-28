package ca.jrvs.practice.codingChallenge.c18;

public class SwapTwoNumbers {

  public int[] swapMath(int[] num) {
    num[0] += num[1];
    num[1] = num[0] - num[1];
    num[0] -= num[1];
    return num;
  }

  public int[] swapBit(int[] num) {
    num[0] ^= num[1];
    num[1] = num[0] ^ num[1];
    num[0] ^= num[1];
    return num;
  }
}
