package brroze;

import java.util.Scanner;

public class bj_10809_f {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int alpabet[] = new int [26] ;// a~z
		int alpabet3[] = new int[26];
		String alpabet1 = sc.next();
		char alpabet2[] = null;
		alpabet2 = alpabet1.toCharArray();
		for (int i = 0; i < alpabet.length; i++) {									
			alpabet[i]= 'a'+i;
			alpabet3[i]= -1;
		}
		
		for (int i = 0; i < alpabet2.length; i++) {
			for (int j = 0; j < alpabet.length; j++) {
				if(alpabet2[i] == (char)alpabet[j]) {
					if(alpabet3[j]== -1)
					alpabet3[j] = i;	
				}
			}
		}
		for (int i = 0; i < alpabet3.length; i++) {
			System.out.print(alpabet3[i]+" ");
		}
	}
}
