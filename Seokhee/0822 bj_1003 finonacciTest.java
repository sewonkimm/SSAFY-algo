import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class finonacciTest {
	
	static int[][] dp; //전형적인 dp문제 = 피보나치
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//제한시간 0.25초이기때문에 버퍼리더 사용
		dp = new int[41][2]; //0~40 이므로 41로
		dp[0][0] = 1; dp[0][1] = 0; //각 피보나치수의 0 사용횟수와 1 사용횟수의 기반이 될 초기화
		dp[1][0] = 0; dp[1][1] = 1;
		
		int T = Integer.parseInt(br.readLine());
		int n;
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			for(int i=2;i<=n;i++) { 
				dp[i][0] = dp[i-1][0]+dp[i-2][0]; //전의 사용량 더해줌
				dp[i][1] = dp[i-1][1]+dp[i-2][1]; //전의 사용량 더해줌
			}
			System.out.println(dp[n][0]+" "+dp[n][1]);
		}
		
	}
	//여기는 재귀형태로 짰는데 시간오버되서 버림
//	static int fibonacciDPu0(int n) {
//		if(n==0) {
//			return dp[0][0];
//		}
//		else if(n==1) {
//			return dp[1][0];
//		}
//		else {
//			if(dp[n][0]!=0) return dp[n][0];
//			return fibonacciDPu0(n-1)+fibonacciDPu0(n-2);
//		}
//	}
//	static int fibonacciDPu1(int n) {
//		if(n==0) {
//			return dp[0][1];
//		}
//		else if(n==1) {
//			return dp[1][1];
//		}
//		else {
//			if(dp[n][1]!=0) return dp[n][1];
//			return fibonacciDPu1(n-1)+fibonacciDPu1(n-2);
//		}
//	}
}
