package com.week6;

import java.util.Scanner;

public class BOJ1149_RGB거리 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] rgb = new int[N][3];
		for(int i=0; i<N; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();
		}
		
		// dp
		int[][] dp = new int[N][3];		// i번째 집에 x색을 칠했을 때 비용
		for(int i=0; i<3; i++) {
			dp[0][i] = rgb[0][i];		// 첫번째 인덱스 값 초기화
		}
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
		}
		

		// output
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
		sc.close();
	}

}
