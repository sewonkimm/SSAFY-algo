/*
 * BJ 10844 쉬운 계단 수
 */

import java.util.Scanner;

public class BJ_10844_EasyStairNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[101][11];
		
		// 1번째 초기화
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		// N번째 길이의 계단 수까지 확인
		// => 마지막 수를 확인하는 방향으로 진행
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1];
			// 여기서 9는 원래 8의 갯수에 따라서 달라지지만
			// 9 다음 수인 10은 0으로 설정되어 있으므로 그냥 1~8과 동일한 점화식으로 수행
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		
		System.out.println(sum%1000000000);
		sc.close();
	}

}
