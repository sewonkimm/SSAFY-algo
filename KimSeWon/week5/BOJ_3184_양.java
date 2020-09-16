package com.week5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_양 {

	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 탐색
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {	
					
					int o = 0;	// 구역 안 양의 수 
					int v = 0;	// 구역 안 늑대 수
					
					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Point now = q.poll();
						if(map[now.x][now.y] == 'o')		o++;
						else if(map[now.x][now.y] == 'v')	v++;
							
						for(int k=0; k<4; k++) {	// 4방 탐색
							int nx = now.x + dir[k][0];
							int ny = now.y + dir[k][1];
							
							if(nx >= 0 && nx < R && ny >= 0 && ny <C && !visited[nx][ny] && map[nx][ny] != '#') {
								visited[nx][ny] = true;
								q.offer(new Point(nx, ny));
							}
						}
					}		
					
					if(o > v) {		// 구역안에 양의 수가 늑대보다 많을 때
						sheep += o;
					}
					else {			// 구역안에 늑대의 수가 양보다 많을 때 
						wolf += v;
					}
					
				}
			}
		}
		
		// output
		System.out.println(sheep+" "+wolf);
	}

}
