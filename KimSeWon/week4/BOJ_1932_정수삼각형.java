package com.week4;

/**
 * DFS로 풀었을 때 시간초과 -> DP로 풀이
 * DP[i][j] = (i,j)까지 오는데 걸리는 수의 합 
 */

import java.util.Scanner;

public class BOJ1932_DP {

	static int n;
	static int[][] tri, dp;

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tri = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}

		// DP - bottom up
		dp[0][0] = tri[0][0];
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0) {		// 맨 왼쪽
					dp[i][j] = dp[i-1][j] + tri[i][j];
				}
				else if(j == i) {	// 맨 오른쪽
					dp[i][j] = dp[i-1][j-1] + tri[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1]+tri[i][j], dp[i-1][j]+tri[i][j]);
				}
			}
		}

		// output
		int answer = 0;
		for(int i=0; i<n; i++) {
			answer = Math.max(dp[n-1][i], answer);
		}
		System.out.println(answer);
		sc.close();
	}
}
