package Plane;

public class Node {
	int x, y, price, nPaths;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.price = 0;
		this.nPaths = 0;
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
