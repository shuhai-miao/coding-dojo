package com.example.leetcode;

public class Palindrome {

	public String longestPalindrome2(String s) {
		String palindrome = longestPalindrome(s);
		String palindrome2 = longestPalindrome(new StringBuilder(s).reverse().toString());
		return palindrome.length() > palindrome2.length() ? palindrome : palindrome2;
	}

	public String longestPalindrome(String s) {

		if (s.length() <= 1)
			return s;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > i; j--) {
				int left = i;
				int right = j;
				while (s.charAt(left) == s.charAt(right) && (right - left > 1)) {
					left++;
					right--;
				}
				if (s.charAt(left) == s.charAt(right) && (left == right || left + 1 == right)) {
					return s.substring(i, j + 1);
				}
			}
		}
		return s.substring(0, 1);
	}

	public String longestPalindromeRecursive(String s) {
		if (s.length() <= 1) {
			return s;
		}
		String result = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > i; j--) {
				if (palindrome(s, i, j)) {
					String r = s.substring(i, j + 1);
					if (r.length() > result.length()) {
						result = r;
						break;
					}
				}
			}
		}
		return result;
	}

	public boolean palindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public boolean isPalindrome(int x) {

		if (x < 0)
			return false;
		char[] result = String.valueOf(x).toCharArray();
		int i = 0;
		do {
			if (result[i] != result[result.length - i - 1])
				return false;
		} while (i++ < result.length / 2);
		return true;
	}

}
