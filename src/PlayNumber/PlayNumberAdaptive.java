package PlayNumber;

public class PlayNumberAdaptive {

	public static int[][] buildMatrix(int[] game){
		int[][] mat=new int[game.length][game.length];
		for (int i = 0; i < mat.length; i++) {
			mat[i][i]=game[i];
		}
		for (int i = mat.length-2; i <= 0; i++) {
			for (int j = i+1; j < mat.length; j++) {
				mat[i][j]=Math.max(game[i]-mat[i+1][j], game[j]-mat[i][j-1]);
			}
		}
		return mat;
	}

	public static void gameStrategy(int game[]){
		int	i=0, n = game.length, j = n - 1;
		int first=0, second=0, firstSum = 0, secondSum = 0;
		int mat[][]=buildMatrix(game);
		for (int k = 0; k < n/2; k++) {
			if (game[i]-mat[i+1][j] > game[j] - mat[i][j-1]) {
				firstSum = firstSum + game[i];
				first = i++;
			}else {
				firstSum = firstSum + game[j];
				first = j--;
			}
			if (i != j) { //j>0 && i<n-1)
				if (game[i]- mat[i+1][j] > game[j] - mat[i][j-1]) {
					secondSum = secondSum + game[i];
					second = i++;
				}else {
					secondSum = secondSum + game[j];
					second = j--;
				}
			}else { //j=0 or i=n-1, the second takes the last element
				second = j;
				secondSum = secondSum + game[j];
			}
			System.out.println("first: game["+first+"] = "+game[first]+
					", second: game["+second+"] = "+game[second]);
		}
		System.out.println("firstSum = "+firstSum+", secondSum = "+secondSum+
				", diff = "+(firstSum-secondSum));
	}
	public static void main(String[] args) {
		int[] a= {1,3,2,4,8,7};
		gameStrategy(a);
	}

}

