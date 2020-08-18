package com.ssafy.study;

/**
 * Delta 값 이용해서 상하좌우 탐색
 * BFS로 탐색해서 while문이 끝났을 때 도착점에 방문한 적이 있다면 1출력 
 */

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Maze {
	
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] maze, visited;
	static Point startP, endP;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int T=1; T<=10; T++){
			
			// input
			int tc = Integer.parseInt(br.readLine());
			maze = new int[16][16];
			visited = new int[16][16];
			
			for(int i=0; i<16; i++){
				String str = br.readLine();
				for(int j=0; j<16; j++){
					maze[i][j] = str.charAt(j) - '0';
					
					if(maze[i][j] == 2){
						startP = new Point(i, j);
					}
					if(maze[i][j] == 3){
						endP = new Point(i, j);
					}
				}
			}

			BFS();
			
			// output
			if(visited[endP.x][endP.y] == 0){
				System.out.println("#"+T+" 0");
			}
			else {
				System.out.println("#"+T+" 1");
			}
		}

	}

	public static void BFS(){
		Queue<Point> q = new LinkedList<>();
		q.offer(startP);
		visited[startP.x][startP.y] = 1;
		
		while(!q.isEmpty()){
			Point now = q.poll();
			
			for(int i=0; i<4; i++){
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				
				if(nx>=0 && nx<16 && ny>=0 && ny<16 && visited[nx][ny] == 0 && maze[nx][ny] != 1){
					q.offer(new Point(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
	}
}
