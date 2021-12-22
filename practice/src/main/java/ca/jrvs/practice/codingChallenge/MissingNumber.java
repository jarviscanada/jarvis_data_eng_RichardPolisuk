package ca.jrvs.practice.codingChallenge;

// Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingNumber {

  /**
   * Big-O: O(n * n) Justification: two n loops required
   */
  public int missingNumberSum(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i <= n; i++) {
      sum = sum + i;
    }
    int actualSum = IntStream.of(nums).sum();
    return sum - actualSum;
  }

  /**
   * Big-O: O(n * n) Justification: two n loops required
   */
  public int missingNumberSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int j = 0; j < nums.length + 1; j++) {
      if (set.add(j)) {
        return j;
      }
    }
    return 0;
  }

  /**
   * Big-O: O(n) Justification: one n loops required
   */
  public int missingNumberGauss(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int gaussSum = n * (n + 1) / 2;
    int actualSum = IntStream.of(nums).sum();
    return gaussSum - actualSum;
  }
}
