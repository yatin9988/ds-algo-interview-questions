package DynamicProgramming;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		System.out.println(recursive(n, 0));
		System.out.println(memoization(n, 0, new int[n + 1]));
		System.out.println(dp(n));
	}

	public static int recursive(int n, int step) {

		// base case
		if (step == n)
			return 1;

		if (step > n)
			return 0;

		int step1 = recursive(n, step + 1);
		int step2 = recursive(n, step + 2);
		return step1 + step2;
	}

	public static int memoization(int n, int step, int[] dp) {
		// base case
		if (step == n)
			return 1;

		if (step > n)
			return 0;

		if (dp[step] != 0)
			return dp[step];

		int step1 = memoization(n, step + 1, dp);
		int step2 = memoization(n, step + 2, dp);
		dp[step] = step1 + step2;
		return step1 + step2;
	}

	public static int dp(int n) {
		int[] arr = new int[n + 2];
		arr[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			arr[i] = arr[i + 1] + arr[i + 2];
		}
		return arr[0];
	}

}
