package Pizza;

public class Pizza {
	public static int PizzaMaxSub(double x,int n) {
		int k=(int)x+1;
		int p=n/(k+1);
		int r=n%(k+1);
		int ans=-1;//r = 1 forbidden state
		if(r!=1) {
			double t=(x*p+r-1)/((x+1)*p+r);
			if(t<x/(x+1)) ans=1;//הנוסחא נכונה
			else ans=0;//הנוסחא לא נכונה
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(PizzaMaxSub(1,3));

	}

}
