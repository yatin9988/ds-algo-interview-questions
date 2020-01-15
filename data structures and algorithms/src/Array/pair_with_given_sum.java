package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class pair_with_given_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		int sum = scn.nextInt();
		int[] a = method1(arr, sum);
		System.out.print(a[0] + " ");
		System.out.println(a[1]);
		int[] b = method3(arr, sum);
		System.out.print(b[0] + " ");
		System.out.println(b[1]);
		System.out.println(method2(arr, sum));
	}

	// O(n^2) brute force
	public static int[] method1(int[] arr, int sum) {

		int[] a = new int[2];
		for (int i = 0; i < arr.length; i++) {
			int s = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == sum - s) {
					a[0] = i;
					a[1] = j;
					break;
				}
			}
		}
		return a;
	}

	// O(n*log(n)) sorting
	public static boolean method2(int[] arr, int sum) {

		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (arr[low] + arr[high] == sum) {
				return true;
			} else if (arr[low] + arr[high] > sum)
				high--;
			else
				low++;
		}
		return false;
	}

	// O(n) hashing
	public static int[] method3(int[] arr, int sum) {

		int[] a = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(sum - arr[i])) {
				a[0] = map.get(sum - arr[i]);
				a[1] = i;
				break;
			}
			map.put(arr[i], i);
		}
		return a;
	}

}
