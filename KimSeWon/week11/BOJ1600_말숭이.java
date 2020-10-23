package com.week11;

import java.util.*;

public class BOJ1600_말숭이 {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] dir = { {-1, 0}, {1, 0}, {0,-1}, {0,1} };
	static int[][] horseDir = { {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1,-2}, {2,1}, {1, 2} };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();	// 0: 평지, 1: 장애물
			}
		}
		
		visit = new boolean[H][W][31];	// (h,w) 지점에 능력을 k번 사용했다
		
		
		System.out.println(bfs(0, 0));
		sc.close();
	}
	
	public static int bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			if(now.x == H-1 && now.y == W-1) {
				return now.cnt;
			}
			
			if(now.k < K) {	// 아직 능력을 쓸 수 있으면 말처럼 이동
				for(int i=0; i<8; i++) {
					int nx = now.x + horseDir[i][0];
					int ny = now.y + horseDir[i][1];
					int nCnt = now.cnt + 1;
					
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visit[nx][ny][now.k+1]) {
						visit[nx][ny][now.k+1] = true;
						q.add(new Point(nx, ny, nCnt, now.k+1));
					}
				}
			}
			
			// 일반 이동
			for(int i=0; i<4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				int nCnt = now.cnt + 1;
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !visit[nx][ny][now.k]) {
					visit[nx][ny][now.k] = true;
					q.add(new Point(nx, ny, nCnt, now.k));
				}
			}
		}
		
		return -1;
	}
	
	public static class Point {
		int x, y, cnt, k;
		
		public Point(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

}
