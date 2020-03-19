package Matrix;

import java.util.Scanner;

public class create_spiral_matrix_from_given_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[5][5];
		int minCol = 0;
		int minRow = 0;
		int maxRow = matrix.length - 1;
		int maxCol = matrix[0].length - 1;

		int count = 0;
		int[] arr = new int[25];
		for (int i = 0; i < 25; i++)
			arr[i] = i + 1;

		int max_count = arr.length;

		while (count < max_count) {

			for (int j = minCol; j <= maxCol && count < max_count; j++)
				matrix[minRow][j] = arr[count++];

			minRow++;

			for (int i = minRow; i <= maxRow && count < max_count; i++)
				matrix[i][maxCol] = arr[count++];

			maxCol--;

			for (int j = maxCol; j >= minCol && count < max_count; j--)
				matrix[maxRow][j] = arr[count++];

			maxRow--;

			for (int i = maxRow; i >= minRow && count < max_count; i--)
				matrix[i][minCol] = arr[count++];

			minCol++;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
