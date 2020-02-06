package DynamicProgramming;

import java.util.Scanner;

public class Min_Cost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int columns = scn.nextInt();
		int[][] arr = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				arr[i][j] = scn.nextInt();
		}
		System.out.println(recursive(arr, 0, 0));
		System.out.println(memoization(arr, 0, 0, new int[rows][columns]));
		System.out.println(iterative(arr));
	}

	// since there are 3 calls in every function
	// O(3^n)
	public static int recursive(int[][] arr, int i, int j) {

		// negative base case
		if (i >= arr.length || j >= arr[0].length)
			return Integer.MAX_VALUE;

		// positive base case
		if (i == arr.length - 1 && j == arr[0].length - 1)
			return arr[i][j];

		int first = recursive(arr, i, j + 1);
		int second = recursive(arr, i + 1, j + 1);
		int third = recursive(arr, i + 1, j);
		int min = Math.min(first, Math.min(second, third));
		return min + arr[i][j];
	}

	// O(n^2)
	public static int memoization(int[][] arr, int i, int j, int[][] dp) {

		// negative base cases
		if (i >= arr.length || j >= arr[0].length)
			return Integer.MAX_VALUE;

		// positive base cases
		if (i == arr.length - 1 && j == arr[0].length - 1)
			return arr[i][j];

		// if already visited
		if (dp[i][j] != 0)
			return dp[i][j];

		int first = memoization(arr, i + 1, j, dp);
		int second = memoization(arr, i + 1, j + 1, dp);
		int third = memoization(arr, i, j + 1, dp);

		int min = Math.min(first, Math.min(second, third));
		dp[i][j] = min + arr[i][j];

		return dp[i][j];
	}

	// O(n^2)
	// iterative
	public static int iterative(int[][] arr) {

		int[][] dp = new int[arr.length][arr[0].length];
		dp[dp.length - 1][dp[0].length - 1] = arr[arr.length - 1][arr[0].length - 1];
		for (int i = dp.length - 2; i >= 0; i--)
			dp[i][dp[0].length - 1] = arr[i][arr[0].length - 1] + dp[i + 1][dp[0].length - 1];

		for (int j = dp[0].length - 2; j >= 0; j--) {
			dp[dp.length - 1][j] = arr[dp.length - 1][j] + dp[dp.length-1][j + 1];
		}

		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j]));
			}
		}
		return dp[0][0];
	}

}
