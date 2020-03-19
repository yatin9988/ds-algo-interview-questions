package Matrix;

import java.util.Scanner;

public class shift_matrix_elements_by_1 {

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

		int minRow = 0;
		int minCol = 0;
		int maxRow = matrix.length - 1;
		int maxCol = matrix[0].length - 1;
		int count = 1;
		int max_count = matrix.length * matrix[0].length;
		int prev = matrix[0][0];

		while (count <= max_count) {

			for (int j = minCol; j <= maxCol && count <= max_count; j++, count++) {
				if (count == 1)
					continue;
				int temp = matrix[minRow][j];
				matrix[minRow][j] = prev;
				prev = temp;
			}

			minRow++;

			for (int i = minRow; i <= maxRow && count <= max_count; i++, count++) {
				int temp = matrix[i][maxCol];
				matrix[i][maxCol] = prev;
				prev = temp;
			}

			maxCol--;

			for (int j = maxCol; j >= minCol && count <= max_count; j--, count++) {
				int temp = matrix[maxRow][j];
				matrix[maxRow][j] = prev;
				prev = temp;
			}

			maxRow--;

			for (int i = maxRow; i >= minRow && count <= max_count; i--, count++) {
				int temp = matrix[i][minCol];
				matrix[i][minCol] = prev;
				prev = temp;
			}

			minCol++;

		}
		matrix[0][0] = prev;
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
