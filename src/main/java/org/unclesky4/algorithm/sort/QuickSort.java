package org.unclesky4.algorithm.sort;

/**
 * 
 * @author unclesky4
 *
 */
public class QuickSort {

	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * 
	 * @param numbers 待排序数组
	 * @param low     开始位置
	 * @param high    结束位置
	 * @return 中轴所在位置
	 */
	public static int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && numbers[high] > temp) {
				high--;
			}
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
			while (low < high && numbers[low] < temp) {
				low++;
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
		numbers[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	/**
	 * 递归形式的分治排序算法
	 * 
	 * @param numbers 带排序数组
	 * @param low     开始位置
	 * @param high    结束位置
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
			quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
			quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
		}

	}

	/**
	 * 快速排序
	 * 
	 * @param numbers 带排序数组
	 */
	public static void quick(int[] numbers) {
		if (numbers.length > 0) // 查看数组是否为空
		{
			quickSort(numbers, 0, numbers.length - 1);
		}
	}

}


/*
 * 
 * 
 * 分析：
	快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
	但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
	为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。
	快速排序是一个不稳定的排序方法。
*	
*	
*/


