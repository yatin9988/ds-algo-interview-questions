package Graphs;

import java.util.HashSet;
import java.util.Scanner;

public class getPath_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int vertices = scn.nextInt();
		int numEdges = scn.nextInt();
		boolean[][] edges = new boolean[vertices][vertices];
		for (int i = 0; i < numEdges; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			edges[x][y] = true;
			edges[y][x] = true;
		}
		int v1 = scn.nextInt();
		int v2 = scn.nextInt();
		String s = "";
		getPath(edges, v1, v2, s, new HashSet<Integer>());
		System.out.println(s);
		scn.close();
	}

	public static void getPath(boolean[][] edges, int v1, int v2, String s, HashSet<Integer> set) {

		// base case
		if (v1 == v2) {
			System.out.print(v2 + " ");
			for (int i = s.length() - 1; i >= 0; i--)
				System.out.print(s.charAt(i) + " ");
		}

		set.add(v1);

		for (int i = 0; i < edges.length; i++) {
			if (set.contains(i))
				continue;

			if (edges[v1][i]) {
				getPath(edges, i, v2, s + v1, set);
			}
		}

	}

}
