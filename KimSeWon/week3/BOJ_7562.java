package com.week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * 몇 번만에 이동할 수 있는지 최소값을 체크하기 위해 BFS 사용
 */

class Chess {
	int x;
	int y;

	public Chess() {}
	public Chess(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Q7562 {
	static int[][] dir = {{-2,-1}, {-1,-2},{1,-2}, {2,-1},{2,1}, {1,2},{-1,2}, {-2,1}};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			// input
			int m = sc.nextInt();
			int[][] map = new int[m][m];
			int[][] visited = new int[m][m];

			Chess startPoint = new Chess();
			Chess endPoint = new Chess();
			startPoint.x = sc.nextInt();
			startPoint.y = sc.nextInt();
			endPoint.x = sc.nextInt();
			endPoint.y = sc.nextInt();
				
			// BFS
			Queue<Chess> q = new LinkedList<>();
			q.add(startPoint);
			visited[startPoint.x][startPoint.y] = 1;
			
			while(!q.isEmpty()) {
				Chess now = q.poll();
				
				// 체스 이동
				for(int i=0; i<8; i++) {
					int nx = now.x + dir[i][0];
					int ny = now.y + dir[i][1];
					
					// 이동할 수 있는지 검사
					if(nx>=0 && nx<m && ny>=0 && ny<m && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[now.x][now.y]+1;
						q.offer(new Chess(nx, ny));
					}
				}
			}
			
			// output
			System.out.println(visited[endPoint.x][endPoint.y]-1);
		}

	}

}
