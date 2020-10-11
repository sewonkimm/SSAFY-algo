package com.week8;

import java.util.Scanner;

public class BOJ3036_링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] rings = new int[N];
		for(int i=0; i<N; i++) {
			rings[i] = sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			int gcd = getGCD(rings[0], rings[i]);
			System.out.println(rings[0]/gcd + "/" + rings[i]/gcd);
		}
		sc.close();
	}

	private static int getGCD(int a, int b) {
		return a % b == 0 ? b : getGCD(b, a % b);
	}
}
