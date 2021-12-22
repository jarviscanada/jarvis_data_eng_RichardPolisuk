package ca.jrvs.practice.codingChallenge;

// Given an array of integers nums and an integer target, return indices of the two numbers such
// that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use
// the same element twice.

// You can return the answer in any order.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  // Brute force (two loop)
  public int[] twoSumBrute(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  // O(n)
  public int[] twoSumBruteOn(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    // Process the array of numbers
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i]; // Determine what we are looking for
      if (map.containsKey(diff)) { // Is this number in the existing map?
        return new int[]{map.get(diff), i};
      } else {
        map.put(nums[i], i); // Store it into the map for next run
      }
    }
    return null;
  }
}
