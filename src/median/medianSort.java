package median;

public class medianSort {

	/**
	 * This function recives an array of integers and finds a number the bigger then
	 * median. O(1).
	 * 
	 * @param a = an array of intigers.
	 * @return = the max value between the first 64 elemts in the array.
	 */
	public static int biggerThenMedian(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length && i < 63; i += 2) {
			if (a[i] > a[i + 1]) {
				if (a[i] > max)
					max = a[i];
			} else { // a[i+1] > a[i]
				if (a[i + 1] > max)
					max = a[i + 1];
			}
		}
		return max;
	}

	/**
	 * Worst case O(n)
	 */
	public static int[] median_Sort(int a[], int b[]) {
		int c[] = new int[a.length];
		int a1=0,b1=a.length-1;
		for (int i = 0; i < c.length; i++) {
			c[i]=Math.max(a[a1++], b[b1--]);
		}
		return c;
	}

	public static void main(String[] args) {
		int[] a= {1,20,34,100};
		int[] b= {5,8,10,32};
		int[] c=median_Sort(a,b);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
		int[] y= {5,8,10,32,5,3,6,66,53,6,56,3,6635,47,3,7,657,65,7,4577,76,664,574,657,7,64,467,76,7,6565,76,5,7465,74,7,6,756,764,57,7,6,6,6,6,7,57,5,75,7,567,57,6,756,756,657,567,5,765,7,56,75,67,56,7,65,7,58,3,8,3};
		System.out.print(biggerThenMedian(y));
	}

}