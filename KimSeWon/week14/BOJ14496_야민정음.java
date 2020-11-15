package com.week14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14496_야민정음 {

	private static class Point{
		int index;
		int count;
		public Point(int index, int count) {
			this.index = index;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[][] map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = true;
			map[y][x] = true;
		}
		
		int answer = Integer.MAX_VALUE;
		
		// BFS
		boolean[] visit = new boolean[N+1];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(a, 0));
		visit[a] = true;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			// 종료 조건
			if(now.index == b) {
				answer = Math.min(answer, now.count);
			}
			
			for (int i = 1; i <= N; i++) {
				if(!visit[i] && map[now.index][i]) {
					q.add(new Point(i, now.count+1));
					visit[i] = true;
					
				}
			}
		}
		
		if(answer == Integer.MAX_VALUE)	answer = -1;	// 치환이 불가능한 경우
		System.out.println(answer);
		sc.close();
	}

}
