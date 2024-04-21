package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class PalindromeTest {
  
  @Test
  public void longestPalindromeTest() {
    Palindrome palindrome = new Palindrome();
    assert palindrome.longestPalindrome("babad").equals("bab") || palindrome.longestPalindrome("babad").equals("aba");
    assert palindrome.longestPalindrome("cbbd").equals("bb");
    assert palindrome.longestPalindrome("a").equals("a");
    assert palindrome.longestPalindrome("ac").equals("a");
  }

  @Test
  public void longestPalindromeTest2() {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.longestPalindrome2("aaba"));
    assert palindrome.longestPalindrome2("aaba").equals("aba");
  }

  @Test
  public void longestPalindromeRecursiveTest() {
    Palindrome palindrome = new Palindrome();
    //aacabdkacaa
    assert palindrome.longestPalindromeRecursive("aacabdkacaa").equals("aca");
    assert palindrome.longestPalindromeRecursive("babad").equals("bab") || palindrome.longestPalindromeRecursive("babad").equals("aba");
    assert palindrome.longestPalindromeRecursive("cbbd").equals("bb");
    assert palindrome.longestPalindromeRecursive("a").equals("a");
    assert palindrome.longestPalindromeRecursive("ac").equals("a");
  }
}
