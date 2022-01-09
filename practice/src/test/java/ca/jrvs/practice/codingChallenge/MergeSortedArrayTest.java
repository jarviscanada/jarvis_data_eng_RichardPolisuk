package ca.jrvs.practice.codingChallenge;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MergeSortedArrayTest {

  @Test
  public void merge() {
    MergeSortedArray msa = new MergeSortedArray();
    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = new int[]{2, 5, 6};
    int n = 3;

    int[] expected = new int[]{1, 2, 2, 3, 5, 6};
    msa.merge(nums1, m, nums2, n);

    Assert.assertArrayEquals(expected, nums1);
  }
}