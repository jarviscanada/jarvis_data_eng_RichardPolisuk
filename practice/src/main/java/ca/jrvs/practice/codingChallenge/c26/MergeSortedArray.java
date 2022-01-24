package ca.jrvs.practice.codingChallenge.c26;

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and
// two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
// The final sorted array should not be returned by the function, but instead be stored inside
// the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
// denote the elements that should be merged, and the last n elements are set to 0 and should
// be ignored. nums2 has a length of n.

import java.util.Arrays;

public class MergeSortedArray {

  public void merge(int[] nums1, final int m, int[] nums2, final int n) {
    if (n >= 1 && m + n >= 1) {
      int j = 0;
      for (int i = m; i < m + n; i++) {
        nums1[i] = nums2[j];
        j++;
      }
      Arrays.sort(nums1);
    } else if (m == 0) {
      System.arraycopy(nums2, 0, nums1, 0, n);
    }
  }

}
