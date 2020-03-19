package Binary_Tree;

public class largest_path_sum_root_2_leaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.tree();
		long start = System.currentTimeMillis();
		System.out.println(bt.maxRoot2Leaf2());
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
