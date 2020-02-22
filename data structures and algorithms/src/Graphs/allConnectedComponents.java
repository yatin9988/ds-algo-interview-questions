package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class allConnectedComponents {

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
		ArrayList<ArrayList<Integer>> list = connectedComponents(edges);
		System.out.println(list);
	}

	public static ArrayList<ArrayList<Integer>> connectedComponents(boolean[][] edges) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int k = 0; k < edges.length; k++) {

			if (set.contains(k))
				continue;

			ArrayList<Integer> l = new ArrayList<Integer>();
			queue.addLast(k);
			set.add(k);
			while (!queue.isEmpty()) {
				int temp = queue.removeFirst();
				l.add(temp);
				for (int i = 0; i < edges.length; i++) {
					if (set.contains(i))
						continue;
					if (edges[temp][i]) {
						set.add(i);
						queue.addLast(i);
					}
				}
			}
			Collections.sort(l);
			list.add(l);
		}
		return list;
	}

}
