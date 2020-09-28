package com.week8;
/*
 * 1. for문으로 모든 위치 탐색 
 * 2. W에 방문할 때마다 BFS로 연결된 모든 육지 방문하며 시작점으로 부터의 거리 기록 
 * 3. 최단거리  최댓값 갱신
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589_보물섬 {

	static int W, H;
	static char[][] map;
	static int answer = Integer.MIN_VALUE;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[W][H];
		for (int i = 0; i < W; i++) {
			String str = br.readLine();
			for (int j = 0; j < H; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 탐색 시작
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void bfs(int w, int h) {
		int[][] distance = new int[W][H];
		for(int i=0; i<W; i++) {
			Arrays.fill(distance[i], -1);	// 아직 방문하지 않은 곳은 -1
		}
		
		Queue<Point> q = new LinkedList<Point>();
		distance[w][h] = 0;
		int maxDistance = 0;
		q.offer(new Point(w, h));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// 4방향 탐색
			for(int i=0; i<4; i++) {
				int nextW = now.x + dir[i][0];
				int nextH = now.y + dir[i][1];
				
				if(nextW >= 0 && nextW < W && nextH >=0 && nextH <H 
						&& map[nextW][nextH] == 'L' && distance[nextW][nextH] == -1) {
					distance[nextW][nextH] = distance[now.x][now.y] + 1;
					q.offer(new Point(nextW, nextH));
					maxDistance = Math.max(maxDistance, distance[nextW][nextH]);
				}
			}
		}
		
		// 최댓값 갱신
		answer = Math.max(answer, maxDistance);
	}
}
