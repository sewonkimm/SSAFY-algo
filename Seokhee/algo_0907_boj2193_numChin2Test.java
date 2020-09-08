import java.io.*;
import java.util.*;
public class algo_0907_boj2193_numChin2Test {

	//백준2193 이친수
	//적으면서 규칙을 찾아보니까 피보나치와 동일한 갯수가 나왔다

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		
		
		if(n==1) {
			dp[1] = 1;
			System.out.println(dp[1]);
		}
		else if(n==2) {
			dp[1] = 1;
			dp[2] = 1;
			System.out.println(dp[2]);
		}
		else if(n>=3) {
			dp[1] = 1;
			dp[2] = 1;
			for(int i=3;i<=n;i++) {
				dp[i] = dp[i-1]+dp[i-2];
			}
			System.out.println(dp[n]);
		}
		/*
		1

		10
		 
		101 
		100 

		1010 
		1001 
		1000 

		10101 
		10100 
		10010
		10000
		10001 

		101010 
		101001 
		101000 
		100101 
		100100 
		100001 
		100000 
		100010 
		*/
	}
}
