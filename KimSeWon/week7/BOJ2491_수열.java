package com.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2491_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int index = 0;
		while(st.hasMoreTokens()) {
			numbers[index++] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][2];	// dp[i][0,1] : i번째 수를 가리기키고 있을 때 가장 긴 증가/감소 하는 수열의 길이
		dp[0][0] = 1;
		dp[0][1] = 1;
		
		int max = 1;
		for(int i=1; i<N; i++) {
			
			if(numbers[i] >= numbers[i-1]) {	// 증가하는 경우
				dp[i][0] = dp[i-1][0]+1;
			}
			else {
				dp[i][0] = 1;
			}
			
			if(numbers[i] <= numbers[i-1]) {	// 감소하는 경우
				dp[i][1] = dp[i-1][1]+1;
			}
			else {
				dp[i][1] = 1;
			}
			
			// 최댓값 갱신
			for(int j=0; j<2; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		
		// output
		System.out.println(max);
	}

}
