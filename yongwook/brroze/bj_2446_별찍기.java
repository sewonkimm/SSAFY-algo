package brroze;

import java.util.Scanner;

public class bj_2446_별찍기 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N*2-i; j++) {
				
				if(j>=i) {
					System.out.print("*");
				
				}else
					System.out.print(" ");
				
			}
		
			System.out.println();
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N-i; j++) {								
				System.out.print(" ");
			}
			for (int j = 1; j <=1+2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
