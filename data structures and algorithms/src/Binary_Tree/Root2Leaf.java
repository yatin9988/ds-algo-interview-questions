package Binary_Tree;

import java.util.ArrayList;

public class Root2Leaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.tree();
		ArrayList<String> list = bt.Root2Leaf();
		for(String str:list)
			System.out.println(str);
	}

}
