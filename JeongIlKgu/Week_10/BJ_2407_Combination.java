/*
 * BJ 2407 조합
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BJ_2407_Combination {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for (int i = 0; i < m; i++) {
			up = up.multiply(new BigInteger(String.valueOf(n-i)));
			down = down.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(up.divide(down));

	}

}
