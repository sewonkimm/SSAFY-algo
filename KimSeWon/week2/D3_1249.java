package com.study;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D1249 {

	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] map, count, visited;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_1249.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase=1; testCase<=T; testCase++){
			// input
			int N = sc.nextInt();
			map = new int[N][N];
			count = new int[N][N];
			for(int i=0; i<N;i++){
				String str = sc.next();
				for(int j=0; j<N; j++){
					map[i][j] = str.charAt(j)-'0';
					count[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// BFS
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(0, 0));
			count[0][0] = map[0][0];
			
			while(!q.isEmpty()){
				Point now = q.poll();
				
				for(int i=0; i<4; i++){
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];
					
					if(nx>=0 && nx<N && ny>=0 && ny<N){
						// 최솟값 저장
						if(count[nx][ny] > count[now.x][now.y]+map[now.x][now.y]) {
							count[nx][ny] = count[now.x][now.y]+map[now.x][now.y];
							q.offer(new Point(nx, ny));
						}						
					}
				}
			}
			
			// output
			int result = count[N-1][N-1];
			System.out.println("#"+testCase+" "+result);
		}
	}

}
