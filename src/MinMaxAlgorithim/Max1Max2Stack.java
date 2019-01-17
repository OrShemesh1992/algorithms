package MinMaxAlgorithim;

public class Max1Max2Stack {
	public static int Max1Max2_Stack(Node[] arr,int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			int i=Max1Max2_Stack(arr,low,mid);
			int j=Max1Max2_Stack(arr,mid+1,high);
			int index=-1;
			if(arr[i].num>arr[j].num) {
				arr[i].st.push(arr[j].num);
				index=i;
			}else {
				arr[j].st.push(arr[i].num);
				index=j;
			}
			return index;
		}
		return low;
	}
	public static void MaxMax(int[] arr) {
		int n=arr.length;
		Node[] node=new Node[n];
		for (int i = 0; i < n; i++) {
			node[i] =new Node(arr[i]);
		}
		int index=	Max1Max2_Stack(node,0,n-1);	
		int max1=node[index].num;
		int max2=node[index].st.pop();
		while(!node[index].st.isEmpty()) {
			int temp = node[index].st.pop();
			if(temp>max2) max2=temp;
		}
		System.out.println("Max1: " + max1 + "\n" + "max2: " + max2);
	}
	public static void main(String[] args) {
		int a[] = { 1, 10, 8, 50, 31, 49, 9, 5, 20, 11, 18, 19, 15, 30 };
		MaxMax(a);
	}
	
}
