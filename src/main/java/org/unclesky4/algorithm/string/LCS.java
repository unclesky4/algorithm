package org.unclesky4.algorithm.string;

/**
 * 最长公共子序列问题
 * @author unclesky4 2019.10.09
 *
 */
public class LCS {
	
	/**
	 * 找出最长公共子序列 - 动态规划的解法
	 * @param str1
	 * @param str2
	 */
	public static int FindLCS(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
			System.err.println("参数不能为空");
			return -1;
		}
		
		char[] str1_array = str1.toCharArray();
		char[] str2_array = str2.toCharArray();
		
		int str1_length = str1_array.length;
		int str2_length = str2_array.length;
		int[][] dp = new int[str1_length + 1][str2_length + 1];  //定义状态数组
		
		for (int i = 1; i <= str1_length; i++) {
			for (int j = 1; j <= str2_length; j++) {
				if(str1_array[i - 1] == str2_array[j - 1]) {  //判断str1的第i个字符和str2的第j个字符是否相同
                    dp[i][j] = dp[i - 1][j - 1] + 1;
				}
                else {
                	dp[i][j] = Math.max(dp[i - 1][j],dp[i][j  - 1]);
                }
			}
		}
		return dp[str1_length][str2_length];
	}

	public static void main(String[] args) {
		System.out.println(FindLCS("Hello World","loop"));
	}
}
/**
给定两个字符串A和B，长度分别为m和n，要求找出它们最长的公共子序列，并返回其长度。例如：

　　A = "HelloWorld"

　   B = "loop"

则A与B的最长公共子序列为 "loo",返回的长度为3。
 */
