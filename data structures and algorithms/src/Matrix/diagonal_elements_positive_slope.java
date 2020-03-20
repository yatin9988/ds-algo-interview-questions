package Matrix;

import java.util.Scanner;

public class diagonal_elements_positive_slope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scn.nextInt();
			}
		}
		int col_max = matrix[0].length - 1;
		int curr_col = 0;
		while (curr_col <= col_max) {
			int tempj = curr_col;
			int tempi = 0;
			while (tempj >= 0) {
				System.out.print(matrix[tempi][tempj] + " ");
				tempj--;
				tempi++;
			}
			System.out.println();
			curr_col++;
		}

		int row_max = matrix.length - 1;
		int curr_row = 1;
		while (curr_row <= row_max) {

			int tempi = curr_row;
			int tempj = matrix[0].length - 1;
			while (tempi <= row_max) {
				System.out.print(matrix[tempi][tempj] + " ");
				tempi++;
				tempj--;
			}
			System.out.println();
			curr_row++;
		}
	}

}
