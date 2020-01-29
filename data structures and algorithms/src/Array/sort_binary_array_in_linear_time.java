package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class sort_binary_array_in_linear_time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = scn.nextInt();
//		method1(arr);
//		method2(arr);
		method3(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	// O(2*n)
	public static void method1(int[] arr) {

		int count = 0;
		for (int i : arr) {
			if (i == 0)
				count++;
		}

		for (int i = 0; i < count; i++) {
			arr[i] = 0;
		}
		for (int i = count; i < arr.length; i++) {
			arr[i] = 1;
		}

	}

	// O(2*n-k)
	public static void method2(int[] arr) {

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				arr[index++] = 0;
		}

		for (int i = index; i < arr.length; i++)
			arr[index++] = 1;

	}

	// O(n)
	public static void method3(int[] arr) {

		int j = -1;
		int pivot = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

	}

}
