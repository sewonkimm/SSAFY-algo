package com.week9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ4485_젤다 {
	
	static class Point {
		int x, y, w;

		public Point(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int idx = 1;
		while(n != 0) {
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[][] dist = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = map[0][0];
			
			// BFS
			Queue<Point> q = new LinkedList<Point>();
			q.add(new Point(0, 0, dist[0][0]));
			while(!q.isEmpty()) {
				Point now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nextX = now.x + dir[i][0];
					int nextY = now.y + dir[i][1];
					// 범위 내
					if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
						
						int nextW = now.w + map[nextX][nextY];
						// 방문하지 않았고, 누적합이 더 적을 때
						if(dist[nextX][nextY] > nextW) {
							dist[nextX][nextY] = nextW;
							q.add(new Point(nextX, nextY, nextW));
						}	
					}
				}
			}
			
			
			System.out.println("Problem "+idx+": "+dist[n-1][n-1]);
			n = sc.nextInt();
			idx++;
		}
		
		// 입력값이 0이면 프로그램 종료
		sc.close();
	}

}
