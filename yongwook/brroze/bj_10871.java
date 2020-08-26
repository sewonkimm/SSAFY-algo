package brroze;

import java.util.Scanner;

public class bj_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int tc = sc.nextInt();
		int x = sc.nextInt();
		int x1 = 0;
		for (int i = 0; i < tc; i++) {
			x1 = sc.nextInt();
			
			if(x1<x)
			System.out.print(x1+" ");
		}
	}
}
