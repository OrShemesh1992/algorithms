package Fibonacci;

public class Fibonacci_O_n {
/**
 * Fibonacci O(n) Iterativ
 * @param args
 */
	public static int fib(int n) {
		int fib1=1,fib2=1,ans=0;
		if(n==0) {
			return 0;
		}
		if(n==1||n==2) {
			return 1;
		}
		
	for (int i = 2; i < n; i++) {
		ans=fib1+fib2;
		fib2=fib1;
		fib1=ans;
		
	}
	return ans;
		}
	public static void main(String[] args) {
		int n = 9; 
        System.out.println(fib(n)); 
	}

}
