package DynamicProgramming;

import java.util.Scanner;

public class Loot_Houses {

	static int val = 6;

	public static void main(String[] args) {
		
		int [][]arr = {{1,2,3},{4,5,6}};
		
		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int total = arr.length * arr[0].length;
		int count = 0;

		while (count < total) {

			// first col
			for (int r = minRow; r <= maxRow && count < total; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int c = minCol; c <= maxCol && count < total; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int r = maxRow; r >= minRow && count < total; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int c = maxCol; c >= minCol && count < total; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;

		}

		System.out.println();
	}

	public static void testcase(int m, int n) {
		int A = 1, H = 1;
		int c = 1;
		while (c > 0) {
			if (A > m) {
				System.out.println("Harshit");
				break;
			} else if (H > n) {
				System.out.println("Aayush");
				break;
			}
			A += 2;
			H += 2;
		}
	}

	public static void Swap(int one, int two) {
		int temp = one;
		one = two;
		two = temp;
	}

	public static int recursive(int sum, int[] arr, int index) {

		if (index >= arr.length)
			return sum;

		int sum1 = recursive(sum + arr[index], arr, index + 2);
		int sum2 = recursive(sum, arr, index + 1);

		return Math.max(sum1, sum2);
	}

	public static int memoization(int sum, int[] arr, int index, int[] memopad) {

		if (index >= arr.length)
			return sum;

		if (memopad[index] != 0)
			return memopad[index];
		int sum1 = memoization(sum + arr[index], arr, index + 2, memopad);
		int sum2 = memoization(sum, arr, index + 1, memopad);

		int max = Math.max(sum1, sum2);
		memopad[index] = max;
		return max;
	}

}
