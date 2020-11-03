package sliver;

import java.util.Scanner;

public class bj_2748_피보나치수2 {
	static long memo[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		memo= new long[n+1];

		System.out.println(fibo(n));
	}
	public static long fibo(int n) {


		memo[0] = 0;
		if(n>=1)
			memo[1] = 1;


		if(n>=2) {
			for (int i = 2; i < n+1; i++) {
				memo[i]= memo[i-1]+ memo[i-2];
			}
		}
		return memo[n];
	}
}
