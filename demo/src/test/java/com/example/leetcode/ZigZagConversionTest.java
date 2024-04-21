package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class ZigZagConversionTest {
  @Test
  public void split() {
    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "PAYPALISHIRING";
    String result = zigZagConversion.zigzag(s, 9);
    System.out.println(result);
  }

}
