package ca.jrvs.practice.codingChallenge;
/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages,
you must instead have the result be placed in the first part of the array nums. More formally,
if there are k elements after removing the duplicates, then the first k elements of nums
should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array
in-place with O(1) extra memory.
 */

/*
Test results:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
Memory Usage: 37.2 MB, less than 97.92% of Java online submissions for Remove Element.
 */

/**
 * ticket: https://www.notion.so/jarvisdev/Remove-Element-9c656ce5096a4677975d04053a557c9e
 */

public class RemoveElement {

  /**
   * Big-O: O(n) Justification: Array will be processed n times
   */
  public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }
}
