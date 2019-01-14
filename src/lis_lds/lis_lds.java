package lis_lds;

public class lis_lds {
	/**
	 * Lis O(nlog(n))
	 */
	public static int LengthLis(int[] a) {
		int[] help=new int[a.length];
		help[0]=a[0];
		int lis=1,index;
		for (int i = 1; i < a.length; i++) {
			index =binarySearchBetween(help,a[i],lis);
			help[index]=a[i];
			if(index>lis) lis++;
		}
		return lis;
	}
	public static int binarySearchBetween (int arr[], int a, int lis) {
		if (a < arr[0])
			return 0;
		if (a >arr[lis])
			return lis+1;
		int start=0;
		while (start <= lis) {
			int middle = (start + lis) / 2;
			if (start == lis)
				return start;
			else {
				if(arr[middle]==a) return middle;
				if(a<arr[middle]) lis=middle;
				else start=middle+1;	
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a={8,4,12,2,14,10,3,5,6,7};
		System.out.println(LengthLis(a));
	}

}
