package com.dalai.par;

import javax.naming.InsufficientResourcesException;

//29. Divide Two Integers
public class DivideTwoIntegers {

	/*
	 * Divide two integers without using multiplication, division and mod operator.
	 * 
	 * If it is overflow, return MAX_INT.
	 * 
	 */
	public int divide(int dividend, int divisor) {

		if (divisor == 0)
			return 0;
		int sign = 1;

		if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
			sign = -1;

		long dividendL = Math.abs((long) dividend);
		long divisorL = Math.abs((long) divisor);

		long lans = divideL(dividendL, divisorL);

		if (lans > Integer.MAX_VALUE) {
			return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			if (sign == 1) {
				return (int) lans;
			} else {
				return (int) -lans;
			}
		}
	}

	private long divideL(long dividendL, long divisorL) {

		// ตÝน้
		if (dividendL < divisorL)
			return 0;

		long multiple = 1;
		long sum = divisorL;
		while ((sum + sum) <= dividendL) {
			sum += sum;
			multiple += multiple;
		}

		return multiple + divideL(dividendL - sum, divisorL);
	}

	public static void main(String[] args) {

	}

}
