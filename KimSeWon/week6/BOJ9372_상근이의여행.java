/*
주어지는 스케쥴은 항상 연결 그래프를 이루기 때문에
타야하는 비행기의 최소 개수는 항상 N-1 개이다.
*/

package com.week6;

import java.util.Scanner;

public class BOJ9372_상근이의여행 {
	
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int j=0; j<M; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
			}
			
			// output
			System.out.println(N-1);
		}
		sc.close();
	}

}
