package org.unclesky4.algorithm.string;

/**
 * 最长公共子串问题 - 动态规划的解法
 * @author unclesky4 2019.10.09
 *
 */
public class LongestSubstring {
	
	public static int FindLongest(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
			System.err.println("参数不能为空");
			return -1;
		}
		int rs = 0;
		
		char[] str1_array = str1.toCharArray();
		int str1_length = str1_array.length;
		
		char[] str2_array = str2.toCharArray();
		int str2_length = str2_array.length;
		
		int[][] dp = new int[str1_length + 1][str2_length + 1];
		for (int i = 1; i < str1_length; i++) {
			for (int j = 1; j < str2_length; j++) {
				if (str1_array[i - 1] == str2_array[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					rs = Math.max(rs, dp[i][j]);
				}else {
					dp[i][j] = 0;
				}
			}
		}
		return rs;
	}

	public static void main(String[] args) {
		System.out.println(FindLongest("HelloWorld", "loop"));
	}

}

/**
给定两个字符串A和B，长度分别为m和n，要求找出它们最长的公共子串，并返回其长度。例如：

　　A = "HelloWorld"

　   B = "loop"

则A与B的最长公共子串为 "lo",返回的长度为2。

子序列和子串的区别：子序列和子串都是字符集合的子集，但是子序列不一定连续，但是子串一定是连续的
 */
