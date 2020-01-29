package Array;

import java.util.HashSet;
import java.util.Scanner;

public class duplicate_element_in_a_limited_range_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		System.out.println(method1(arr));
		System.out.println(method2(arr));
		System.out.println(method3(arr));
		System.out.println(method4(arr));
		System.out.println(method5(arr));
		scn.close();
	}

	// O(n) - time
	// O(n) - space
	// hashing approach
	public static int method1(int[] arr) {

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i]))
				return arr[i];
			set.add(arr[i]);
		}
		return -1;

	}

	// O(n) - time
	// O(n) - space
	// array based approach
	public static int method2(int[] arr) {

		// by default an integer array is initialsed with 0
		int[] nums = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (nums[arr[i]] == 0)
				nums[arr[i]] += 1;
			else
				return arr[i];
		}
		return -1;
	}

	// O(n) - time
	// O(1) - space
	public static int method3(int[] arr) {

		int max = arr.length - 1;
		int unique = (max) * (max + 1) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum - unique;
	}

	// O(n)
	// O(1)
	public static int method4(int[] arr) {

		int x_array = 0;
		for (int i = 0; i < arr.length; i++)
			x_array ^= arr[i];

		int x_unique = 0;
		for (int i = 1; i < arr.length; i++)
			x_unique ^= i;

		return x_array ^ x_unique;

	}

	// O(n)
	// O(1)
	// will work only when the given elements are in the range 1 to n-1 and positive
	public static int method5(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] > 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				return Math.abs(arr[i]);
			}
		}	
		return -1;
	}

}
