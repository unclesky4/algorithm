package org.unclesky4.algorithm.binary;

/**
 * 
 *	AND 运算符（ &）
 *	OR 运算符（ |）
 *	XOR（ ^，异或）
 *	~ NOT非运算符
 * @author unclesky4
 *
 */
public class Binnary_1 {

	// 判断int型变量a是奇数还是偶数
	public static String judgeNum(int num) {
		return ((num & 1) == 0) ? "偶數" : "奇數";
	}

	// 求平均值
	public static int averageValue(int x, int y) {
		return (x & y) + ((x ^ y) >> 1);
	}
	
	//有两个int类型变量x、y,要求两者数字交换
	public static void exchangeNum(int x, int y) {
		x ^= y;
	    y ^= x;
	    x ^= y; 
	}
	
	//求绝对值 
	public static int abs(int x) {
		int y;
		y = x >> 31;
		return (x ^ y) - y; // or: (x+y)^y
	}
	
	//判斷是否可以被2整除
	public static boolean judgeDelivery(int num) {
		return (num & 1) == 1 ? false: true;
	}

	//求相反数
	public static int reverse(int x) {
		return (~x+1);
	}
	
	//求解正数的二进制表示法中的 1 的位数
	public static int countBit(int num) {
		int count = 0;
		for (; num > 0; count++) {
			num &= (num - 1);
		}
		return count;
	}
	
	//判断一个数是不是2的整数次方
	/* 思路：如果一个数是2的整数次方，那么这个数的二进制表示中有且仅有一位为1. 
	 * (n-1)&n那么这个数唯一的一个1就会变为0；(n-1)&n==0 就是2的整数次方。
	*/
	public static boolean judgePowForTwo(int n){
		return ((n-1)&n)==0 ? true: false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(countBit(56));
	}

}



/**
6.  取模运算，采用位运算实现：
 	a % (2^n) 等价于 a & (2^n - 1)
7.  乘法运算   采用位运算实现
     a * (2^n) 等价于 a << n
8.   除法运算转化成位运算
      a / (2^n) 等价于 a>> n
9.   求相反数
      (~x+1)
10  a % 2 等价于 a & 1 
*/
