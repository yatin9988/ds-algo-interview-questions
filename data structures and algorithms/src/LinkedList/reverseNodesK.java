package LinkedList;

public class reverseNodesK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(1);	
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.print();
		list.reverseK(3);
		list.print();
	}

}
