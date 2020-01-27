package Array;

import java.util.ArrayList;
import java.util.HashMap;
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
		System.out.println(method2(arr, k));
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

	// O(n)
	// hashing
	public static ArrayList<ArrayList<Integer>> method2(int[] arr, int k) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int prod = 1;
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(-1);
		map.put(1, l);
		for (int i = 0; i < arr.length; i++) {
			prod *= arr[i];
			if (map.containsKey(prod / k)) {
				ArrayList<Integer> ll = map.get(prod / k);
				for (int index : ll) {
					ArrayList<Integer> lll = new ArrayList<Integer>();
					lll.add(index + 1);
					lll.add(i);
					list.add(lll);
				}

			}

			if (map.containsKey(prod)) {
				ArrayList<Integer> a = map.get(prod);
				a.add(i);
			} else {
				ArrayList<Integer> b = new ArrayList<Integer>();
				b.add(i);
			}
		}
		return list;
	}

}
