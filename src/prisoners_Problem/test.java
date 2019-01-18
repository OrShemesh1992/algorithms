package prisoners_Problem;

public class test {
	public static int Prisoners(int n) {
		int[] arr=new int[n];	
		boolean flag=true;
		int counter=0,count=0;
		while(counter<n) {
			count++;
			int p = (int)(Math.random()*n);
			if(p==0) { 
				if(arr[p]==0) { 
					arr[p]=1;
					counter++;
				}
				if(flag==false) {
					flag=true;
					counter++;
				}
			}else {
				if(arr[p]==0&&flag==true) {
					arr[p]=1;
					flag=false;
				}
			}
		}
		return count;
	}


	public static int Unknow(int n) {
		boolean flag=(int)(Math.random()*2)==0 ?  false:true;
		while(flag==false) {
			int p=(int)(Math.random()*n);
			if(p==0) {
				flag=true;
			}
		}
		return Prisoners(n);
	}
	public static void main(String[] args) {
		System.out.println(Prisoners(10));
		System.out.println(Unknow(10));
	}

}
