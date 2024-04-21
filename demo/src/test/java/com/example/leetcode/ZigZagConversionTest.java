package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class ZigZagConversionTest {

  @Test
  public void verticle() {

    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "abc";
    String[] result = zigZagConversion.changeDirection(s);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  @Test
  public void pad() {
    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "abcdef";
    String result = zigZagConversion.padding(s, 3);
    System.out.println(result);
    assert result.equals("abc d ef");
  }

  @Test
  public void split() {
    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "abcdefghijklmnopqrstuvwxyz123";
    String result = zigZagConversion.split(s, 3);
    System.out.println(result);
  }

  @Test
  public void split2() {
    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String s = "PAYPALISHIRING";
    String result = zigZagConversion.split(s, 9);
    System.out.println(result);
  }


  @Test
  public void divide() {
    String s = "abcdefghijk";
    int numRows = 3;
    assert s.length() == 11;
    int c = s.length() / numRows;
    int count = c + s.length() % numRows == 0 ? 0 : 1;
    System.out.println(count);
    assert count == 4;
  }
}
