package SecretaryProblem;
import java.util.Arrays;

public class SecretaryProblem {
	/**
	 * Worst case O(nlog(n)+n)
	 * @param time
	 * @return
	 */
public static double SProblem(int[] time) {
	Arrays.sort(time);
	double avg=0;
	for(int x: time) avg = avg + avg +x;
	return avg/time.length;
}
	public static void main(String[] args) {
		int[] a= {5,2,6,7,3,7,4,7,8};
		System.out.println(SProblem(a));
	}

}
