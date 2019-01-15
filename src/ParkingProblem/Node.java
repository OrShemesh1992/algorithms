package ParkingProblem;

public class Node {
	private char data;
	private Node prev, next;
	public Node(char data, Node prev, Node next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public String toString() {
		return "" + this.data;
	}
	public void setData(char c) {
		this.data = c;
	}
	public char getData() {
		return this.data;
	}
	public Node getNext() {
		return this.next;
	}
	public Node getPrev() {
		return this.prev;
	}
	public void setNext(Node n) {
		next = n;
	}
	public void setPrev(Node n) {
		prev = n;
	}
	//***********************************
	//********** main method **********
	//***********************************
	public static void main(String[] args) {
		Node node1 = new Node('A', null, null);
		Node node3 = new Node('C', null, null);
		Node node2 = new Node('B', node1, node3);
		System.out.println("node1 : " + node1.toString()); // + " prev - " + node1.getPrev().toString());
		System.out.println("node3 : " + node3.toString()); // + " prev - " + node3.getPrev().toString());
		System.out.println("node2 : " + node2.toString() +
				" prev - " + node2.getPrev().toString() +
				" next - " + node2.getNext().toString());
	}
}