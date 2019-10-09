package org.unclesky4.algorithm.string;

public class KMP {
	
	/**
	* KMP算法.<br/>
	* 在目标字符串中对搜索词进行搜索。<br/>
	* 
	* @param t 目标字符串
	* @param p 搜索词
	* @return 搜索词第一次匹配到的起始位置或-1
	*/
	public static int kmp(String t, String p) {
	    char[] target = t.toCharArray();
	    char[] pattern = p.toCharArray();
	    // 目标字符串下标
	    int i = 0;
	    // 搜索词下标
	    int j = 0;
	    // 整体右移一位的部分匹配表
	    int[] next = getNext(p);

	    while (i < target.length && j < pattern.length) {
	        // j == -1 表示从搜索词最开始进行匹配
	        if (j == -1 || target[i] == pattern[j]) {
	            i++;
	            j++;
	        // 匹配失败时，查询“部分匹配表”，得到搜索词位置j以前的最大共同前后缀长度
	        // 将j移动到最大共同前后缀长度的后一位，然后再继续进行匹配
	        } else {
	            j = next[j];
	        }
	    }

	    // 搜索词每一位都能匹配成功，返回匹配的的起始位置
	    if (j == pattern.length)
	        return i - j;
	    else
	        return -1;
	}
	
	/**
	* 生成部分匹配表.<br/>
	* 生成搜索词的部分匹配表<br/>
	* 
	* @param p 搜索词
	* @return 部分匹配表
	*/
	private static int[] getNext(String pattern) {
	    char[] p = pattern.toCharArray();
	    int[] next = new int[p.length];
	  // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
	    next[0] = -1;
	    int i = 0;
	    int j = -1;

	    while(i < p.length - 1) {
	        if (j == -1 || p[i] == p[j]) {
	            i++;
	            j++;
	            next[i] = j;
	        } else {
	            j = next[j];
	        }
	    }

	    return next;
	}
	
	public static void main(String[] args) {
		int[] tmp = getNext("abcddab");
		for (int i : tmp) {
			System.out.print(i);
		}
		System.out.println();
		
		int index = kmp("abcddsfa", "fa");
		System.out.println(index);
	}

}

/**
 * https://www.jianshu.com/p/d4cf13b32111
 * https://wenku.baidu.com/view/8f0bba4bb9d528ea80c7790a.html
KMP算法是一种改进的字符串匹配算法,广泛应用于生物信息学、信息检索、拼写检查、语言翻译、数据压缩、网络入侵检测等领域.
KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。
具体实现就是通过一个next()函数实现，函数本身包含了模式串的局部匹配信息。KMP算法的时间复杂度O(m+n)。


KMP算法具体实现:
KMP算法的主体是，在失去匹配时，查询最后一个匹配字符所对应的“部分匹配表“中的值，然后向前移动，移动位数为：
移动位数 = 已匹配的字符数 - 对应的部分匹配值


部分匹配表(next数组)的生成:
https://wenku.baidu.com/view/8f0bba4bb9d528ea80c7790a.html
模式字符串的第一位(注意，不包括第0位)开始对自身进行匹配运算。 在任一位置，能匹配的最长长度就是当前位置的next值
*/
