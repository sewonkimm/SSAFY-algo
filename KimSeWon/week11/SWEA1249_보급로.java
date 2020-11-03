package com.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1249_보급로 {

	static int N, INF=Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int C=1; C<=T; C++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			} // end for
			
			System.out.println("#"+C+" "+dijkstra(0, 0, N-1, N-1));
		} // end for C
	} // end main
	
	private static int dijkstra(int startX, int startY, int endX, int endY) {
		
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];	// 출발지에서 ~~를 거쳐서 (x,y)로 오는 최솟값
		
		// 1. 모든 비용 최댓값으로 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(minTime[i], INF);
		}
		
		// 2. 시작점 설정
		minTime[startX][startY] = 0;
		
		int x=0, y=0, nx, ny;
		while(true) {
			
			// 3. 미방문 정점 중 최소비용의 정점 찾기
			int cost = INF;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && cost > minTime[i][j]) {
						cost = minTime[i][j];
						x = i;
						y = j;
					}
				}
			} // end for
			
			// 4. 정점 방문
			visited[x][y] = true;
			if(x == endX && y == endY) return cost;

			// 5. 선택한 정점을 경유지로 하여 미방문 정점들의 최소비용 갱신
			for (int d = 0; d < 4; d++) {
				nx = x + dir[d][0];
				ny = y + dir[d][1];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N 
						&& !visited[nx][ny] && minTime[nx][ny] > cost+map[nx][ny]) {
					minTime[nx][ny] = cost+map[nx][ny];
				}
			}
		}
		
	} // end dijkstra
}
