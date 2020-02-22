package Array;

import java.util.Scanner;

public class Painters_partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		int lo = 0;
		int hi = 0;
		for (int val : arr)
			hi += val;

		int ans = 0;
		while (lo <= hi) {

			int mid = (lo + hi) / 2;
			if (isPossible(n, k, arr, mid)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(ans);
	}

	public static boolean isPossible(int n, int k, int[] arr, int mid) {

		int painters = 1;
		int time = 0;
		int i = 0;
		while (i < arr.length) {

			if (arr[i] + time <= mid) {
				time += arr[i];
				i++;
			} else {
				painters++;
				time = 0;

				if (painters > k)
					return false;
			}

		}
		return true;

	}

}
