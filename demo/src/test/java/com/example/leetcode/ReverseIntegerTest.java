package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {
  
  @Test
  public void testReverse() {
    ReverseInteger reverseInteger = new ReverseInteger();
    int result = reverseInteger.reverse(1534236469);
    System.out.println(result);
    assert result == 0;
  }

  @Test
  public void testReverse2() {

    int min = -2147483648;
    int max = 2147483647;

    int min_1 = (min - 1) / 10;
    int max_1 = (max + 1) / 10;

    System.out.println(min_1);
    System.out.println(max_1);

  }
}
