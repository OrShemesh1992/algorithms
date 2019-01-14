package Lcs;

public class LcsDynamic {
	/**
	 *  O(m+n)
	 * @param X
	 * @param Y
	 * @return
	 */
	public static int[][] buildMatrix(String X,String Y){

		int[][] mat =new int[X.length()+1][Y.length()+1];

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if(X.charAt(i-1)==Y.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1] + 1;
				}else {
					mat[i][j] = Math.max(mat[i-1][j],
							mat[i][j-1]);
				}
			}
		}
		return mat;

	}
	public static String oneLCS(String X ,String Y) {
		int[][] mat=buildMatrix(X,Y);
		int seqLength = mat[mat.length-1][mat[0].length-1];
		String result = "";
		int i = (mat.length - 1);
		int j = (mat[0].length - 1);
		int count = seqLength;
				while (count > 0) {
					if (X.charAt(i-1) == Y.charAt(j-1)) {
						result = X.charAt(i-1) + result;
						i--;
						j--;
						count--;
					}
					else {
						if (mat[i][j] == mat[i][j-1])
							j--;
						else
							i--;
					}
				}
		return result ;
	}
	public static void main(String[] args) {
		String X = "abcbda";
		String	Y = "bdcab";
		System.out.println(oneLCS(X,Y));
	}

}
