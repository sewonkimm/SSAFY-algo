/*
 * BJ 1003 피보나치 함수
 * DP
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1003_FibonacciFunction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int[] zeroCount = new int[n+1];
			int[] oneCount = new int[n+1];
			Arrays.fill(zeroCount, 0);
			Arrays.fill(oneCount, 0);
			
			if(n == 0) {
				zeroCount[0] = 1;
				System.out.println(zeroCount[0] + " " + oneCount[0]);
			}else if(n == 1) {
				oneCount[1] = 1;
				System.out.println(zeroCount[1] + " " + oneCount[1]);
			}else {
				zeroCount[0] = 1;
				oneCount[1] = 1;
				for (int i = 2; i <= n; i++) {
					zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
					oneCount[i] = oneCount[i-1] + oneCount[i-2];
				}
				System.out.println(zeroCount[n] + " " + oneCount[n]);
			}
		}
		sc.close();
	}
	
}