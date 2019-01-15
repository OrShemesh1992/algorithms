package prisoners_Problem;

public class prisoners {
	public static int prisonersLampOn(int n) {
		int[] enter=new int[n];
		boolean lamp = true;
		int count=0,steps=0;

		while(count<n) {
			steps++;
			int p=(int)(Math.random()*n);
			if(p==0)//the counter enter
			{
				if(enter[p]==0) {
					enter[p]=1;
					count++;
					System.out.println(p+" "+lamp+" "+ count +" ");
				}
				if(!lamp) {
					lamp=true;
					count++;
					System.out.println("Power On "+p+" "+ count);
				}
			}else {
				if(enter[p]==0&&lamp==true) {
					lamp=false;
					enter[p]=1;
					System.out.println("Power Off "+p);
				}
			}
		}
		return steps;
	}
	public static int prisonersLampUnknown(int n){
		boolean lamp = ((int)(Math.random()*2)==0) ? false : true;
		System.out.println("lamp = "+lamp);
		while (!lamp) {
		int p = (int)(Math.random()*n);
		if (p == 0)
		lamp = true;
		}
		System.out.println("lamp = "+lamp);
		int steps = prisonersLampOn(n);
		return steps;
	}
	public static void main(String[] args) {
		System.out.println(prisonersLampOn(10));
		System.out.println(prisonersLampUnknown(10));
	}

}
