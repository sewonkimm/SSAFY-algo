/*
 * BJ 1149 RGB거리
 * DP
 */

import java.util.Scanner;

public class BJ_1149_RGBStreet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 각각 RGB를 의미
		int[][] RGB = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		// RGB값 입력
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = sc.nextInt();
			}
		}
		// 0번째 처리
		for (int i = 0; i < 3; i++) {
			RGB[0][i] = 0;
			dp[0][i] = 0;
		}
		// R, G, B 각각을 선택할 때의 값을 모두 확인해 준다.
		// 점화식 : ex) R을 칠한 경우 dp[i][0] = 최소(dp[i-1][1], dp[i-1][2]) + RGB[i][0]
		for (int i = 1; i <= N; i++) {
			// R
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			// G
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			// B
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		sc.close();
	}

}
