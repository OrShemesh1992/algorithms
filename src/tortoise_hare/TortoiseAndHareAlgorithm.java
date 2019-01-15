package tortoise_hare;

public class TortoiseAndHareAlgorithm {
	static CircleLinkedList linearLL = new CircleLinkedList();
	static CircleLinkedList circleLL = new CircleLinkedList();

	public boolean hasLoop(CircleLinkedList LL) { 
		Node slow; // create two pointers
		Node fast;
		slow=fast=LL.getStart();
		while(true) {
			if(slow.getNext()==null) return false;
			if(fast.getNext()==null) return false;
			slow=slow.getNext();
			fast=fast.getNext().getNext();
			if(slow==null||fast==null) {
				return false;
			}
			if(slow==fast) return true;
		}
	}
	public Node meetingPointInLoop() {
		int step=0;
		Node slow=circleLL.getStart();
		Node fast=circleLL.getStart();
		slow=slow.getNext();
		fast=fast.getNext().getNext();
		step++;
		while(slow!=fast) {
			slow=slow.getNext();
			fast=fast.getNext().getNext();
			step++;
			if(slow==fast)
				break;
		}
		System.out.println("\nSteps to meeting point : " + step);
		return fast;		
	}
	public Node startOfLoop(Node meet) { 
		Node slow=circleLL.getStart();
		Node fast=meet;

		while(slow!=fast) {
			fast=fast.getNext();
			if(slow==fast.getNext()) break;
			slow=slow.getNext();
		}
		return slow;
	}
	public int lengthOfLoop(Node meet) {
		Node slow= meet;
		Node fast=meet;
		int size=0;
		fast=fast.getNext();
		size++;
		while(slow!=fast) {
			fast=fast.getNext();
			size++;
		}
			return size;	
	}
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) // list size = 10
			linearLL.add(i);
			System.out.println("Linear Linked List size = " +
			 linearLL.getSize());
			System.out.println(linearLL.toString());
			//****************************************************
			for (int i = 1; i < 10; i++) // list size = 10
			circleLL.add(i);
			circleLL.addLoop(4); // first loop node = 4
			System.out.println("\nLoop Linked List size = "
			 + circleLL.getSize());
			System.out.println(circleLL.toString());
			TortoiseAndHareAlgorithm toAndHa =
			 new TortoiseAndHareAlgorithm();
			//***************************************
			//********** Step 1 *************
			//***************************************
			System.out.println();
			System.out.println("Linear Linked List : has loop - "
			 + toAndHa.hasLoop(linearLL));
			System.out.println("Loop Linked List : has loop - "
			 + toAndHa.hasLoop(circleLL));
			//***************************************
			//********** Step 2 *************
			//***************************************
			Node meetingNode = toAndHa.meetingPointInLoop();
			//System.out.println();
			System.out.println("Meeting point : " + meetingNode.getData());
			//***************************************
			//********** Step 3 *************
			//***************************************
			Node firstInLoop = toAndHa.startOfLoop(meetingNode);
			System.out.println();
			System.out.println("Start of the loop : " + firstInLoop.getData());
			//***************************************
			//********** Step 4 *************
			//***************************************
			int loopLength = toAndHa.lengthOfLoop(meetingNode);
			System.out.println();
			System.out.println("Length of the loop : " + loopLength);
			}
	}
