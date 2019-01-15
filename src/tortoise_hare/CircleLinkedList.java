package tortoise_hare;

public class CircleLinkedList {
	private Node tail;
	private Node Start;
	private int size;

	public CircleLinkedList() {
		tail=null;
		Start=null;
		size=0;
	}
	public void add(int n) {
		if(Start==null) {
			Start=new Node(n);
			tail=Start;
		}
		else {
			Node temp=tail;
			tail=new Node(n);
			temp.setNext(tail);
		}
		size++;
	}
	public void addLoop(int index) {
		Node current = Start;
		while (current.getData() != index) {
			if (current.getNext() == null)
				return;
			current = current.getNext();
		}
		tail.setNext(current);
	}


	public int getSize() {
		return size;
	}
	public Node getStart() {
		return Start;
	}
	public String toString() {
		Node current = Start;
		String result =
				"";
		int count = 0;
		while(current != null) {
			result += "[" + current.getData() + "]";
			current = current.getNext();
			count++;
			if (count % 10 == 0 || count % 16 == 0)
				result = result + " ";
			if (count == 20) // maybe linked list has a loop
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		CircleLinkedList linearLL = new CircleLinkedList();
		for (int i = 1; i < 10; i++) // list size = 10
		linearLL.add(i);
		System.out.println("Linear Linked List size = "
		+ linearLL.getSize());
		System.out.println(linearLL.toString());
		//****************************************************
		CircleLinkedList circleLL = new CircleLinkedList();
		for (int i = 1; i < 10; i++) // list size = 10
		circleLL.add(i);
		circleLL.addLoop(4); // first loop node = 4
		System.out.println("\nLoop Linked List size = "
		+ circleLL.getSize());
		System.out.println(circleLL.toString());
	}

}
