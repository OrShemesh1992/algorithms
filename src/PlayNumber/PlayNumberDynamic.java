package PlayNumber;

public class PlayNumberDynamic {
	/**
	 * Play Number 0(n^2)
	 */
	public static int[][] bestWay(int[] a) {
		int[][] mat=new int[a.length][a.length];
		for (int i = 0; i < mat.length; i++) {
			mat[i][i]=a[i];
		}
		for (int i = mat.length-2; i >= 0; i--) {
			for (int j =  i+1; j < mat.length ; j++) {
				mat[i][j]=Math.max(a[i] - mat[i+1][j],a[j]-mat[i][j-1]);
			}
		}
		return mat;
	}
	public static int getHafres(int[] arr) {
		int a=0,b=0;
		int[][] mat=bestWay(arr);
		int i =0,j=arr.length-1;
		for (int k = 0; k < arr.length/2; k++) {
			if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]) {
				a+=arr[i];
				i++;
			}else {
				a+=arr[j];
				j--;
			}
			if(i!=j) {
				if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]) {
					b+=arr[i];
					i++;
				}else {
					b+=arr[j];
					j--;
				}
			}
			else {
				b+=arr[j];
			}
		}
		return a-b;
	}
	public static int TheBestOfTheWorld(int[] arr) {
		int a=0,b=0,temp1=0,temp2=0;
		
		int[][] mat=bestWay(arr);
		int i =0,j=arr.length-1;
		for (int k = 0; k < arr.length/2; k++) {
			if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]) {
				a+=arr[i];
				temp1=i++;
			}else {
				a+=arr[j];
				temp1=j--;
			}
			
			if(i!=j) {
				if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]) {
					b+=arr[i];
					temp2=i++;
				}else {
					b+=arr[j];
					temp2=j--;
				}
			}
			else {
				b+=arr[j];
				temp2=j;
			}
			System.out.println("The First One take index "+ temp1+
					" The valiue :"+arr[temp1]+" The Second take index "+ temp2+
					" The valiue :"+arr[temp2]);
		}
		return a-b;
	}
	public static void main(String[] args) {
		int[] a= {2,8,7,4};
		System.out.println(getHafres(a));
		System.out.println(TheBestOfTheWorld(a));
	}
}
