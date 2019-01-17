package ballGlass;

public class Glassball {
	/**
	 * Worst Case O(n^2) 
	 */
	public static int numberofcheacking2(int n) {
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; i++) {
			int min = n;
			for (int j = 1; j < i-1; j++) {
				int x = Math.max(j, f[i-j]+1);
				if(x < min)min = x;
			}
			f[i] = min;
		}
		return f[n];
	}
	/**
	 * Worst Case O(n^2*k)
	 */
	public static int numberOfCheckingK(int n,int k) {
		int numCheack = 0, min = 0;
		int[][] cheack = new int[k+1][n+1];
		for (int j = 0; j <= n; j++) {
			cheack[0][j] = 0;
			cheack[1][j] = j;
		}
		for (int i = 2; i <= k; i++) {
			for (int j = 2; j <=n; j++) {
				min = n+1;
				for (int p = 1; p < j; p++) {
					min = Math.min(Math.max(cheack[i][j-p], (cheack[i-1][p-1]))+1, min);
				}
				cheack[i][j] = min;
			}
		}
		numCheack =	cheack[k][n];
		return numCheack;
	}
	public static void main(String[] args) {
		System.out.println(numberofcheacking2(115));
		System.out.println(numberOfCheckingK(115,2));
		
	}
}
