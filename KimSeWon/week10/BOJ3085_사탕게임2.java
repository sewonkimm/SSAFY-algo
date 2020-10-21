package com.week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3085_사탕게임2 {

	static int cnt = Integer.MIN_VALUE;
	static int[][] dir = { {1, 0}, {0, 1} };
	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		// 전체 탐색 시작
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				// 아래, 오른쪽칸과 swap
				for(int k=0; k<2; k++) {
					int ni = i + dir[k][0];
					int nj = j + dir[k][1];
					
					if(ni >= 0 && ni < N && nj >= 0 && nj <N && map[i][j] != map[ni][nj]) {
						swap(i, j, ni, nj);
						getSeq(); // 가장 긴 연속부분(행 또는 열) 구하기
						swap(i, j, ni, nj);	// 다시 원래대로 swap
					}
					
				} // end of k
				
			} // end of j
		} // end of i
		
		System.out.println(cnt);
	}

	private static void getSeq() {	// ★핵심 메소드★		
		int seq_updown = 0;
		int seq_leftright = 0;
		
		for(int i=0; i<N; i++) {
			
			seq_updown = 1;
			seq_leftright = 1;
			
			for(int j=1; j<N; j++) {
				
				// 열
				if(map[j][i] == map[j-1][i]) {
					seq_updown++;
				}
				else {
					cnt = Math.max(cnt, seq_updown);
					seq_updown = 1;
				}
				
				// 행
				if(map[i][j] == map[i][j-1]) {
					seq_leftright++;
				}
				else {
					cnt = Math.max(cnt, seq_leftright);
					seq_leftright = 1;
				}
			}
			
			cnt = Math.max(cnt, Math.max(seq_updown, seq_leftright));
		}
	}
	
	private static void swap(int ai, int aj, int bi, int bj) {
		char tmp = map[ai][aj];
		map[ai][aj] = map[bi][bj];
		map[bi][bj] = tmp;
	}
}
