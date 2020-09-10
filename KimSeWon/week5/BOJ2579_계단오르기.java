package com.week5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2579_계단오르기 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] Score = new int[N+1];
		for(int i=1; i<=N; i++) {
			Score[i] = sc.nextInt();
		}
		
		int[] dp = new int[N+1];	// dp[i]: i번째 계단을 밟았을 때의 최대 점수
		Arrays.fill(dp, 0);
		
		dp[1] = Score[1];
		if(N >= 2)    dp[2] = Score[1]+Score[2];
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3]+Score[i-1], dp[i-2])+Score[i];
		}
		
		// output
		System.out.println(dp[N]);
		sc.close();
	}

	
}
