package Binary_Tree;

public class Delete_Leaves_with_a_given_value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.tree();
		bt.postorder();
		bt.deleteLeaves(1);
		System.out.println();
		bt.postorder();
	}

}
