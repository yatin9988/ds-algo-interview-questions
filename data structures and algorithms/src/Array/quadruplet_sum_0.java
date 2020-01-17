package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quadruplet_sum_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		System.out.println(method1(arr));
	}

	// O(n^3) sorting
	public static ArrayList<ArrayList<Integer>> method1(int[] nums) {

		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {

			while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
				i++;

			for (int j = i + 1; j < nums.length - 2; j++) {

				while (j > i + 1 && j < nums.length && nums[j] == nums[j - 1])
					j++;

				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == 0) {
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[left]);
						l.add(nums[right]);
						ans.add(l);
						left++;
						right--;
						while ((left < right) && nums[left] == nums[left - 1])
							left++;
						while ((left < right) && nums[right] == nums[right + 1])
							right--;
					} else if (sum > 0)
						right--;
					else
						left++;
				}

			}
		}
		return ans;
	}

}
