public class SubString {
	public static int findElement(int begin,String st2 , char letter)
	{
		int index = -1;
		for (int i = begin; i < st2.length(); i++) {
			if(st2.charAt(i)==letter)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	public static String greedySubSeries(String x,String y)
	{
		String SubString="";
		int index=-1;
		int begin=0;
		for (int i = 0; i < x.length(); i++) {
			index=findElement(begin,y,x.charAt(i));
			if(index!=-1)
			{
				begin = index+1;
				SubString+=x.charAt(i);
			}
		}
		return SubString;
	}
	public static void Pluse1(int[] a)
	{
		int i=a.length-1;
		while(i>=0&&a[i]==1)
		{
			a[i--]=0;
		}
		if(i>=0) a[i]=1;
	}
	public static String[] allcomb(String x)
	{
		int n=x.length();
		int count = (int)(Math.pow(2, n)-1);
		String[] ans = new String[count];
		int[] bin=new int[n];
		for (int i = 0; i < count; i++) {
			Pluse1(bin);
			String temp="";
			for (int j = 0; j < n; j++) {
				if(bin[j]==1)
				{
					temp+=x.charAt(j);
				}
			}
			ans[i]=temp;
		}
		return ans;
	}
	public static void main(String[] args) {
		String x="abcbdab";
		String y="bdcaba";
		System.out.println(greedySubSeries(y,x));
	}
}
