package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given an array of integers nums containing n + 1 integers where each integer is
// in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.
public class FindDuplicate {

  /**
   * Big-O: O(n log n) Justification: Sorting plus iteration
   */
  public int findDuplicateSorting(int[] nums) {
    Arrays.sort(nums); // Sort the array
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }
    return 0; // Not found, return 0
  }

  /**
   * Big-O: O(n) Justification: Process max n items
   */
  public int findDuplicateSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) { // Sets have to be unique, so returns false if it already exists
        return num;
      }
    }
    return 0; // Not found, return 0
  }

}
