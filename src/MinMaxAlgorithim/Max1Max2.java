package MinMaxAlgorithim;

public class Max1Max2 {
/**
 * Max1 and Max2 the worst case O(1.5n)
 */
	public static void Max_1_2(int[] arr) {
		int Max1,Max2;
		if(arr[0]>arr[1]) {
			Max1=arr[0];
			Max2=arr[1];
		}else {
			Max1=arr[1];
			Max2=arr[0];
		}
		for (int i = 2; i < arr.length-1; i=i+2) {
			if(arr[i+1]>arr[i]) {
				if(arr[i+1]>Max1) {
					Max2=Max1;
					Max1=arr[i+1];
				}
				if(arr[i]>Max2) {
					Max2=arr[i];
				}
			}
				else {
					if(arr[i+1]<arr[i]) {
						Max2=Max1;
						Max1=arr[i];
					}
					if(arr[i+1]>Max2) {
						Max2=arr[i+1];
					}
				}
			}
		if(arr.length%2!=0) {
			if(arr[arr.length-1]>Max1) {
				Max2=Max1;
				Max1=arr[arr.length-1];
			}
			else if(arr[arr.length-1]>Max2) {
				Max2=arr[arr.length-1];
			}
		}
		System.out.println("Max1 :"+Max1 +" Max2: "+Max2);
	}
	public static void main(String[] args) {
		int[] a= {3,2,8,11,1,9,10};
		Max_1_2(a);
	}

}
