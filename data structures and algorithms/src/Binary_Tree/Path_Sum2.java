package Binary_Tree;

import java.util.ArrayList;

public class Path_Sum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.tree();
		ArrayList<ArrayList<Integer>> ans = bt.pathSum2(22);
		System.out.println(ans);
	}

}
