/*
 * BJ 2748 피보나치 2
 * DP
 */

import java.util.Scanner;

public class BJ_2748_Fibonacci2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		long a = 0;
		long b = 1;
		long temp = 0;
		
		for (int i = 0; i < N-1; i++) {
			temp = b;
			b = a + b;
			a = temp;
		}
		
		System.out.println(b);
	}
}