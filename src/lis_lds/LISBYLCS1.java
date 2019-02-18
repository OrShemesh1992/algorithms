package lis_lds;

import java.util.Arrays;

public class LISBYLCS1 {
public static int lis(int[] a) {
	int[] b=new int[a.length];
	for (int i = 0; i < b.length; i++) {
		b[i]=a[i];
	}
	Arrays.sort(b);
	
	return length(a,b);
}
public static int[][] buildmatrix(int[] X,int [] Y){
	int[][] mat=new int [X.length+1][Y.length+1];
	for (int i = 1; i < mat.length; i++) {
		for (int j = 1; j < mat[0].length; j++) {
			if(X[i-1]==Y[i-1]) {
				mat[i][j]=mat[i-1][j-1]+1;
			}else {
				mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
	}
	return mat;
}
	
	public static int length (int[] a,int[] b) {
		int mat[][] = buildmatrix(a,b);
		int i = mat.length-1;
		int j = mat[0].length-1;
		int end = mat[i][j];
		int[] ans = new int[end];
		int start=0;
		while (start<end) {
			if (a[i-1]==b[j-1]) {
				ans[end-start-1] = a[i-1];
				i--; j--; start++;
			}
			else if (mat[i-1][j]>=mat[i][j-1]) i--;
			else j--;
		}
		return mat[mat.length-1][mat.length-1];
	}
	
	public static void main(String[] args) {
int[] a= {1,2,3,2,4,2,5};
System.out.println(lis(a));
	}
}
