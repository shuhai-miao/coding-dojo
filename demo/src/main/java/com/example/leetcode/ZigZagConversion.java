package com.example.leetcode;

public class ZigZagConversion {

  public String zigzag(String s, int numRows) {

    if (numRows == 1)
      return s;

    int cycleLength = 2 * numRows - 2;
    int fullCycles = s.length() / cycleLength;
    int remainder = s.length() % cycleLength;

    int total = fullCycles * (numRows - 1);
    if (remainder > 0) {
      total += remainder / numRows + remainder % numRows;
    }

    char[][] result = new char[total][numRows];
    int index = 0;
    int i = 0;
    while (i < s.length()) {
      if (index % (numRows - 1) == 0) {
        result[index] = s.substring(i, Math.min(s.length(), i + numRows)).toCharArray();
        i = i + numRows;
      } else {
        result[index][numRows - index % (numRows - 1) - 1] = s.charAt(i);
        i++;
      }
      if (i > s.length()) {
        break;
      }
      index++;
    }

    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < result[0].length; j++) {
      for (i = 0; i < result.length; i++) {
        if (j >= result[i].length) {
          continue;
        }
        if (result[i][j] != 0)
          sb.append(result[i][j]);
      }
    }

    return sb.toString();
  }

}
