package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class LongestSubstringTest {
  
  @Test
  public void testLengthOfLongestSubstring() {
    LongestSubstring longestSubstring = new LongestSubstring();
    assert longestSubstring.lengthOfLongestSubstring("abcabcbb") == 3;
    assert longestSubstring.lengthOfLongestSubstring("dvdf") == 3;
    assert longestSubstring.lengthOfLongestSubstring("bbbbb") == 1;
    assert longestSubstring.lengthOfLongestSubstring("pwwkew") == 3;
    assert longestSubstring.lengthOfLongestSubstring("") == 0;
    assert longestSubstring.lengthOfLongestSubstring(" ") == 1;
    assert longestSubstring.lengthOfLongestSubstring("a") == 1;
  }

  @Test
  public void test2() {
    LongestSubstring longestSubstring = new LongestSubstring();
    assert longestSubstring.lengthOfLongestSubstring("bbb") == 1;
  }
}
