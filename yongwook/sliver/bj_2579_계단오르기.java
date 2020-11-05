//package sliver;
//
//import java.util.Scanner;
//
//public class bj_2579_계단오르기 {
//	public static void main(String[] args) {
//		// 쵀댓값 ->dp문제
//
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//		int input[] = new int[N];
//		int arr[][] = new int[N][N];
//		int dparr[][] = new int[N][N];
//		// 배열생성
//		for (int i = 0; i < N; i++) {
//			input[i] = sc.nextInt();
//		}
//		
//		for (int i = 1; i < N; i++) {
//			for (int j = 0; j < i*2; j++) {
//				if()
//				arr[i][j] = input[j];
//			}
//		}
//		// dp 알고리즘
//		int cnt = 0;
//		for (int i = 1; i < N; i++) {
//			for (int j = 0; j < i*2; j++) {
//				
//				if( j == 0) {					
//					if(cnt!=0 &&cnt % 2 ==0 && cnt <N) {
//						cnt++;
//					}
//					if(cnt <N)	
//					dparr[i][j] = dparr[i-1][0] +arr[cnt++];
//				}								
//				else if(i == j ) {
//					if(cnt!=0 &&cnt % 2 ==0 && cnt <N) {
//						cnt++;
//					}
//					if(cnt <N)
//					dparr[i][j] = dparr[i-1][j-1] +arr[cnt++];
//				}
//			}
//		}
//	}
//}

package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 쵀댓값 ->dp문제

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N+1];
		int dp[] = new int[N+1];
		// 배열생성
		for (int i = 1; i <= N; i++) 
			input[i] = Integer.parseInt(br.readLine());

		//계단오른 최종칸수 
		dp[0] = input[0];
		dp[1] = input[1];
		// 계단이1일때 오류떠서 if구문으로 막아줌
		if(N+1>2) {
			dp[2] = input[1]+input[2];
		//	dp[3] = Math.max(input[1]+input[3], input[2]+input[3]);
			//dp[4] = 1,2,4    1,3,4  2,4  이렇게있는데 124에 24가포함되니	 124 134 두개
			//Math.max(input[4] + dp[4-2], input[4]+input[1]+input[3])
			//dp[5]=  1 2 4 5 / 135  / 235 /  이렇게3 개  
			//Math.max(	
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(input[i] + dp[i-2], input[i]+dp[i-3]+input[i-1]);
			}
		}
		System.out.println(dp[N]);

	}
}


