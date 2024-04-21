package com.example.leetcode;

public class ZigZagConversion {

  public String zigzag(String s, int numRows) {

    if (s == null || s.length() == 0) {
      return "";
    }

    if (numRows == 1) {
      return s;
    }

    StringBuilder sb = new StringBuilder();

    int index = 0;

    while (index < s.length()) {
      sb.append(s.substring(index, index + numRows));
      for (int i = numRows - 2; i > 0; i--) {
        sb.append(s.charAt(index + numRows + i));
      }

      index = index + numRows;
    }

    return "";
  }

  public String[] changeDirection(String s) {

    String[] result = new String[s.length()];
    int index = 0;
    for (int i = 0; i < s.length(); i++) {
      result[index] = s.substring(i, i + 1);
      index++;
    }
    return result;
  }

  public String padding(String s, int numRows) {

    int arr[] = new int[] { numRows, numRows - 2 };

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i));
      if (i % numRows == 0) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  public String[] split(String s, int numRows) {

    int cycleLength = 2 * numRows - 2;
    int total = (s.length() / cycleLength) * (numRows - 1);
    int remainder = s.length() % cycleLength;
    if (remainder > 0) {
      total++;
    }
    if (remainder > numRows) {
      total++;
    }

    String[] result = new String[total];
    int index = 0;
    int i = 0;
    while (i < s.length()) {
      if (index % (numRows - 1) == 0) {
        System.out.println("-");
        result[index] = s.substring(i, Math.min(s.length(), i + numRows));
        i = i + numRows;
      } else {
        System.out.println(">>>" + index % (numRows - 1));
        result[index] = "*".repeat(numRows - index % (numRows - 1) - 1) + s.substring(i, Math.min(s.length(), i + 1)) + "*";
        i++;
      }
      if (i > s.length()) {
        break;
      }
      index++;
    }

    // for (int j = 0; j < result[0].length(); j++) {
    //     for (i = 0; i < result.length; i++) {
    //     System.out.print(result[i].charAt(j));
    //   }
    //   System.out.println("");
    // }
    return result;
  }

  public String[] changeDirection(String[] s) {
      
      String[] result = new String[s.length];
      for (int i = 0; i < s.length; i++) {
        result[i] = s[i].substring(i, i + 1);
      }
      return result;
  }

  public char[] transpose(String s) {
    char[] result = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      result[i] = s.charAt(i);
    }
    return result;
    
  }
}
