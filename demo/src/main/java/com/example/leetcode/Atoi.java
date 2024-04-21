package com.example.leetcode;

public class Atoi {

  public int atoi(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }
    int result = 0;
    int index = 0;
    boolean isNegative = false;
    char c = ' ';
    for (; index < s.length(); index++) {
      c = s.charAt(index);
      if (!Character.isWhitespace(c)) {
        break;
      }
    }
    if (c == '+' || c == '-') {
      isNegative = c == '-';
      index++;
    }
    while (index < s.length()) {
      c = s.charAt(index++);
      if (!Character.isDigit(c)) {
        break;
      }
      int digit = c - '0';
      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result = result * 10 + digit;
    }

    return isNegative ? -result : result;
  }

}
