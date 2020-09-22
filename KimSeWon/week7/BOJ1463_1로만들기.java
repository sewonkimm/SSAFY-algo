
// 점화식 dp[i] = min(dp[i/3], dp[i/2], dp[i-1]) + 1

import java.util.Scanner;

public class BOJ1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int[] dp = new int[number+1];
		for(int i = 2; i <=number; i++) {
			if(i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]) , dp[i-1]) + 1;
			}
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
			}
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
			}
			else {
				dp[i] = dp[i-1] + 1 ;
			}
		}
		System.out.println(dp[number]);
		sc.close();
	}

}
