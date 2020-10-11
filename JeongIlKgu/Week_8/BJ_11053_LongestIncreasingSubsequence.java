/*
 * BJ 11053 가장 긴 증가하는 부분 수열
 */

import java.util.Scanner;

public class BJ_11053_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] seq = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			seq[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i-1; j++) {
				if(seq[i] > seq[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
					max = Math.max(dp[i], max);
				}
			}
		}
        
		max = Math.max(dp[N], max);
		
		System.out.println(max);
		sc.close();
	}

}
