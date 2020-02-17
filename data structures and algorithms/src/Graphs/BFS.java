package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {

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
		HashSet<Integer> visited = new HashSet<Integer>();
		BFs(edges, 0, visited);
		System.out.println("END");
		scn.close();
	}

	public static void BFs(boolean[][] edges, int src, HashSet<Integer> set) {

		for (int k = 0; k < edges.length; k++) {

			if (set.contains(k))
				continue;
			src = k;

			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.addFirst(src);
			set.add(src);
			while (!queue.isEmpty()) {
				int temp = queue.removeFirst();
				System.out.print(temp + "->");
				for (int i = 0; i < edges.length; i++) {
					if (set.contains(i))
						continue;
					if (edges[temp][i]) {
						queue.addLast(i);
						set.add(i);
					}
				}
			}
		}
	}

}
