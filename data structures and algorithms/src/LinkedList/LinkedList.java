package LinkedList;

public class LinkedList {

	private Node head;
	private int size;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public int size() {
		return this.size;
	}

	public void add(int data) {
		Node nn = new Node(data);
		this.size++;
		if (head == null) {
			head = nn;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = nn;
		}
	}

	public void print() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void print(Node thead) {
		Node temp = thead;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	// O(N) O(N)
	// left center right
	// original list is intact
	public void partition1(int key) {
		Node temp = this.head;
		Node left = new Node(10);
		Node center = new Node(10);
		Node right = new Node(10);

		Node leftHead = left;
		Node centerHead = center;
		Node rightHead = right;

		while (temp != null) {
			if (temp.data < key) {
				Node nn = new Node(temp.data);
				left.next = nn;
				left = left.next;
			} else if (temp.data == key) {
				Node nn = new Node(temp.data);
				center.next = nn;
				center = center.next;
			} else {
				Node nn = new Node(temp.data);
				right.next = nn;
				right = right.next;
			}
			temp = temp.next;
		}
		leftHead = leftHead.next;
		centerHead = centerHead.next;
		rightHead = rightHead.next;

		if (leftHead != null) {
			if (centerHead != null) {
				left.next = centerHead;
				center.next = rightHead;
			} else {
				left.next = rightHead;
			}
		} else {
			if (centerHead != null) {
				center.next = rightHead;
				leftHead = centerHead;
			} else {
				leftHead = rightHead;
			}
		}
		print(leftHead);
	}

	// left right
	// original list is not intact
	// O(n) O(1)
	public void partition2(int key) {

		Node left = new Node(10);
		Node right = new Node(10);
		Node temp = head;

		Node leftHead = left;
		Node rightHead = right;

		while (temp != null) {
			if (temp.data < key) {
				Node nn = temp;
				temp = temp.next;
				nn.next = null;
				left.next = nn;
				left = left.next;
			} else {
				Node nn = temp;
				temp = temp.next;
				nn.next = null;
				right.next = nn;
				right = right.next;
			}
		}

		leftHead = leftHead.next;
		rightHead = rightHead.next;

		if (leftHead != null)
			left.next = rightHead;
		else
			leftHead = rightHead;

		print(leftHead);
	}

	// O(n)
	public void swap1() {

		// since linkedlist of size 0 and 1 will have the same possible answer
		if (head == null || head.next == null)
			return;

		Node temp1 = head;
		Node temp2 = head.next;
		head = head.next;
		while (temp2.next != null && temp2.next.next != null) {
			Node ahead = temp2.next;
			temp2.next = temp1;
			temp1.next = ahead.next;
			temp1 = ahead;
			temp2 = ahead.next;
		}
		Node temp = temp2.next;
		temp2.next = temp1;
		temp1.next = temp;
	}

	// O(n)
	public void swap2() {
		Node temp = head.next;
		swap2(head, head.next);
		print(temp);
	}

	// O(n)
	private Node swap2(Node temp1, Node temp2) {

		if (temp2.next == null || temp2.next.next == null) {
			Node temp = temp2.next;
			temp2.next = temp1;
			temp1.next = temp;
			return temp2;
		}

		Node temp = swap2(temp1.next.next, temp2.next.next);
		temp2.next = temp1;
		temp1.next = temp;
		return temp2;
	}

	// O(n)
	// single pass - one pass
	public void NthfromEnd(int k) {

		Node temp1, temp2;
		temp1 = temp2 = this.head;
		int flag = 0;

		for (int i = 0; i < k + 1; i++) {
			if (temp1 != null)
				temp1 = temp1.next;
			else
				flag = 1;
		}

		if (flag == 1)
			head = head.next;
		else {
			while (temp1 != null) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			temp2.next = temp2.next.next;
		}
		print(head);
	}

	// O(n)
	public void RPI() {

		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head = prev;
	}

	// O(n)
	public void reverseK(int k) {
		int s = size();
		this.head = reverseK(head, k, s, 0);
	}

	// O(n)
	private Node reverseK(Node curr, int k, int size, int countt) {

		if (countt >= k * (size / k)) {
			return curr;
		}

		int count = 0;
		Node prev = null;
		Node temp1 = curr;
		while (count < k) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
			count++;
		}

		Node temp2 = reverseK(curr, k, size, countt + k);
		temp1.next = temp2;
		return prev;
	}

}
