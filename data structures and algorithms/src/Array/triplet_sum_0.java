package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class triplet_sum_0 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		int target = 0;
		ArrayList<ArrayList<Integer>> l1 = method1(arr, target);
		System.out.println(l1);

		ArrayList<ArrayList<Integer>> l2 = method2(arr, target);
		System.out.println(l2);

		ArrayList<ArrayList<Integer>> l3 = method3(arr, target);
		System.out.println(l3);
	}

	// O(n^3) brute force
	public static ArrayList<ArrayList<Integer>> method1(int[] arr, int target) {

		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {

					if (arr[i] + arr[j] + arr[k] == target) {
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(arr[i]);
						l.add(arr[j]);
						l.add(arr[k]);
						Collections.sort(l);
						if (!set.contains(l)) {
							list.add(l);
							set.add(l);
						}

					}
				}
			}

		}
		return list;
	}

	// O(n^2) hashing
	public static ArrayList<ArrayList<Integer>> method2(int[] arr, int target) {

		HashSet<ArrayList<Integer>> ans = new HashSet<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(-arr[i] - arr[j])) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(arr[i]);
					l.add(arr[j]);
					l.add(-arr[i] - arr[j]);
					Collections.sort(l);
					if (!ans.contains(l))
						list.add(l);
					ans.add(l);
				}
				set.add(arr[j]);
			}
		}
		return list;
	}

	// O(n^2) sorting
	public static ArrayList<ArrayList<Integer>> method3(int[] arr, int target) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {

			while (i > 0 && i < arr.length && arr[i] == arr[i - 1]) {
				i++;
			}

			// if the number is too small
			if (arr[i] + 2 * arr[arr.length - 1] < 0)
				continue;

			// if the number is too big
			if (3 * arr[i] > 0)
				continue;

			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {

				if (arr[i] + arr[left] + arr[right] == target) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(arr[i]);
					l.add(arr[left]);
					l.add(arr[right]);
					ans.add(l);
					left++;
					right--;
					while ((left < right) && arr[left] == arr[left - 1])
						left++;
					while ((left < right) && arr[right] == arr[right + 1])
						right--;
				}

				else if (arr[i] + arr[left] + arr[right] > 0)
					right--;
				else
					left++;

			}

		}

		return ans;

	}
}
