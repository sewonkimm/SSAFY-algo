package com.week6;

import java.util.Scanner;

public class BOJ1976_여행가자 {

	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] plan = new int[M];
		for(int i=0; i<M; i++) {
			plan[i] = sc.nextInt();
		}
		
		// union-find
		makeSet();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1) {// 길이 있을 때마다
					union(i, j);	// 연결
				}
			}
		}
		
		//output
		boolean flag = true;
		for(int i=0; i<M-1; i++) {
			if(find(plan[i]) != find(plan[i+1])) {	// 사이클 연결이 안되어있으면 갈수 없음
				System.out.println("NO");
				flag = false;
				break;
			}
		}
		
		if(flag)	System.out.println("YES");
		sc.close();
	}
	
	private static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x)	return x;
		else return parents[x] = find(parents[x]);
	}
	
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px < py) parents[py] = px;
	}

}
