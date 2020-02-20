package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class isConnected {

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
		System.out.println(connected(edges));
	}

	public static boolean connected(boolean[][] edges) {

		int count = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(0);
		set.add(0);

		while (!queue.isEmpty()) {
			int temp = queue.removeFirst();
			for (int i = 0; i < edges.length; i++) {
				if (set.contains(i))
					continue;
				if (edges[temp][i]) {
					count++;
					set.add(i);
					queue.addLast(i);
				}
			}
		}
		return count == edges.length;
	}

}
