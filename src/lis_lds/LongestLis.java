package lis_lds;

public class LongestLis {
	/**
	 * get Lomgest Lis O(n^2)
	 * Lds is lis reversc
	 */
	public static int[] longestSub(int[] a) {
		int[][] mat =new int[a.length][a.length];
		mat[0][0]=a[0];
		int lis=0;
		for (int i = 1; i < a.length; i++) {
			int index=binarySearch(mat,lis,a[i]);
			for (int j = 0; j < index; j++) {
				mat[index][j]=mat[index-1][j];
			}
			mat[index][index]=a[i];
			if(index>lis) lis++;
		}
		int[] ans=new int [lis+1];
		for (int i = 0; i <= lis; i++) {
			ans[i]=mat[lis][i];
		}

		return ans;
	}

	public static int binarySearch(int a[][], int end, int key){
		int left = 0;
		int right = end;
		int middle = 0;
		if (key < a[0][0])
			return 0;
		if (key >a[end][end])
			return end + 1;
		while (left < right - 1){
			middle = (left + right) / 2;
			if (a[middle][middle] < key)
				left = middle;
			else
				right = middle;
		}
		return right;
	}
	public static void main(String[] args) {
		int[] a={8,4,12,2,14,10,3,5,6,7};
		int[] b=longestSub(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
	}

}
