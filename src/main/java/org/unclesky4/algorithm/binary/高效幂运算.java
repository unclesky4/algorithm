package org.unclesky4.algorithm.binary;

public class 高效幂运算 {

	// 拆分解法
	public static long pow0(long x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		// 偶数 相当于每次将x^n变为x^(n/2) * x^(n/2)
		if (n % 2 == 0) {
			return pow0(x * x, n / 2);
		} else {
			// 奇数 相当于每次将x^n变为x^((n-1)/2) * x^((n-1)/2) * x
			// 可以写成pow(x*x,n/2) 原因：(n-1)/2和n/2在Java中结果相同
			// 可以写成pow(x,n-1)*2 原因：通过提出一个x，使n变为奇数
			return pow0(x * x, (n - 1) / 2) * x;
		}
	}

	// 二进制解法
	@SuppressWarnings("unused")
	private static long pow(long x, int n) {
		long pow = 1;
		if (n == 0) {
			return 1;
		}
		while (n > 0) {
			if (n % 2 == 1) {
				pow *= x;
			}
			x *= x;
			n >>= 1;
		}
		return pow;
	}

}
