package ca.jrvs.practice.codingChallenge;

// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
// such that each unique element appears only once. The relative order of the elements should
// be kept the same.
//
// Since it is impossible to change the length of the array in some languages,
// you must instead have the result be placed in the first part of the array nums.
// More formally, if there are k elements after removing the duplicates, then the first k
// elements of nums should hold the final result. It does not matter what you leave beyond
// the first k elements.
//
// Return k after placing the final result in the first k slots of nums.
public class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    int unique = 0; // First pointer
    int duplicate = 1; // Second pointer
    int count = 1;

    if (nums.length == 1) {
      return 1;
    }

    while (duplicate < nums.length) {
      if (nums[unique] == nums[duplicate]) {
        duplicate++;
      } else {
        nums[++unique] = nums[duplicate];
        count++;
      }
    }

    return count;
  }

}
