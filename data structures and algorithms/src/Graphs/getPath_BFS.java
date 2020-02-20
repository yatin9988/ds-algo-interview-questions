package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class getPath_BFS {

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
		getPath(edges, v1, v2, new HashSet<Integer>());
		scn.close();
	}

	public static void getPath(boolean[][] edges, int v1, int v2, HashSet<Integer> set) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int flag = 0;
		queue.addLast(v1);
		set.add(v1);
		while (!queue.isEmpty()) {

			int temp = queue.removeFirst();
			if (temp == v2) {
				flag = 1;
				break;
			}
			for (int i = 0; i < edges.length; i++) {
				if (set.contains(i))
					continue;
				if (edges[temp][i]) {
					queue.addLast(i);
					map.put(i, temp);
					set.add(i);
				}
			}
		}

		// found v2
		if (flag == 1) {
			int temp = v2;
			while (map.containsKey(temp)) {
				System.out.print(temp + " ");
				temp = map.get(temp);
			}
			System.out.print(v1+" ");
		}
	}

}
