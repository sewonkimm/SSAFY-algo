/*
 * BJ 2156 포도주 시식
 * DP => BJ 2579 계단 오르기와 같은 문제
 */

import java.util.Scanner;

public class BJ_2156_DrinkWine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] wine = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = sc.nextInt();
		}
		
		dp[1] = wine[1];
		
		if(N>1) dp[2] = wine[1] + wine[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3]+wine[i-1]+wine[i], dp[i-2]+wine[i]);
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[N]);
		sc.close();
	}

}
