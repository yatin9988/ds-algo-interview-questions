package Matrix;

import java.util.HashSet;
import java.util.LinkedList;

class Node {
	int x;
	int y;

	Node parent;
	int len;

	public Node(int x, int y, Node parent, int len) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.len = len;
	}

}

public class shortest_path {

	public static boolean isValid(int x, int y, int[][] matrix) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
			return true;
		}
		return false;
	}

	public static Node bfs(int[][] matrix) {

		LinkedList<Node> queue = new LinkedList<>();
		HashSet<String> set = new HashSet<String>();
		String pair = 0 + "," + 0;
		set.add(pair);
		Node src = new Node(0, 0, null, 0);
		queue.add(src);
		while (!queue.isEmpty()) {
			Node curr = queue.removeFirst();
			if (curr.x == matrix.length - 1 && curr.y == matrix[0].length - 1) {
				return curr;
			}

			int jump = matrix[curr.x][curr.y];

			int c1x = curr.x + jump;
			int c1y = curr.y;

			if (isValid(c1x, c1y, matrix) && !set.contains(c1x + "," + c1y)) {
				Node nn = new Node(c1x, c1y, curr, curr.len + 1);
				queue.add(nn);
				set.add(c1x + "," + c1y);
			}

			int c2x = curr.x - jump;
			int c2y = curr.y;

			if (isValid(c2x, c2y, matrix) && !set.contains(c2x + "," + c2y)) {
				Node nn = new Node(c2x, c2y, curr, curr.len + 1);
				queue.add(nn);
				set.add(c2x + "," + c2y);
			}

			int c3x = curr.x;
			int c3y = curr.y + jump;

			if (isValid(c3x, c3y, matrix) && !set.contains(c3x + "," + c3y)) {
				Node nn = new Node(c3x, c3y, curr, curr.len + 1);
				queue.add(nn);
				set.add(c3x + "," + c3y);
			}

			int c4x = curr.x;
			int c4y = curr.y - jump;

			if (isValid(c4x, c4y, matrix) && !set.contains(c4x + "," + c4y)) {
				Node nn = new Node(c4x, c4y, curr, curr.len + 1);
				queue.add(nn);
				set.add(c4x + "," + c4y);
			}

		}
		return null;
	}

	public static void printPath(Node curr) {
		if (curr == null)
			return;
		printPath(curr.parent);
		System.out.println(curr.x + "-" + curr.y);
	}

	public static void main(String[] args) {
		int[][] matrix = { { 4, 4, 6, 5, 5, 1, 1, 1, 7, 4 }, { 3, 6, 2, 4, 6, 5, 7, 2, 6, 6 },
				{ 1, 3, 6, 1, 1, 1, 7, 1, 4, 5 }, { 7, 5, 6, 3, 1, 3, 3, 1, 1, 7 }, { 3, 4, 6, 4, 7, 2, 6, 5, 4, 4 },
				{ 3, 2, 5, 1, 2, 5, 1, 2, 3, 4 }, { 4, 2, 2, 2, 5, 2, 3, 7, 7, 3 }, { 7, 2, 4, 3, 5, 2, 2, 3, 6, 3 },
				{ 5, 1, 4, 2, 6, 4, 6, 7, 3, 7 }, { 1, 4, 1, 7, 5, 3, 6, 5, 3, 4 } };

		Node nn = bfs(matrix);
		System.out.println(nn.len);
		printPath(nn);
	}

}
