package brroze;

import java.util.Scanner;

public class bj_4673_셀프넘버{
	
	public static void main(String[] args) {
		
		int check[] = new int[10001];
		
		for (int i = 1; i < 10001; i++) {
			int N = cons(i);
			
			if(N< 10001)
			check[N] = 1;
		}
		
		for (int i = 1; i < check.length; i++) {
			
			if(check[i] != 1) {
				System.out.println(i);
			}
		}
	}
	
	public static int cons(int x) {
		
		int result = x;
		
		while(x !=0) {
			
			result = result+ x%10;
			x = x/10;
		}
		
		return result;
	}

}