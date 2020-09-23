package com.week7;

import java.util.Scanner;

public class BOJ3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[42];	// 42로 나눈 나머지가 몇 개있는지 세는 배열
		for(int i=0; i<10; i++) {
			int x = sc.nextInt();
			count[x%42]++;
		}
		
		// output
		int cnt = 0;
		for(int i=0; i<42; i++) {
			if(count[i] > 0)	cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

}
