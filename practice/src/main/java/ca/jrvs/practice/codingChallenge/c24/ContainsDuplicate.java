package ca.jrvs.practice.codingChallenge.c24;

// Given an integer array nums, return true if any value appears at least twice in
// the array, and return false if every element is distinct.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  /**
   * Big-O: O(n log n) Justification: Sorting plus iteration
   */
  public boolean containsDuplicateSorting(int[] nums) {
    Arrays.sort(nums); // Sort the array
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Big-O: O(n) Justification: Process max n items
   */
  public boolean containsDuplicateSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) { // Sets have to be unique, so returns false if it already exists
        return true;
      }
    }
    return false;
  }
}
