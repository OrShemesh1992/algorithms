package Power;
public class PowerOn {
	
	public static double powerIterative(double basisDegree, int exponent){
		double power = 1;
		for (int i = 0; i < exponent; i++) {
		power=power*basisDegree;
		}
		return power;
	}

	//****************************************************************
	
	public static double powerRecursive(double basisDegree, int exponent){
		double power = 1;
		if(exponent==0)return power;
		else { exponent--; 
		power=basisDegree*powerRecursive(basisDegree,exponent);
		}
		return power;
	}

	
	//****************************************************************
	
public static void main(String[] args) {
		
		System.out.println("5^4 = " + powerIterative(5.0, 4)  + "\n");
		
		System.out.println("*****  Power Iterative O(n)  *****");
		long start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerIterative(5.0, 10000);
		long finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");
		
		start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerIterative(2.7, 14000);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");
		
		start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerIterative(3.58, 9000);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");

		System.out.println("\n5^4 = " + powerRecursive(5.0, 4)  + "\n");
		
		System.out.println("*****  Power Recursive O(n)  *****");
		start = System.nanoTime();
		for (int i = 0; i <10000000; i++)
			powerRecursive(5.0,100);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");
		
		start = System.nanoTime();
		for (int i = 0; i <10000000; i++)
			powerRecursive(2.7, 140);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");
		
		start = System.nanoTime();
		for (int i = 0; i <10000000; i++)
			powerRecursive(3.58, 90);	
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");
	}
}