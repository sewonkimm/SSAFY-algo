package practice;

import java.util.Scanner;

public class sw_1217_°ÅµìÁ¦°ö {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		for (int i = 0; i < 10; i++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#"+(i+1)+" "+check(N,M));
		}
		
		
	}
	
	private static int check(int x , int y) {
		
		if(y==1)
			return x;
		
		return x*check(x,--y);
	}
	
}
