package Matrix;

import java.util.Scanner;

public class Diagonal_Traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				matrix[i][j] = scn.nextInt();
		}
		int[] ans = diagonal(matrix);
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
	}

	public static int[] diagonal(int[][] matrix) {

		int index = 0;
		int[] ans = new int[matrix.length * matrix[0].length];
		// upper left
		int count = 1;
		int col_max = matrix[0].length - 1;
		int curr_col = 0;
		int row_max = matrix.length - 1;
		int curr_row = 0;
		while (curr_col <= col_max) {

			if (count % 2 != 0) {
				int tempi = 0;
				int tempj = 0;

			} else {
				int tempj = curr_col;
				int tempi = 0;
				while (tempj >= 0) {
					ans[index++] = matrix[tempi][tempj];
					tempj--;
					tempi++;
				}
				curr_col++;
				count++;
			}

		}
	}

}
