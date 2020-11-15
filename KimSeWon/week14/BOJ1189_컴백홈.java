package com.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189_컴백홈 {

	static int R, C, K, count;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		// 현재위치 (R-1, 0) 도착위치 (0, C-1)
		visit = new boolean[R][C];
		visit[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(count);
	}

	private static void dfs(int r, int c, int cnt) {

		// 집 도착
		if(r == 0 && c == C-1 && cnt == K) {
			count++;
			return;
		}
		
		if (cnt >= K)	return;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(nr >= 0 && nr < R && nc >= 0  && nc < C && !visit[nr][nc] && map[nr][nc] != 'T') {
				visit[nr][nc] = true;
				dfs(nr, nc, cnt+1);
				visit[nr][nc] = false;
			}
		}
	}

}
