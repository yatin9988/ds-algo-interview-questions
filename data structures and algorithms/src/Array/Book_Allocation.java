package Array;

import java.util.Scanner;

public class Book_Allocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test >= 1) {

			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();

			int lo = 0;
			int hi = 0;
			for (int val : arr)
				hi += val;

			int possible = 0;
			while (lo <= hi) {

				int mid = (lo + hi) / 2;
				if (isPossible(n, m, arr, mid)) {
					possible = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			System.out.println(possible);
			test--;
		}
	}

	public static boolean isPossible(int n, int m, int[] arr, int mid) {

		int student = 1;
		int i = 0;
		int pages = 0;

		while (i < arr.length) {

			if (pages + arr[i] <= mid) {
				pages += arr[i];
				i++;
			} else {
				student++;
				pages = 0;

				if (student > m)
					return false;
			}

		}
		return true;
	}

}
