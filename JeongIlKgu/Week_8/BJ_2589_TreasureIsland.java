/*
 * BJ 2589 보물섬
 * 전형적인 BFS 문제!
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2589_TreasureIsland {

	static class Point{
		int r,c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[R][C]; // 지도
		// delta
		int[] dirR = {-1,1,0,0};
		int[] dirC = {0,0,-1,1};
		int max = Integer.MIN_VALUE;
		Queue<Point> q = new LinkedList<Point>(); 
		
		for (int i = 0; i < R; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		sc.close();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// BFS 시작
				if(map[i][j] == 'L') {
					boolean[][] isVisited = new boolean[R][C];
					int[][] dist = new int[R][C];
					isVisited[i][j] = true;
					q.add(new Point(i,j));
					int distance = 0;
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						int x = p.r;
						int y = p.c;
						
						for (int k = 0; k < 4; k++) {
							int nr = x + dirR[k];
							int nc = y + dirC[k];
							
							if(nr>=0 && nc>=0 && nr<R && nc<C) {
								if(!isVisited[nr][nc] && map[nr][nc] == 'L') {
									q.offer(new Point(nr, nc));
									dist[nr][nc] = dist[x][y] + 1;
									isVisited[nr][nc] = true;
									
									distance = Math.max(distance, dist[nr][nc]);
								}
							}
						}
					}
					max = Math.max(max, distance);
				}
			}
		}
		System.out.println(max);
	}
	
}