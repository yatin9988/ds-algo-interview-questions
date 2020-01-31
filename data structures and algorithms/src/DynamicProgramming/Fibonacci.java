package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int fibo = scn.nextInt();
//		System.out.println(fibo_recursive(fibo));
		System.out.println(fibo_dp1(fibo, new int[fibo + 1]));
		System.out.println(fibo_dp2(fibo));
	}

	public static int fibo_recursive(int fibo) {

		if (fibo == 0 || fibo == 1)
			return 1;

		return fibo_recursive(fibo - 1) + fibo_recursive(fibo - 2);
	}

	public static int fibo_dp1(int fibo, int[] arr) {

		if (fibo == 0 || fibo == 1)
			return 1;

		// means already calculated so return
		if (arr[fibo] != 0) {
			return arr[fibo];
		}

		// if not calculated then calculate and before returning store then return
		int ans = fibo_dp1(fibo - 1, arr) + fibo_dp1(fibo - 2, arr);
		arr[fibo] = ans;
		return ans;

	}

	public static int fibo_dp2(int fibo) {

		int[] arr = new int[fibo + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= fibo; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[fibo];
	}

}
