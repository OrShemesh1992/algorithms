package PlayNumber;

public class PlayNumberAdaptive {

	public static int array[]= {5,4,1,5,6,4}; 
	public static int AliceResult=0;
	public static int BobResult=0;
	public static int begin=0;
	public static int end=array.length-1;
	
	public static void play_rulesOddorEven()
	{
		int sumEven=0;
		int sumOdd=0;
		Boolean flag=true;
		for (int i = 1; i < array.length; i+=2) {
			sumEven+=array[i-1];
			sumOdd+=array[i];
		}
		if(sumEven<sumOdd)
			flag=false;

		while(end>begin)
		{
			if(flag&&begin%2==0||!flag&&begin%2!=0)	
			{
				AliceResult+=array[begin];
				begin++;
			}
			else
			{
				AliceResult+=array[end];
				end--;
			}
			if(array[begin]>array[end])	
			{
				BobResult+=array[begin];
				begin++;
			}
			else
			{
				BobResult+=array[end];
				end--;
			}
		}
		System.out.println("Alice");
		System.out.println(sumEven);
		System.out.println("Bob");
		System.out.println(sumOdd);

	}
	public static void main(String[] args) {
		play_rulesOddorEven();
	}

}

