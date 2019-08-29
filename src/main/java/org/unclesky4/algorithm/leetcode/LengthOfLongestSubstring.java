package org.unclesky4.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	/*
	 * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
	 * 当我们找到重复的字符时，我们可以立即跳过该窗口。
	 * 
	 * 也就是说，如果 s[j]在 [i,j)范围内有与 j′重复的字符，我们不需要逐渐增加 i 。
	 * 我们可以直接跳过 [i,j′] 范围内的所有元素，并将 i变为 j′+1。
	 * 
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (n-i < ans) {
				return ans;
			}
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i) + 1;
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j);
		}
		return ans;
	}

	/*
	 * 以前的我们都没有对字符串 s 所使用的字符集进行假设。
	 * 
	 * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
	 * 
	 * 常用的表如下所示：
	 * 
	 * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’ 
	 * int [128] 用于ASCII码 
	 * int [256] 用于扩展ASCII码
	 */
	public static int lengthOfLongestSubstring_0(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(lengthOfLongestSubstring_0(str));
	}

}

/*
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-
 * characters
 * 
 */