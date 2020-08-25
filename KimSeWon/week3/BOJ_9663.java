package com.week3;

import java.util.Scanner;

public class Q9663 {

	static int N, answer;
	static boolean[][] chess;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new boolean[N][N];
		
		go(0);
		
		System.out.println(answer);
	}

	public static void go(int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (chess[cnt][i] == false) {
				// 놓을 수 있는지 확인
				boolean check = true;
				
				for(int k=0; k<N; k++) {
					if(chess[cnt][k])	{	// 1. 행
						check = false;
						break;
					}
					
					if(chess[k][i])	{	// 2. 열
						check = false;
						break;
					}
					
					if(cnt-k >= 0 && i-k >= 0 && chess[cnt-k][i-k]){	// 3. 대각선 - 좌상향
						check = false;
						break;
					}
					
					if(cnt-k >= 0 && i+k < N && chess[cnt-k][i+k]){	// 3. 대각선 - 우상향
						check = false;
						break;
					}
				}

				// 놓고 다음으로 넘어가기
				if (check) {
					chess[cnt][i] = true;
					go(cnt + 1);

					// 원상복귀
					chess[cnt][i] = false;
				}
			}
		}
	}
}
