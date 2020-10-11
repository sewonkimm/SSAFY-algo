package com.week8;

import java.util.Scanner;

public class BOJ11048_이동하기 {

	static int N, M;
	static int[][] map, candy;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		candy = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(i == 0) {	// 맨 윗줄
					if(j == 0)	candy[i][j] = map[0][0];
					else 		candy[i][j] = candy[i][j-1] + map[i][j];
				}
				else if(j == 0){
					candy[i][j] = candy[i-1][j] + map[i][j];
				}
				else {
					candy[i][j] = Math.max(candy[i-1][j-1], Math.max(candy[i-1][j], candy[i][j-1])) + map[i][j];
				}
			}
		}
		
		System.out.println(candy[N-1][M-1]);
 		sc.close();
	}

}
