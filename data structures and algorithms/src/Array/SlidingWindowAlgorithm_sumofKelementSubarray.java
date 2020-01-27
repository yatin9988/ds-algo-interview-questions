package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class SlidingWindowAlgorithm_sumofKelementSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		int k = scn.nextInt();

		System.out.println(method1(arr, k));
		System.out.println(method2(arr, k));
	}

	// O(n*k)
	public static ArrayList<Integer> method1(int[] arr, int k) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= arr.length - k; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += arr[i + j];
			}
			list.add(sum);
		}
		return list;
	}

	// O(n)
	public static ArrayList<Integer> method2(int[] arr, int k) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		if (arr.length < 3)
			return list;
		int sum = arr[0] + arr[1] + arr[2];
		list.add(sum);
		for (int i = 1; i <= arr.length - k; i++) {
			sum = sum - arr[i - 1] + arr[i + k - 1];
			list.add(sum);
		}
		return list;
	}

}
