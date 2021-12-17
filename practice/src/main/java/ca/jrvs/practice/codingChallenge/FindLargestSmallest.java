package ca.jrvs.practice.codingChallenge;

// Find largest & smallest element in an array

import java.util.Arrays;
import java.util.Collections;

public class FindLargestSmallest {

  // Exact one for loop
  /**
   * Big-O: O(n) Justification: one n loop
   */
  public Integer[] findLargestSmallestOneLoop(Integer[] nums) {
    int smallest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE;

    for (int num : nums) {
      if (num < smallest) {
        smallest = num;
      }
      if (num > largest) {
        largest = num;
      }
    }
    return new Integer[]{smallest, largest};
  }

  // Use Stream APIs
  /**
   * Big-O: O(n) Justification: one n loop
   */
  public Integer[] findLargestSmallestStreams(Integer[] nums) {
    return new Integer[]{
        Arrays.stream(nums).reduce(0, Integer::min),
        Arrays.stream(nums).reduce(0, Integer::max)
    };
  }

  // Use Java built-in API (e.g. Collections.max)
  /**
   * Big-O: O(n) Justification: one n loop
   */
  public Integer[] findLargestSmallestCollections(Integer[] nums) {
    return new Integer[]{
        Collections.min(Arrays.asList(nums)),
        Collections.max(Arrays.asList(nums))
    };
  }

}
