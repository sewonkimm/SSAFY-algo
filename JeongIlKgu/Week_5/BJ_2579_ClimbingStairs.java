/*
 * BJ 2579 계단 오르기
 * DP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579_ClimbingStairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		
		// 1. 계단이 1개인 경우
		dp[1] = stairs[1];
		// 2. 계단이 2개인 경우
		if(N>1) dp[2] = stairs[1] + stairs[2];
		// 3. 계단이 3개인 경우
		if(N>2) dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
		// 4. 그 이상
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(stairs[i]+stairs[i-1]+dp[i-3], stairs[i]+dp[i-2]);
		}
		
		System.out.println(dp[N]);
	}

}
