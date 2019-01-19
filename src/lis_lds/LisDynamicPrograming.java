package lis_lds;

public class LisDynamicPrograming {
	/**
	 * Worst Case 0(nlogn)
	 */
	public static int lis(int[] a) {
		int[] help =new int[a.length];
		help[0]=a[0];
		int lis = 1,index;
		for (int i = 1; i < a.length; i++) {
			index= binarySarch(help , a[i] , lis );
			help[index]=a[i];
			if(index>lis) lis++;
		}
		return lis;
	}


	public static int binarySarch(int[] help , int a , int lis) {
		if(a<help[0]) return 0;
		if(a>help[lis]) return lis+1;
		int start = 0;
		while(start<=lis) {
			int middle = (start + lis) /2;
			if(start == lis) return start;
			else {
				if(help[middle]==a) return middle;
				else if(a<help[middle]) lis=middle;
				else start = middle+1;
			}
		}
		return -1;
	}
	/**
	 * Worst case O(nlog(n))
	 */
	public static int lis1(int[] a,int k) {
		int[] help =new int[a.length];
		help[0]=a[0];
		int lis = 1,index;
		for (int i = 1; i < a.length; i++) {
			index= binarySarch1(help , a[i] , lis ,k);

			help[index]=a[i];
			if(index>lis) lis++;
		}
		return lis;
	}
	public static int binarySarch1(int[] help , int a , int lis ,int k) {
		if(Math.abs(a-help[0])==k) return 0;
		if(Math.abs(a-help[lis])==k) return lis+1;
		int start = 0;
		while(start<=lis) {
			int middle = (start + lis) /2;
			if(start == lis) return start;
			else {
				if(help[middle]==a&&help[middle]==k) return middle;
				else if(a<help[middle]) lis=middle;
				else start = middle+1;
			}
		}
		return -1;
	}
	public static int betweenNumber( int [] a , int k) {
		int sum=0,index=0,lis=0;
		int[] help=new int[a.length ];
		help[0]=0;
		for (int i = 1; i < help.length; i++) {
			help[i]=Math.abs(a[i]-a[i-1]);
		}
		for (int i = 1; i < help.length; i++) {
			if(help[i]==k) {
				lis++;
				index=i;
				sum=0;
			}else if(lis==0&&a[i]==k) {
				lis++;
				index=i;
				sum=0;
			}else {
				sum+=help[i];
				if(sum==k) {
					sum =0 ;
					lis++;
					index=i;
				}else if (sum>k) {
					if(Math.abs(a[index]-a[i])==k) {
						sum=0;
						index=i;
						lis++;
					}
				}
			}
		}
		return lis;
	}
	public static void main(String[] args) {
		int[] a= {1,11,2,10,4,5,2,1};
		System.out.println(lis(a));
		System.out.println(lis1(a,3));
		int[] b= {10,7,5,4,3,4,1,2,4,7};
		System.out.println(betweenNumber(b,3));
	}

}
