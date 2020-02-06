package DynamicProgramming;

import java.util.Scanner;

public class Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scn.nextInt();
		int amount = scn.nextInt();
		System.out.println(recursive(arr, amount, 0, 0));
		int[][] nums = new int[amount + 1][arr.length + 1];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++)
				nums[i][j] = -1;
		}
		System.out.println(memoization(arr, amount, 0, 0, nums));

	}

	public static int recursive(int[] arr, int amount, int sum, int index) {

		// base cases
		if (sum == amount)
			return 1;

		if (sum > amount || index == arr.length)
			return 0;

		int include = recursive(arr, amount, sum + arr[index], index);
		int not_include = recursive(arr, amount, sum, index + 1);

		return include + not_include;
	}

	public static int memoization(int[] arr, int amount, int sum, int index, int[][] dp) {

		// base cases
		if (sum == amount)
			return 1;

		if (sum > amount || index == arr.length)
			return 0;

		if (dp[sum][dp[0].length - index - 1] != -1)
			return dp[sum][dp[0].length - index - 1];

		int include = memoization(arr, amount, sum + arr[index], index, dp);
		int not_include = memoization(arr, amount, sum, index + 1, dp);
		dp[sum][dp[0].length - index - 1] = include + not_include;

		return include + not_include;

	}

}
