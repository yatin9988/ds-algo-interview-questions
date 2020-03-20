package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	static Scanner scn = new Scanner(System.in);
	public Node root;
	static int max;

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int x) {
			this.data = x;
			this.left = null;
			this.right = null;
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void tree() {
		root = tree(null);
	}

	private Node tree(Node parent) {

		int data = scn.nextInt();
		Node nn = new Node(data);

		boolean left = scn.nextBoolean();
		if (left)
			nn.left = tree(nn);

		boolean right = scn.nextBoolean();
		if (right)
			nn.right = tree(nn);

		return nn;
	}

	public void deleteLeaves(int key) {
		boolean ans = deleteLeaves(root, key);
		if (ans) {
			root = null;
		}
	}

	private boolean deleteLeaves(Node root, int key) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data == key)
				return true;
			else
				return false;
		}

		boolean left = deleteLeaves(root.left, key);
		if (left) {
			root.left = null;
		}
		boolean right = deleteLeaves(root.right, key);
		if (right) {
			root.right = null;
		}

		if (root.left == null && root.right == null && root.data == key)
			return true;
		else
			return false;
	}

	public ArrayList<String> Root2Leaf() {
		ArrayList<String> list = new ArrayList<String>();
		Root2Leaf(root, "", list);
		return list;
	}

	private void Root2Leaf(Node root, String path, ArrayList<String> list) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			list.add(path + root.data);
			return;
		}

		Root2Leaf(root.left, path + root.data + "->", list);
		Root2Leaf(root.right, path + root.data + "->", list);
	}

	public boolean pathSum1(int sum) {
		return pathSum1(root, sum, 0);
	}

	private boolean pathSum1(Node root, int sum, int curr_sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data + curr_sum == sum)
				return true;
			else
				return false;
		}

		boolean left = pathSum1(root.left, sum, curr_sum + root.data);
		if (left)
			return true;
		boolean right = pathSum1(root.right, sum, curr_sum + root.data);
		if (right)
			return true;

		return false;
	}

	public ArrayList<ArrayList<Integer>> pathSum2(int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		pathSum2(root, ans, path, sum, 0);
		return ans;
	}

	private void pathSum2(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path, int sum,
			int curr_sum) {

		if (root == null)
			return;

		path.add(root.data);
		if (root.left == null && root.right == null) {
			if (sum == curr_sum + root.data) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < path.size(); i++)
					list.add(path.get(i));
				ans.add(list);
			}
		}

		pathSum2(root.left, ans, path, sum, curr_sum + root.data);
		pathSum2(root.right, ans, path, sum, curr_sum + root.data);

		path.remove(path.size() - 1);
		return;
	}

	public int pathSum3(int sum) {

		ArrayList<Integer> path = new ArrayList<Integer>();
		return pathSum3(root, path, sum);
	}

	private int pathSum3(Node root, ArrayList<Integer> path, int sum) {

		if (root == null)
			return 0;

		path.add(root.data);

		int left = pathSum3(root.left, path, sum);
		int right = pathSum3(root.right, path, sum);

		int curr = 0;
		int curr_sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			curr_sum += path.get(i);
			if (curr_sum == sum)
				curr++;
		}

		path.remove(path.size() - 1);
		return left + right + curr;
	}

	public ArrayList<ArrayList<Integer>> pathSum4(int sum) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		pathSum4(root, path, ans, sum);
		return ans;
	}

	private void pathSum4(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans, int sum) {

		if (root == null)
			return;

		path.add(root.data);
		pathSum4(root.left, path, ans, sum);
		pathSum4(root.right, path, ans, sum);

		int curr_sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			curr_sum += path.get(i);
			if (curr_sum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int j = i; j < path.size(); j++)
					list.add(path.get(j));
				ans.add(list);
			}
		}
		path.remove(path.size() - 1);
	}

	public int max_univalue() {
		max = 0;
		max_univalue(root);
		return max;
	}

	private int max_univalue(Node root) {

		if (root == null)
			return 0;

		int left = max_univalue(root.left);
		int right = max_univalue(root.right);
		int curr = -1;

		if (root.left != null && root.left.data == root.data)
			left += 1;

		if (root.right != null && root.right.data == root.data)
			right += 1;

		if (root.left != null && root.right != null) {
			if (root.data == root.left.data && root.data == root.right.data)
				curr = left + right;
		}

		max = Math.max(Math.max(max, curr), Math.max(left, right));

		return Math.max(left, right);
	}

	public int maxRoot2Leaf1() {
		return maxRoot2Leaf1(root, "");
	}

	private int maxRoot2Leaf1(Node root, String path) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			int sum = Integer.parseInt(path + root.data);
			return sum;
		}

		int left = maxRoot2Leaf1(root.left, path + root.data);
		int right = maxRoot2Leaf1(root.right, path + root.data);

		return left + right;

	}

	public int maxRoot2Leaf2() {
		maxRoot2Leaf2(root, 0);
		return helper(root);
	}

	private void maxRoot2Leaf2(Node root, int sum) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			int leaf_sum = sum * 10 + root.data;
			root.data = leaf_sum;
		}

		maxRoot2Leaf2(root.left, sum * 10 + root.data);
		maxRoot2Leaf2(root.right, sum * 10 + root.data);

	}

	public int helper(Node root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return root.data;
		}

		return helper(root.left) + helper(root.right);

	}

	public boolean isSymmetric() {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(Node left, Node right) {

		if (left == null && right == null)
			return true;

		if ((left == null && right != null) || (left != null && right == null))
			return false;

		boolean isLeft = isSymmetric(left.left, right.right);
		boolean isRight = isSymmetric(left.right, right.left);

		if (isLeft && isRight && left.data == right.data)
			return true;

		return false;
	}

	public int minDepth() {
		if (root == null)
			return 0;

		return minDepth(root);
	}

	private int minDepth(Node root) {

		if (root == null)
			return Integer.MAX_VALUE;

		if (root.left == null && root.right == null)
			return 1;

		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return Math.min(left, right) + 1;
	}

	public ArrayList<ArrayList<Integer>> level_order() {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>();
		return level_order(root);
	}

	private ArrayList<ArrayList<Integer>> level_order(Node root) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			LinkedList<Node> queue2 = new LinkedList<>();
			ArrayList<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				Node nn = queue.removeFirst();
				list.add(nn.data);
				if (nn.left != null) {
					queue2.add(nn.left);
				}
				if (nn.right != null) {
					queue2.add(nn.right);
				}
			}
			ans.add(list);
			queue = queue2;
		}
		return ans;
	}

	public ArrayList<ArrayList<Integer>> reverse_level_order1() {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>();
		return reverse_level_order1(root);
	}

	private ArrayList<ArrayList<Integer>> reverse_level_order1(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		LinkedList<Node> queue = new LinkedList<BinaryTree.Node>();
		LinkedList<Node> stack = new LinkedList<BinaryTree.Node>();
		queue.addLast(root);
		queue.addLast(null);
		while (!queue.isEmpty()) {
			Node nn = queue.removeFirst();
			if (nn == null) {
				stack.addFirst(null);
				if (queue.isEmpty())
					break;
				queue.add(null);
				continue;
			} else {
				stack.addFirst(nn);
				if (nn.right != null)
					queue.addLast(nn.right);
				if (nn.left != null)
					queue.addLast(nn.left);
			}
		}
		stack.removeFirst();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			Node nn = stack.removeFirst();
			if (nn == null) {
				ans.add(list);
				list = new ArrayList<Integer>();
			} else {
				list.add(nn.data);
			}
		}
		if (list.size() != 0)
			ans.add(list);
		return ans;
	}

	public ArrayList<ArrayList<Integer>> reverse_level_order2() {
		if (root == null) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			return ans;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		return reverse_level_order2(root, 1, map);
	}

	private ArrayList<ArrayList<Integer>> reverse_level_order2(Node root, int level,
			HashMap<Integer, ArrayList<Integer>> map) {

		preorder(root, level, map);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = map.size(); i > 0; i--) {
			ans.add(map.get(i));
		}
		return ans;
	}

	private void preorder(Node root, int level, HashMap<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;

		if (!map.containsKey(level)) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			map.put(level, list);
		} else {
			map.get(level).add(root.data);
		}

		preorder(root.left, level + 1, map);
		preorder(root.right, level + 1, map);
	}

}
