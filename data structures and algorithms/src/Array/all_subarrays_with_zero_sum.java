package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class all_subarrays_with_zero_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		int target = scn.nextInt();
		System.out.println(method(arr, target));
	}

	public static ArrayList<ArrayList<Integer>> method(int[] arr, int target) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(-1);
		map.put(0, l);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - target)) {
				ArrayList<Integer> t = map.get(sum - target);
				for (int j = 0; j < t.size(); j++) {
					ArrayList<Integer> ll = new ArrayList<Integer>();
					ll.add(t.get(j) + 1);
					ll.add(i);
					list.add(ll);
				}
				t.add(i);
				map.put(sum, t);
			} else {
				ArrayList<Integer> g = new ArrayList<Integer>();
				g.add(i);
				map.put(sum, g);
			}

		}
		return list;
	}

}
