/*
 * BJ 9461 파도반 수열
 * DP
 */

import java.util.Scanner;

public class BJ_9461_WaveSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			long[] dp = new long[N+2];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-2] + dp[i-3];
			}
			
			System.out.println(dp[N]);
		}
		sc.close();
	}

}

