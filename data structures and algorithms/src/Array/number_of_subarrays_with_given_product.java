package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class number_of_subarrays_with_given_product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scn.nextInt();

		int k = scn.nextInt();
		System.out.println(method1(arr, k));
	}

	// O(n^2)
	public static ArrayList<ArrayList<Integer>> method1(int[] arr, int k) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int prod = arr[i];
			if (prod == k) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i);
				l.add(i);
				list.add(l);
			}
			for (int j = i + 1; j < arr.length; j++) {
				prod *= arr[j];
				if (prod == k) {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					list.add(l);
				}
			}
		}
		return list;
	}

}
