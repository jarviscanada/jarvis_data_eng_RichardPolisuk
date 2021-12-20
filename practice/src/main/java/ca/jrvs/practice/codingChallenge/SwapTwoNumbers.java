package ca.jrvs.practice.codingChallenge;

public class SwapTwoNumbers {

  int[] swapMath(int[] num) {
    num[0] += num[1];
    num[1] = num[0] - num[1];
    num[0] -= num[1];
    return num;
  }

  int[] swapBit(int[] num) {
    num[0] ^= num[1];
    num[1] = num[0] ^ num[1];
    num[0] ^= num[1];
    return num;
  }
}
