package com.dalai.par;

//9. Palindrome Number
public class PalindromeNumber {

	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 * ÅĞ¶Ï»ØÎÄÊı
	 */
	public boolean isPalindrome(int x) {

		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;

		int palidrome = 0;
		while (x > palidrome) {
			palidrome = palidrome * 10 + x % 10;
			x /= 10;
		}

		return (x == palidrome || x == palidrome / 10);
	}

	public static void main(String[] args) {

		System.out.println(new PalindromeNumber().isPalindrome(123));

	}

}
