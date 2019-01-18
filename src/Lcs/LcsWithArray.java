package Lcs;

public class LcsWithArray {
	/**
	 * Worst case O(n*m)
	 */
	public static int[][] buildmatrix(int[] a , int[] b) {

		int[][] mat=new int[a.length+1][b.length+1];

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				if(a[i-1]==b[j-1]) {
					mat[i][j]=mat[i-1][j-1]+1;

				}else {
					mat[i][j]=Math.max(mat[i][j-1], mat[i-1][j]);
				}
			}
		}
		return mat;
	}
	/**
	 *Worst case O(m+n) 
	 */
	public static int[] lcsArray(int[] a,int[] b) {

		int[][] mat=buildmatrix(a,b);
		int length=mat[mat.length-1][mat.length-1];
		int[] help =new int[length];
		int i=mat.length-1;
		int j=mat[0].length-1;
		while(length>0) {
			if(a[i-1]==b[j-1]) {
				help[i-1]=a[i-1];
				i--;
				j--;
				length--;
			}else {
				if (mat[i][j] == mat[i][j-1])
					j--;
				else
					i--;
			}
		}
		return help;
	}
	/**
	 * Worst case O(A*B*C)
	 */
	public static int buildmatrixFor3array(int[] a , int[] b, int[] c) {

		int[][] mat=new int[a.length+1][b.length+1];
		int notBack=0;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				if(a[i-1]==b[j-1]) {
					for (int k = notBack; k < c.length; k++) {
						if(a[i-1]==c[k]) {
							mat[i][j]=mat[i-1][j-1]+1;
							notBack=k;
							break;
						}
					}
				}else {
					mat[i][j]=Math.max(mat[i][j-1], mat[i-1][j]);
				}
			}
		}

		return mat[mat.length-1][mat[0].length-1];
	}
	public static void main(String[] args) {
		int[]  a= {1,2,3,4,5};
		int[] b= {4,5,1,2,3};
		int[] c= {4,5,6,7,8};
		System.out.println(buildmatrixFor3array(a,c,c));
		int[] arr = lcsArray(a,b);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
