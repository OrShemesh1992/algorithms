package Matrix_1_0_Problem;

public class RectangelTest {
	public static int rectangel(int[][] mat) {
		int maxarea = 0,area =0;
		if(mat.length == 0 || mat[0].length == 0) return 0;
		int[] help = new int [mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]==1)
					help[j]=help[j]+1;
				else help[j]=0;
			}
			area = area(help);
			if(maxarea<area) maxarea=area;
		}
		return maxarea;
	}
	public static int area(int[] help) {

		int right=0,left=0,index=0,index1=0 ,maxarea=0,area=0;
		for (int i = 0; i < help.length; i++) {
			if(help[i]>0) {
				right=i+1;
				left=i-1;
				index1=0;
				index=0;
			}
			while(right<help.length&&help[right]>=help[i]) {
				right++;
				index++;
			}
			while(left>=0 && help[left]>=help[i]) {
				left--;
				index1++;
			}
			area=(index1+index+1)*help[i];
			if(maxarea<area) maxarea=area;
		}
		return maxarea;
	}
	public static void main(String[] args) {
		int[][] a= {{1,0,0,1,1,1},{1,0,1,1,0,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		System.out.println(rectangel(a));
	}

}
