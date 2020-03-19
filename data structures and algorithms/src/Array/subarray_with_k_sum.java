package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class subarray_with_k_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		int target = scn.nextInt();
		System.out.println(method1(arr, target));
		System.out.println(method2(arr, target));
		System.out.println(method2(arr, target));
	}

	// O(n^2) brute-force
	// search for all possible subarrays
	public static int method1(int[] arr, int target) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			int sum = arr[i];
			if (sum == target)
				count++;
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum == target) {
					count++;
				}
			}

		}
		return count;
	}

	// O(n)
	// hashing
	public static int method2(int[] arr, int target) {

		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		map.put(0, 1);
		for (int i : arr) {
			sum += i;
			if (map.containsKey(sum - target))
				count += map.get(sum - target);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	// O(n)
	public static int method3(int[] arr, int target) {

		int count = 0;
		int i = 0;
		int sum = 0;
		for (int j = 0; j < arr.length; j++) {

			sum += arr[j];
			if (sum < target)
				continue;

			while (sum > target) {
				sum = sum - arr[i];
				i++;
			}

			if (sum == target)
				count++;
		}
		return count;
	}

}