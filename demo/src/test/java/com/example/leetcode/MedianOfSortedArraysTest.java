package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class MedianOfSortedArraysTest {
  
  @Test
  public void testFindMedianSortedArrays() {
    MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
    // assert medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
    // assert medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5;
    // assert medianOfSortedArrays.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}) == 0.0;
    assert medianOfSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{1}) == 1.0;
    assert medianOfSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{}) == 2.0;
  }
}
