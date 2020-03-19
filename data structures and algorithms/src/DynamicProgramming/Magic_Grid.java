package DynamicProgramming;

import java.util.Scanner;

public class Magic_Grid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int columns = scn.nextInt();
		int[][] arr = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				arr[i][j] = scn.nextInt();
		}
		System.out.println(recursive(arr, 0, 0));

	}

	public static int recursive(int[][] arr, int i, int j) {

		// the minimum health value required is 1
		// the minimum possible value WHEN WE REACH the end should be 1
		if (i == arr.length - 1 && j == arr[0].length - 1) {
			return 1;
		}

		if (i >= arr.length || j >= arr[0].length)
			return Integer.MAX_VALUE;

		int down = recursive(arr, i + 1, j);
		int right = recursive(arr, i, j + 1);

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		if (down != Integer.MAX_VALUE)
			min1 = down - arr[i][j];
		if (right != Integer.MAX_VALUE)
			min2 = right - arr[i][j];

		if (min1 < 0) {
			min1 = 1;
		}
		if (min2 < 0)
			min2 = 1;

		return Math.min(min1, min2);
	}

}
