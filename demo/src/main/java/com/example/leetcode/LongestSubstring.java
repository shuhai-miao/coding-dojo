package com.example.leetcode;

public class LongestSubstring {

  public int lengthOfLongestSubstring(String s) {

    if (s.length() == 0 || s.length() == 1)
      return s.length();

    int left = 0, right = 0, len = 0;
    while (++right < s.length()) {
      int index = findSame(s, left, right);
      if (index != -1) {
        len = Math.max(len, right - left);
        left = index + 1;
      }
    }
    return Math.max(len, right - left);
  }

  public int hasDuplicate(String s, int left, int right) {
    if (left == right)
      return -1;
    int[] chars = new int[128];
    for (int i = left; i <= right; i++) {
      if (chars[s.charAt(i)] == 1) {
        return i;
      }
      chars[s.charAt(i)] = 1;
    }
    return -1;
  }

  public int findSame(String s, int left, int right) {
    if (left == right)
      return -1;
    for (int i = left; i < right; i++) {
      if (s.charAt(i) == s.charAt(right)) {
        return i;
      }
    }
    return -1;
  }

}
