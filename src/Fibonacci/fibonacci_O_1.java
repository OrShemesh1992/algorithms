package Fibonacci;

public class fibonacci_O_1 {
	/**
	 * Fibonacci in O(1)
	 * Fn = {[(√5 + 1)/2] ^ n} / √5
	 */
	public static int fib(int n) {
		double phi = (1 + Math.sqrt(5)) / 2; 
		return (int)(Math.round(Math.pow(phi, n)/Math.sqrt(5)));

	}
	public static void main(String[] args) { 
		int n = 9; 
		System.out.println(fib(n)); 
	} 
}
