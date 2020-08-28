package com.week4;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * 1. map을 처음부터 탐색하면서 배추가 있는 부분을 발견하면
 * 2. BFS 탐색하고 cnt+1
 */


public class BOJ1012 {

	static int N,M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){

			// input
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;
			
			int K = sc.nextInt();
			Queue<Point> q = new LinkedList<>();
			for(int i=0; i<K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = 1;
			}
			

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						q.offer(new Point(i, j));
						
						// bfs
						while(!q.isEmpty()) {
							Point np = q.poll();
							
							for(int k=0; k<4; k++) {
								int nx = np.x + dir[k][0];
								int ny = np.y + dir[k][1];
								
								if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny] == 1) {
									visited[nx][ny] = true;
									q.offer(new Point(nx, ny));
								}
								
							}
						}
						
						
						visited[i][j] = true;
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}

}
