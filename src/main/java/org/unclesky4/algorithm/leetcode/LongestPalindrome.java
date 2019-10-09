package org.unclesky4.algorithm.leetcode;

public class LongestPalindrome {

	/*
	 * 方法四：中心扩展算法
	 * 
	 * 事实上，只需使用恒定的空间，我们就可以在 O(n^2) 的时间内解决这个问题。
	 * 
	 * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n−1个这样的中心。
	 * 
	 */
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			//System.out.println(start + "  " + end);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	/**
	 * Manacher算法(最大回文子串) 回文分为偶回文（比如 bccb）和奇回文（比如
	 * bcacb），而在处理奇偶问题上会比较繁琐，所以这里我们使用一个技巧， 具体做法是：在字符串首尾，及各字符间各插入一个字符（前提这个字符未出现在串里）
	 * https://www.jianshu.com/p/116aa58b7d81
	 * 
	 * manacher算法的思想是
	 * 1 把偶数、奇数长的字符序列变成奇数长度
	 * 2 创建一个与字符串等长的数组，用来记录字符序列相应位置上字符的最长回文半径，半径为1时默认为字符本身。
	 * 3 然后以每个字符为中轴遍历字符序列，之后求数组的最大值即为最大的半径，即为最长的回文半径。
	 * @param str
	 * @return
	 */
	public static String ManacherString(String str) {
		if (str == null || str.length() < 1) {
			return null;
		}
		String string = ManacherStrInit(str);
		char[] charArr = string.toCharArray();
		int[] radius = new int[charArr.length];  //回文半径数组radius,记录以每个位置的字符为回文中心求出的回文半径长度
		int R = -1;   //最右回文右边界R,一个位置最右回文右边界指的是这个位置及之前的位置的回文子串，所到达的最右边的地方
		int c = -1;   //最右回文右边界的对称中心C
		int max = 0;
		int index = 0;
		for (int i = 0; i < radius.length; i++) {
			
			radius[i] = R > i ? Math.min(radius[2 * c - i], R - i + 1) : 1;
			
			while (i + radius[i] < charArr.length && i - radius[i] > -1) {
				if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
					radius[i]++;
				} else {
					break;
				}
			}
			if (i + radius[i] > R) {
				R = i + radius[i] - 1;
				c = i;
			}
			max = Math.max(max, radius[i]);
			if (radius[i] >= max) {
				index = i;
			}
		}
		System.out.println("最长回文长度：" + (max - 1));
		return string.substring(index - max + 1, index + max).replace("#", "");
	}

	private static String ManacherStrInit(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append("#");
			sb.append(str.charAt(i));
		}
		sb.append("#");
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "babad";
		//System.out.println(longestPalindrome(str));
		System.out.println(ManacherString(str));
		
		str = "aaafffggggg";
		System.out.println(ManacherString(str));
	}

}

/*
 * 
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * 
 * 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 
 * 
 */
