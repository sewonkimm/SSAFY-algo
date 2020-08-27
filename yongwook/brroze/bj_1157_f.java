package brroze;

import java.util.Scanner;

public class bj_1157_f {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		String a = sc.next(); 
		char b[] = a.toCharArray();
		
		int alpabetcnt[] = new int[100];
		
		for (int i = 0; i < b.length; i++) {
			
			if((b[i] & 32) == 32) 
					b[i]-=32;
				alpabetcnt[b[i]]++;
			
		}
		int max=0;
		char result = 0;
		for (int i = 64; i < 100; i++) {
			if(max< alpabetcnt[i]) {
				max = alpabetcnt[i];
				result = (char)i;
			}else if(alpabetcnt[i]== max) result='?';
			
		}
		System.out.println(result);
		
	}
}
