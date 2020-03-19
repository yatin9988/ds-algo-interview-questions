package DynamicProgramming;

import java.util.Scanner;

public class Making_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scn.nextInt();
		int target = scn.nextInt();
		int coins = minimum(arr, 0, 0, target, 0);
		if (coins != Integer.MAX_VALUE) {
			System.out.println(coins);
		} else
			System.out.println(-1);
	}

	public static int minimum(int[] arr, int sum, int idx, int target, int coins) {

		if (sum == target)
			return coins;

		if (idx == arr.length)
			return Integer.MAX_VALUE;

		int min1 = minimum(arr, sum + arr[idx], idx + 1, target, coins + 1);
		int min2 = minimum(arr, sum, idx + 1, target, coins);

		return Math.min(min1, min2);
	}

}
