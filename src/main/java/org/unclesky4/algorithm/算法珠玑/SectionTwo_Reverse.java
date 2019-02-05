package org.unclesky4.algorithm.算法珠玑;

/**
 * 将字符串向左移动n位
 * @author unclesky4
 *
 */
public class SectionTwo_Reverse {
	
	/**
	 * 翻转算法, 先将前n个翻转，再将余下的翻转，最后将整个翻转
	 * @param s
	 * @param num
	 */
	public static void reverse(String s, int num) {
		System.out.println(s);
		
		int begin = 0;
		int end = num - 1;
		char[] arr = s.toCharArray();
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		
		
		begin = num;
		end = s.length() - 1;
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		
		
		begin = 0;
		end = s.length() - 1;
		while(begin < end) {
			char temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}

		System.out.println(new String(arr));
}

	public static void main(String[] args) {
		String s = "bcdefgkmn";
		reverse(s, 4);
	}

}
