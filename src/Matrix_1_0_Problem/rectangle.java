package Matrix_1_0_Problem;

public class rectangle {
	public static int getMaxArea(int[]help) {
		int maxarea = 0,area;
		int p = 0, x = 0, q = 0, y = 0;
		for (int i = 0; i < help.length; i++) {
			if(help[i] > 0) {
				p = i-1;
				x = 0;
			}
			while(p >= 0 && help[p] >= help[i]) {
				p--;
				x++;
			}
			q = i+1;
			y = 0;
			while(q < help.length && help[q] >= help[i]) {
				q++;
				y++;
			}
			area = (x+y+1)*help[i];
			if(area > maxarea) maxarea = area;
		}
		return maxarea;
	}
	 /**
	  * Worst Case O(n^3)
	  */
	public static int findMaxRectangle(int mat[][]) {
		int maxarea = 0,area =0;
		if(mat.length == 0 || mat[0].length == 0) return 0;
		int[] help = new int[mat[0].length];
		
		for (int i = 0; i <  mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) {
					help[j] = help[j]+1;
				}else {
					help[j] = 0;
				}
			}
			area = getMaxArea(help);
			if(area > maxarea) maxarea = area;
		}
		return maxarea;
	}

	public static void main(String[] args) {
		int[][] a= {{1,0,0,1,1,1},{1,0,1,1,0,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		System.out.println(findMaxRectangle(a));
	}
}
