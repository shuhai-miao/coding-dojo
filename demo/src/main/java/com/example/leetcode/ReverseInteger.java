package com.example.leetcode;

public class ReverseInteger {

  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int y = x % 10;
      if (y == 0 && rev == 0) {
        // do nothing
      } else if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && y > 7)) {
        return 0;
      } else if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && y < -8)) {
        return 0;
      } else {
        rev = rev * 10 + y;
      }
      x = x / 10;
    }
    return rev;
  }

}
