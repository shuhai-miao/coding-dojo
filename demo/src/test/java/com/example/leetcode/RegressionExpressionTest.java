package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class RegressionExpressionTest {
  
  @Test
  public void testMatch() {

    RegularExpression re = new RegularExpression();
    assert re.match("", "") == true; 
    assert re.match("a", "") == false;

  }
}
