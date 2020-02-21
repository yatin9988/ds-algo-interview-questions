package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		boolean[][] edges = new boolean[N + 1][N + 1];
		int M = scn.nextInt();
		int[] u = new int[M];
		int[] v = new int[M];
		for (int i = 0; i < M; i++)
			u[i] = scn.nextInt();

		for (int i = 0; i < M; i++)
			v[i] = scn.nextInt();

		System.out.println(countConnectedIslands(edges, u, v));
		scn.close();
	}

	public static int countConnectedIslands(boolean[][] edges, int[] u, int[] v) {

		for (int i = 0; i < u.length; i++) {
			int x = u[i];
			int y = v[i];
			edges[x][y] = true;
			edges[y][x] = true;
		}

		int count = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < edges.length; i++) {

			if (set.contains(i))
				continue;

			queue.addLast(i);
			set.add(i);
			count++;
			while (!queue.isEmpty()) {

				int temp = queue.removeFirst();
				for (int j = 1; j < edges.length; j++) {
					if (set.contains(j))
						continue;
					if (edges[temp][j]) {
						set.add(j);
						queue.addLast(j);
					}
				}

			}
		}
		return count;
	}

}
