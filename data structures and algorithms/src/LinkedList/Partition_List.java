package LinkedList;

import java.util.Scanner;

public class Partition_List {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(2);
		list.add(3);
		list.partition2(3);
	}

}
