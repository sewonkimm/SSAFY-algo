/*
 * BJ 1012 유기농 배추
 * delta를 이용해서 사방으로 나아가면서 확인
 */

import java.util.Scanner;

public class BJ_1012_OrganicCabbage {
	
	// delta
	static int[] dirR = {-1,0,1,0};
	static int[] dirC = {0,1,0,-1};
	// 테케 수, 가로, 세로, 배추 수, 벌레 수
	static int T, C, R, K, answer;
	static int r,c; // 배추 위치 좌표
	static int[][] map; // 땅
	static boolean[][] isVisited; // 벌레로부터 보호받는 땅인지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			answer = 0;
			C = sc.nextInt();
			R = sc.nextInt();
			K = sc.nextInt();
			map = new int[R][C];
			isVisited = new boolean[R][C];
			for (int i = 0; i < K; i++) {
				c = sc.nextInt();
				r = sc.nextInt();
				map[r][c] = 1;
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 1 && !isVisited[i][j]) {
						answer++;
						DFS(i,j);
					}
				}
			}
			System.out.println(answer);
		}
		sc.close();
	}
	
	private static void DFS(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dirR[i];
			int nc = c + dirC[i];
			
			if(nr<0 || nc<0 || nr >= R || nc >= C 
					|| isVisited[nr][nc] || map[nr][nc] == 0) continue;
			
			isVisited[nr][nc] = true;
			DFS(nr,nc);
		}
	}
}
