package lis_lds;

import java.util.Arrays;

public class LisByLcs {
/**
 * O(n*m)
 */
	public static int[] LIS_usingLCS(int[] arr) {
		int[] s_arr = new int[arr.length];
		for (int i = 0; i < s_arr.length; i++) {
			s_arr[i] = arr[i];
		}
		Arrays.sort(s_arr);
		return lcs(arr, s_arr);
	}
	private static int[][] buldMatrix(int[] X,int[] Y) {
		int row=X.length+1;
		int col=Y.length+1;
		int mat[][] = new int[row][col];
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				if (X[i-1]==Y[j-1]) mat[i][j] = mat[i-1][j-1] + 1;
				else mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
		return mat;
	}

	private static int[] lcs(int[] X,int[] Y){
		int mat[][] = buldMatrix(X,Y);
		int i = mat.length-1;
		int j = mat[0].length-1;
		int end = mat[i][j];
		int[] ans = new int[end];
		int start=0;
		while (start<end) {
			if (X[i-1]==Y[j-1]) {
				ans[end-start-1] = X[i-1];
				i--; j--; start++;
			}
			else if (mat[i-1][j]>=mat[i][j-1]) i--;
			else j--;
		}
		return ans;
	}
}
