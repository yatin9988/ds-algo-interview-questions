package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Aggressive_Cows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		Arrays.sort(arr);
		int lo = 0;
		int hi = arr[arr.length - 1] - arr[0];
		int ans = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;
			if (isPossible(n, c, arr, mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		System.out.println(ans);
	}

	public static boolean isPossible(int n, int c, int[] arr, int mid) {

		int cows = 1;
		int pos = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - pos >= mid) {
				cows++;
				pos = arr[i];

				if (c == cows)
					return true;
			}

		}
		return false;
	}

}
