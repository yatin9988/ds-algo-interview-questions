package Graphs;

import java.util.HashSet;
import java.util.Scanner;

public class hasPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int vertices = scn.nextInt();
		boolean[][] edges = new boolean[vertices][vertices];
		int numEdges = scn.nextInt();
		for (int i = 0; i < numEdges; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			edges[x][y] = true;
			edges[y][x] = true;
		}

		int v1 = scn.nextInt();
		int v2 = scn.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println(hasPatH(edges, v1, v2, set));
		scn.close();
	}

	public static boolean hasPatH(boolean[][] edges, int v1, int v2, HashSet<Integer> set) {

		// base case
		// if there is a direct path between the 2 vertices v1 and v2 return true
		// directly
		if (edges[v1][v2])
			return true;

		set.add(v1);

		// if not then ask it neighbours
		boolean ans = false;
		for (int i = 0; i < edges.length; i++) {
			if (set.contains(i))
				continue;
			if (edges[v1][i])
				ans = ans || hasPatH(edges, i, v2, set);
			if (ans)
				return true;
		}
		return false;
	}

}
