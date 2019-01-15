package ParkingProblem;

public class DoubleCycleLinkedList {
	public Node head, tail;
	public int size;
	public DoubleCycleLinkedList(){
		head = tail = null;
		size = 0;
	}
	public void add(char obj){
		if(head==null) {
			head = new Node(obj, null, null);
			tail = head;
			head.setNext(tail);
			head.setPrev(tail);
		}else {
			Node n = new Node(obj, tail, head);
			tail.setNext(n);
			tail = n;
			head.setPrev(tail);
		}
		size++;
	}
	public Node getHead() {
		return head;
	}
	public Node getNext(Node n) {
		return n.getNext();
	}
	public String toString() {
		String s = "[";
		if (head != null){
			s = s + head.toString() + ", ";
			for (Node n = head.getNext(); n != head; n=n.getNext()){
				s = s + n.toString() + ", ";
			}
			s = s.substring(0, s.length()-2);
		}
		return s+"]";
	}
	public DoubleCycleLinkedList buildLinkedList() {
		DoubleCycleLinkedList DCLL = new DoubleCycleLinkedList();
		DCLL.add('V');
		DCLL.add('B');
		DCLL.add('M');
		DCLL.add('V');
		DCLL.add('S');
		DCLL.add('A');
		DCLL.add('X');
		DCLL.add('P');
		DCLL.add('V');
		DCLL.add('T');
		System.out.println("DCLL : " + DCLL.toString());
		return DCLL;
	}
	public static void main(String[] args) {
		DoubleCycleLinkedList parking = new DoubleCycleLinkedList(); // parking place DCLL
		parking.buildLinkedList();
		}
}
