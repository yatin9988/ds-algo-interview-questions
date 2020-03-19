package Matrix;

import java.util.Scanner;

public class Spiral_Matrix1 {

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
		int maxRow = m - 1;
		int maxCol = n - 1;
		int count = 1;
		int max_count = m * n;

		while (count <= max_count) {

			for (int j = minCol; j <= maxCol && count <= max_count; j++, count++)
				System.out.print(matrix[minRow][j] + " ");

			minRow++;

			for (int i = minRow; i <= maxRow && count <= max_count; i++, count++)
				System.out.print(matrix[i][maxCol] + " ");

			maxCol--;

			for (int j = maxCol; j >= minCol && count <= max_count; j--, count++)
				System.out.print(matrix[maxRow][j] + " ");

			maxRow--;

			for (int i = maxRow; i >= minRow && count <= max_count; i--, count++)
				System.out.print(matrix[i][minCol] + " ");

			minCol++;
		}
	}

}
