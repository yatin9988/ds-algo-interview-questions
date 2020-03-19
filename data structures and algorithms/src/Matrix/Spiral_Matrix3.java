package Matrix;

import java.util.Scanner;

public class Spiral_Matrix3 {

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

		int r0 = scn.nextInt();
		int c0 = scn.nextInt();
		int count = 0;
		int max_count = matrix.length * matrix[0].length;
		int R = matrix.length - 1;
		int C = matrix[0].length - 1;

		int row_inc = 1;
		int col_inc = 1;
		System.out.print("[" + r0 + "-" + c0 + "] ");

		while (count < max_count-1) {

			for (int j = c0 + 1; j <= c0 + col_inc && count < max_count-1; j++) {

				if (isValid(r0, j, R, C)) {
					System.out.print("[" + r0 + "-" + j + "] ");
					count++;
				}
			}

			c0 = c0 + col_inc;
			col_inc++;

			for (int i = r0 + 1; i <= r0 + row_inc && count < max_count-1; i++) {

				if (isValid(i, c0, R, C)) {
					System.out.print("[" + i + "-" + c0 + "] ");
					count++;
				}

			}

			r0 = r0 + row_inc;
			row_inc++;

			for (int j = c0 - 1; j >= c0 - col_inc && count < max_count-1; j--) {
				if (isValid(r0, j, R, C)) {
					System.out.print("[" + r0 + "-" + j + "] ");
					count++;
				}
			}

			c0 = c0 - col_inc;
			col_inc++;

			for (int i = r0 - 1; i >= r0 - row_inc && count < max_count-1; i--) {
				if (isValid(i, c0, R, C)) {
					System.out.print("[" + i + "-" + c0 + "] ");
					count++;
				}
			}

			r0 = r0 - row_inc;
			row_inc++;
		}
	}

	public static boolean isValid(int r, int c, int R, int C) {

		if (r >= 0 && r <= R && c >= 0 && c <= C)
			return true;

		return false;
	}

}
