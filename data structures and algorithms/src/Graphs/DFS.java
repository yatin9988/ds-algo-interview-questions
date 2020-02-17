package Graphs;

import java.util.HashSet;
import java.util.Scanner;

public class DFS {

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
		HashSet<Integer> set = new HashSet<Integer>();
		DFs(edges, 0, set);
		System.out.println("END");
		scn.close();
	}

	// works for connected graph
	public static void DFs(boolean[][] edges, int src, HashSet<Integer> set) {

		System.out.print(src + "->");
		set.add(src);
		for (int i = 0; i < edges.length; i++) {
			if (set.contains(i))
				continue;
			if (edges[src][i])
				DFs(edges, i, set);
		}
	}

}
