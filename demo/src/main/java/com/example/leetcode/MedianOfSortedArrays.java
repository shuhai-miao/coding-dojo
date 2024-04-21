package com.example.leetcode;

public class MedianOfSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int left = 0, right = 0, index = 0;
    int key = (nums1.length + nums2.length) / 2;
    int key1 = 0, key2 = 0;
    if ((nums1.length + nums2.length) % 2 == 0) {
      key1 = key - 1;
      key2 = key;
    } else {
      key1 = key;
      key2 = key;
    }
    int a = 0, b = 0;
    while (index <= key) {
      if (left >= nums1.length || nums1[left] > nums2[right]) {
        if (index == key1)
          a = nums2[right];
        if (index == key2)
          b = nums2[right];
        right++;
      } else if (right >= nums2.length || nums1[left] <= nums2[right]) {
        if (index == key1)
          a = nums1[left];
        if (index == key2)
          b = nums1[left];
        left++;
      }
      index++;
    }
    return (a + b) / 2.0;
  }
}
