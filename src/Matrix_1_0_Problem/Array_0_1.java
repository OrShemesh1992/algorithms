package Matrix_1_0_Problem;

public class Array_0_1 {
	/**
	 *Worst Case O(n) 
	 */
	public static int subArray(int[] arr) {
		int[] help =new int[arr.length];
		help[0]=arr[0];
		int max=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==1) {
				help[i]=help[i-1]+1;
			}else {
				help[i]=0;
			}
		}

		for (int i = 0; i < help.length; i++) {
			if(max<help[i]) {
				max=help[i];
			}
		}
		return max;
	}
	/**
	 * Worst case O(n)
	 */
	public static int subMat(int[][] mat) {
		int[][] help=new int[mat.length][mat.length];
		int maxDim=0;
		for (int i = 0; i < mat.length; i++) {
			help[0][i]=mat[0][i];
		}
		for (int i = 0; i < mat.length; i++) {
			help[i][0]=mat[i][0];
		}

		for (int i = 1; i < help.length; i++) {
			for (int j = 1; j < help.length; j++) {
				if(mat[i][j]==1) {
					help[i][j]=(Math.min(help[i-1][j-1],Math.min(help[i-1][j], help[i][j-1])))+1;
					if (help[i][j] > maxDim) {
						maxDim = help[i][j];
					}
				}
			}
		}
		return 	maxDim;
	}
	public static void main(String[] args) {
		int[] a= {1,0,1,0,0,0,0,0,0,0,0,1,1,1,1};
		System.out.println(subArray(a));
		int[][] b= {{0,0,1,0,0},{1,1,1,1,0},{0,1,1,1,1},{1,1,1,1,0},{1,1,0,0,1}};
		System.out.println(subMat(b));
	}

}
