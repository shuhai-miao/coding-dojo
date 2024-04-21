package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class AtoiTest {
  
  @Test
  public void testAtoi() {

    Atoi atoi = new Atoi();

    assert atoi.atoi("  -42") == -42;
    assert atoi.atoi("4193 with words") == 4193;
    assert atoi.atoi(" -4193") == -4193;
    assert atoi.atoi("words and 987") == 0;
    assert atoi.atoi("words and -987") == 0;
    assert atoi.atoi("91283472332") == Integer.MAX_VALUE;
    assert atoi.atoi("-91283472332") == Integer.MIN_VALUE;
    assert atoi.atoi("0 ss ") == 0;
    assert atoi.atoi("") == 0;
    assert atoi.atoi("-") == 0;
    assert atoi.atoi(" ") == 0;

  }
}
