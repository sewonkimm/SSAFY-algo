package com.week5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2217_로프 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] rope = new int[N];
		for(int i=0; i<N; i++) {
			rope[i] = sc.nextInt();
		}
		
		Arrays.sort(rope);
		
		int max = Integer.MIN_VALUE;
		for(int i=N; i>0; i--) {	
			int w = rope[N-i]*i;	// 들어야하는 중량			
			max = Math.max(max, w);
		}
		
		// output
		System.out.println(max);
		sc.close();
	}

}

