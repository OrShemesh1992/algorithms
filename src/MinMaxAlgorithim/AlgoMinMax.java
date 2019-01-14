package MinMaxAlgorithim;

public class AlgoMinMax {
	 /**
	  * Algorithm The Best O(3/2*n-2) 
	  */
	public static void MaxMin(int[] arr) {
		int max,min;
		if(arr[0]>arr[1]) {
			max=arr[0];
			min=arr[1];
		}else {
			max=arr[1];
			min=arr[0];
		}
		for (int i = 2; i < arr.length-1; i++) {
			if(arr[i]<arr[i+1]) {
				if(arr[i]<min) {
					min=arr[i];
				}
				if(arr[i+1]>max) {
					max=arr[i+1];
				}
			}else {
				if(arr[i+1]<min) {
					min=arr[i+1];
				}
				if(arr[i]>max) {
					max=arr[i];
				}	
			}
		}
		if(arr.length%2!=0) {
			if(arr[arr.length-1]<min) {
				min=arr[arr.length-1];
			}else if(arr[arr.length-1]>max){
				max=arr[arr.length-1];
			}
		}
System.out.println("Max :"+max +" Min: "+min);
	}
	public static void main(String[] args) {
		int[] a= {3,2,8,7,1,9};
		MaxMin(a);
	}

}
