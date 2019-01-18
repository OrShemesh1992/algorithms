package Matrix_1_0_Problem;

public class MatrixSqure {

	public static int SqureMatrix(int[][] a) {

		int[][] mat=new int[a.length][a.length];
		int max=0;
		for (int i = 0; i < mat.length; i++) {
			mat[i][0]=a[i][0];
			mat[0][i]=a[0][i];
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				if(a[i][j]==1) {
					mat[i][j]=Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1])+1;
				}
				if(mat[i][j]>max) max=mat[i][j];
			}
		}	
		return max*max;
	}

	public static int NumberOfK(int[][] a,int k) {

		int[][] mat=new int[a.length][a.length];
		int count=1;
		for (int i = 0; i < mat.length; i++) {
			mat[i][0]=a[i][0];
			mat[0][i]=a[0][i];
		}
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				if(a[i][j]==1) {
					mat[i][j]=Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1])+1;
				}
				if(mat[i][j]==k) count++;
			}
		}	
		return count;
	}
	public static void main(String[] args) {
		int[][] mat= {{0,0,1,0,1},{0,1,1,1,1},{1,1,1,1,0},{0,1,1,1,1},{0,0,1,1,1}};
		System.out.println(SqureMatrix(mat));
		System.out.println(NumberOfK(mat,2));
	}

}
