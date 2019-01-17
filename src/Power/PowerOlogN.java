package Power;

public class PowerOlogN {
//2^3
	public static double powerIterative(double basisDegree, int exponent){
		double power = 1;
		while(exponent>0) {
			if(exponent%2==1) {
				power=power*basisDegree;
			}
			exponent=exponent/2;
			basisDegree=basisDegree*basisDegree;
		}
		return power;
	}

	//****************************************************************

	public static double powerRecursive(double basisDegree, int exponent){
		double power = 1;
		if(exponent==0)return power;
		else {
			if(exponent%2==0) {
				exponent=exponent/2;
				basisDegree=basisDegree*basisDegree;
				power=powerRecursive(basisDegree,exponent);
			}else {
				exponent=(exponent-1)/2;
				basisDegree=basisDegree*basisDegree;
				power=Math.sqrt(basisDegree)*powerRecursive(basisDegree,exponent);
			}
		}

		return power;
	}


	//****************************************************************

	public static void main(String[] args) {

		System.out.println("5^4 = " + powerIterative(5.0, 4)  + "\n");

		System.out.println("*****  Power Iterative O(logN)  *****");

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
		System.out.println("*****  Power Recursive O(logN)  *****");

		start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerRecursive(5.0, 10000);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");

		start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerRecursive(2.7, 14000);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");

		start = System.nanoTime();
		for (int i = 0; i <100000; i++)
			powerRecursive(3.58, 9000);
		finish = System.nanoTime();
		System.out.println("time = " + (finish - start) + " nanosec");

	}
}