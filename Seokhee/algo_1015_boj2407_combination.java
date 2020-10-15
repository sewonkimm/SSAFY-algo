import java.util.Scanner;
import java.math.*;

public class algo_1015_boj2407_combination {

	//백준 2407 조합
	//좋은 문제는 아닌 것 같다,, long의 범위를 넘어서는 숫자가 나오기 때문에
	//BigInteger 클래스를 사용하자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//dp를 사용하자
		//nCm = n-1Cm-1 + n-1Cm
		
		BigInteger[][] dp = new BigInteger[101][101];
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				dp[i][j] = BigInteger.ZERO;
			}
		}
		
		for(int i=1;i<=100;i++) {
			dp[i][0] = BigInteger.ONE;
		}
		dp[1][1] = BigInteger.ONE;
		
		for(int i=2;i<=100;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j] = dp[i][j].add(dp[i-1][j-1]);
				dp[i][j] = dp[i][j].add(dp[i-1][j]);
			}
		}
		System.out.println(dp[n][m]);
		
	}

}
