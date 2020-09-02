package com.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * DFS => 재귀
 * BFS => 큐
 */

public class BOJ1260 {

	static int N, M, V;
	static int[][] graph;
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		graph = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		
		bfs();

		sc.close();
	}
	
	public static void dfs(int v, boolean[] visited) {
		System.out.print(v+" ");
		visited[v] = true;
		
		int cnt = 0;
		for(int i=1; i<N+1; i++) {
			if(graph[v][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(i, visited);
			}
		}
	}
	
	public static void bfs() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		visited[V] = true;
				
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			
			for(int i=1; i<N+1; i++) {
				if(graph[x][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
		System.out.println();
	}

}
