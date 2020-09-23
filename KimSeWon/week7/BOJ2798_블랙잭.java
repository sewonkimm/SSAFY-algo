package com.week7;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2798_블랙잭 {

	static int N, M;
	static int[] combArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] card = new int[N];
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		combArr = new int[N];	// N개중 3개를 뽑기 위한 배열
		for(int i=0; i<3; i++) {
			combArr[i] = 1;
		}
		Arrays.sort(combArr);
		
		int max = Integer.MIN_VALUE;
		do {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(combArr[i] == 1)	sum+=card[i]; 
			}
			
			// M을 넘지 않는 수로 최댓값 갱신
			if(sum <= M)	max = Math.max(max, sum);
		}while(nextPermutation());
		
		System.out.println(max);
		sc.close();
	}

	private static boolean nextPermutation() {
		int i = N-1;
		while(i > 0 && combArr[i-1] >= combArr[i]) {
			i--;
		}
		
		if(i == 0)	return false;
		
		int j = N-1;
		while(combArr[i-1] >= combArr[j]) {
			j--;
		}
		
		swap(i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = combArr[i];
		combArr[i] = combArr[j];
		combArr[j] = tmp;
	}
}
