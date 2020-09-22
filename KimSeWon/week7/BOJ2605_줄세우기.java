package com.week7;

import java.util.Scanner;

public class BOJ2605_줄세우기 {

	static int[] order;	// 학생들이 줄을 선 순서
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		order = new int[N];
		// 순서 초기화
		for(int i=0; i<N; i++) {	
			order[i] = i+1;
		}
		
		// 번호 뽑기
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			swap(i-num, i);
		}
		
		// 출력
		for(int i=0; i<N; i++) {
			System.out.print(order[i]+" ");
		}
		sc.close();

	}
	
	private static void swap(int i, int j) {
		
		if(i-j == 0) {
			return;
		}
		
		if(j-i == 1) {
			int tmp = order[j];
			order[j] = order[i];
			order[i] = tmp;
		}
		else {
			int tmp = order[j];
			for(int k=j; k>i; k--) {	// i번째부터 j번째까지 한칸씩 미루기
				order[k] = order[k-1];
			}
			order[i] = tmp;
			
		}
		
	}

}
