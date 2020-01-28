package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Buying_Plots_minimum_length_subarray_with_sum_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		int k = scn.nextInt();
		long start1 = System.currentTimeMillis();
		System.out.println(method1(arr, k));
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
		long start2 = System.currentTimeMillis();
		System.out.println(method2(arr, k));
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);

	}

	// O(n) - memory
	// O(n) - time
	public static ArrayList<Integer> method1(int[] arr, int k) {

		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				int length = i - (map.get(sum - k) + 1);
				if (length < min) {
					min = length;
					start = map.get(sum - k) + 1;
					end = i;
				}
			}
			map.put(sum, i);
		}
		list.add(start);
		list.add(end);
		return list;

	}

	// O(n) - time
	// O(1) - space
	// assuming the answer always exits
	public static ArrayList<Integer> method2(int[] arr, int k) {

		int i = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int start = 0;
		int end = 0;

		for (int j = 0; j < arr.length; j++) {

			sum += arr[j];
			if (sum < k)
				continue;

			while (sum > k) {

				sum = sum - arr[i];
				i++;

			}

			if (sum == k) {
				int length = j - i + 1;
				if (length < min) {
					min = length;
					start = i;
					end = j;
				}
			}

		}

		list.add(start);
		list.add(end);
		return list;
	}

}
