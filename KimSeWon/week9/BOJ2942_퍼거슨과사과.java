package com.week9;

import java.util.Scanner;

// GCD(A, B) A > B이면 
// GCD(A, B) = GCD(A%B, B) 이다.
public class BOJ2942_퍼거슨과사과 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int G = sc.nextInt();
		
		int g = GCD(R, G);	// 최대 공약수 구하기
		
		for(int i=1; i<=g; i++) {
			if(g % i == 0) {
				System.out.println(i+" "+R/i+" "+G/i);
			}
		}
		sc.close();
	}

	private static int GCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		
		return GCD(b, a%b);
	}
}
