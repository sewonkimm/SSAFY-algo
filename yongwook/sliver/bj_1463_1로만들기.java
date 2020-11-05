package sliver;

import java.util.Scanner;

public class bj_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long memo[] = new long[n+1];

		memo[1] = 0;
		if(n>=2)
			memo[2] = 1;
		if(n>=3)
			memo[3]= 1; 
		if(n>=4)
			for (int i = 4; i < memo.length; i++) {

				if(i%2 == 0)
					Math.min(dp[4], b)
			}
		System.out.println(memo[n]);


	}
}
