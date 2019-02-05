package org.unclesky4.algorithm.算法珠玑;

/**
 * 大量数字排序，内存不足
 * 
 * @author unclesky4
 *
 */
public class SectionOne_Sort {

	/**
	 * 排序实现一：多趟读取，每趟读取一定范围内的数排序
	 * 
	 * @param unsort 未排序数组
	 */
	public static void multiSort(int[] unsort) {
		int tag = 3000;
		while (tag <= 10000) {
			int[] readNum = new int[10000];
			
			for (int i = 0; i < unsort.length; i++) {
				int min = tag - 2000;
				if (unsort[i] != 0) {
					if (unsort[i] >= min && unsort[i] < tag) { //读取一定范围的数字
						readNum[i] = unsort[i];
					}
				}
			}

			//对这个范围的数字排序，快排
			quickSort(readNum, 0, readNum.length - 1);

			for (int i = 0; i < readNum.length; i++) {
				if(readNum[i] != 0)
					System.out.println(readNum[i]);
			}

			// 更改边界
			tag += 2000;
		}
	}

	// 快速排序实现
	public static void quickSort(int[] readNum, int low, int high) {
		if (low < high) {
			int p = sort(readNum, low, high);
			quickSort(readNum, low, p - 1);
			quickSort(readNum, p + 1, high);
		}
	}

	public static int sort(int[] readNum, int low, int high) {
		int num = readNum[low];
		while (low < high) {
			while (low < high && readNum[high] >= num)
				high--;
			readNum[low] = readNum[high];
			while (low < high && readNum[low] <= num)
				low++;
			readNum[high] = readNum[low];
		}
		readNum[low] = num;
		return low;
	}

	/*
	 * 排序实现二：用字节数组，如果有数字n，则将数组第n位设为1，效率比上面的方法高很多
	 */

	public static void charSort(int[] unsort) {
		char[] sort = new char[10000];
		for (int i = 0; i < sort.length; i++) // 初始化数组
			sort[i] = 0;

		for (int i = 0; i < unsort.length; i++) { // 如果数字n出现，则将数组第n位设为1
			if (unsort[i] != 0) {
				sort[unsort[i]] = 1;
			}
		}

		for (int i = 0; i < sort.length; i++) {
			if (sort[i] != 0)
				System.out.println(i);
		}
	}
	
	
	
	

	public static void main(String[] args) {
		int[] unsort = new int[10000]; // 待排序数组
		int count = (int) (Math.random() * 9000) + 1000; // 随机数字数量从1000到10000
		
		System.out.println("数组长度：  "+count);
		

		// 初始化数组
		for (int i = 0; i < count; i++) {
			int num = (int) (Math.random() * 9000) + 1000;
			unsort[i] = num;
		}

		multiSort(unsort);
		//charSort(unsort);
	}

}
