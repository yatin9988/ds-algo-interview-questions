package Matrix;

import java.util.Scanner;

public class Spiral_Matrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] matrix = new int[n][n];
		int max_count = n * n;
		int count = 1;

		int minRow = 0;
		int minCol = 0;
		int maxRow = n - 1;
		int maxCol = n - 1;

		while (count <= max_count) {

			for (int j = minCol; j <= maxCol && count <= max_count; j++, count++)
				matrix[minRow][j] = count;

			minRow++;

			for (int i = minRow; i <= maxRow && count <= max_count; i++, count++)
				matrix[i][maxCol] = count;

			maxCol--;

			for (int j = maxCol; j >= minCol && count <= max_count; j--, count++)
				matrix[maxRow][j] = count;

			maxRow--;

			for (int i = maxRow; i >= minRow && count <= max_count; i--, count++)
				matrix[i][minCol] = count;

			minCol++;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
		}
	}

}
