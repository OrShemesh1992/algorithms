package tortoise_hare;

public class Node {
	private int data;
	private Node next;

	public Node(int _data) {
		this.data=_data;
		this.next=null;
	}

	public void setData(int _data) {
		this.data=_data;
	}
	public int getData() {
		return this.data;
	}
	public void setNext(Node n) {
		next = n;
	}
	public Node getNext() {
		return this.next;
	}
	public String toString() {
		return "" + this.data;
	}

	public static void main(String[] args) {
		Node node1 = new Node(0);
		Node node2 = new Node(10);
		Node node3 = new Node(20);
		Node node4 = new Node(30);
		System.out.println("node1 : " + node1.toString());
		System.out.println("node2 : " + node2.toString());
		System.out.println("node3 : " + node3.toString());
		System.out.println("node4 : " + node4.toString()); 

	}

}
