package Lcs;

import java.util.ArrayList;


public class LcsByLis {
	static ArrayList<Integer> [] help1=new ArrayList [26];
	static ArrayList<Integer> [] help2;
	static ArrayList <Integer> lis;
	
	public static void main(String[] args) {
		 for (int i=0; i<help1.length; i++) {
			 help1[i]=new ArrayList<Integer>();
		 }
		String x="cabdccb";
		String y="cbdaa";
		 LcsLis(x,y);
		 System.out.println(lengthLIS());
		
	}

	public static void LcsLis(String x, String y) {
		String longest=x;
		if (x.length()<y.length()) {
			help2=new ArrayList [x.length()];
			buildHelp(x);
			longest=y;
		}
		else {
			help2=new ArrayList [y.length()];
			buildHelp(y);
		}
		for (int i=0; i<help2.length; i++) {
			help2[i]=new ArrayList<>();
			help2[i].addAll(help1[longest.charAt(i)-'a']);
		}
		lis=new ArrayList<>();
		for (int i=0; i<help2.length; i++) {
			lis.addAll(help2[i]);
		}	
	}
	
		
	
	public static void buildHelp(String shortest) {
		for (int i=0; i<shortest.length();i++) {
			help1[shortest.charAt(i)-'a'].add(i);
		}
	}
	public static int lengthLIS() {
		int max =(int) lis.get(0);
		int length = 1;
		for (int i = 1; i < lis.size(); i++) {
			if ((int)lis.get(i) > max) {
				length++;
				max = (int)lis.get(i);
			}
		}
		return length;
	}
}