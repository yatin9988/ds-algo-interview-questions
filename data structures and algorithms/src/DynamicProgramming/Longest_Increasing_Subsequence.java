package DynamicProgramming;

import java.util.Scanner;

class pair {
	int max;
	int length;
}

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		System.out.println(recursive_approach(arr, 0).max);
		System.out.println(memoization(arr, 0, new pair[arr.length]).max);
		System.out.println(dp(arr));
		scn.close();
	}

	// time complexity??
	public static pair recursive_approach(int[] arr, int index) {

		if (index == arr.length - 1) {
			pair p = new pair();
			p.length = 1;
			p.max = 1;
			return p;
		}

		pair pp = new pair();
		int max = Integer.MIN_VALUE;
		pair p = null;
		int m = 0;
		for (int i = index + 1; i < arr.length; i++) {
			p = recursive_approach(arr, i);
			m = Math.max(p.max, m);
			if (arr[index] < arr[i])
				max = Math.max(max, p.length);
		}

		if (max == Integer.MIN_VALUE) {
			pp.length = 1;
			pp.max = Math.max(1, m);
			return pp;
		}

		pp.length = max + 1;
		pp.max = Math.max(m, pp.length);
		return pp;
	}

	public static pair memoization(int[] arr, int index, pair[] dp) {

		if (index == arr.length - 1) {
			pair p = new pair();
			p.length = 1;
			p.max = 1;
			dp[index] = p;
			return p;
		}

		int max = Integer.MIN_VALUE;
		pair pp = new pair();
		int m = 0;
		for (int i = index + 1; i < arr.length; i++) {
			if (dp[i] != null) {
				pair a = dp[i];
				m = Math.max(m, a.max);
				if (arr[index] < arr[i])
					max = Math.max(max, a.length);
			} else {
				pair b = memoization(arr, i, dp);
				m = Math.max(m, b.max);
				if (arr[index] < arr[i])
					max = Math.max(max, b.length);
			}
		}

		if (max == Integer.MIN_VALUE) {
			pp.length = 1;
			pp.max = Math.max(1, m);
			return pp;
		} else {
			pp.length = max + 1;
			pp.max = Math.max(pp.length, m);
		}
		dp[index] = pp;
		return pp;
	}

	public static int dp(int[] arr) {

		int[] nums = new int[arr.length];
		int m = 1;
		nums[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			int max = Integer.MIN_VALUE;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					max = Math.max(max, nums[j]);
				}
			}
			if (max != Integer.MIN_VALUE)
				nums[i] = max + 1;
			else {
				nums[i] = 1;
			}
			if (nums[i] > m)
				m = nums[i];
		}
		return m;
	}

}
