package com.week7;

import java.util.Scanner;

public class BOJ2563_색종이 {

	public static void main(String[] args) {
		boolean[][] background = new boolean[101][101];

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			
			// left ~ left+10, bottom ~ bottom+10 까지의 구간 다 색칠하기
			for(int x=0; x<10; x++) {
				for(int y=0; y<10; y++) {
					if(!background[left+x][bottom+y])	{
						background[left+x][bottom+y] = true;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(background[i][j])	answer++;
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
