package com.week7;

import java.util.Scanner;

public class BOJ2559_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] temperature = new int[N];
		for(int i=0; i<N; i++) {
			temperature[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += temperature[i];
		}
		int max = sum;
		
		int idx = 0;
		
		for(int i=K; i<N; i++) {
			sum = sum - temperature[idx++] + temperature[i];
			if(sum > max)	max = sum;
		}
		
		System.out.println(max);		
		sc.close();
	}

}
