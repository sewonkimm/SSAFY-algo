package com.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장 {

	static int[] price = new int[4];
	static int[] month = new int[13];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[13];	// dp[i]: i월의 최소비용
			// dp[i] = min(dp[i-1] + min(price[0]*month[i], price[1]),   dp[i-3] + price[2])
			for (int i = 1; i <= 12; i++) {
				
				int x = Math.min(month[i]*price[0], price[1]);
				
				if(i >= 3) {
					dp[i] = Math.min(dp[i-1]+x, dp[i-3]+price[2]);
				}
				else {
					dp[i] = dp[i-1]+x;
				}
					
			}
			int answer = Math.min(dp[12], price[3]);
			System.out.println("#"+testcase+" "+answer);
			
			
		} // end testcase
	} // end main

}
