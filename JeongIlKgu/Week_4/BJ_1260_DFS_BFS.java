/*
 * BJ 1260 DFS와 BFS
 * 배열을 이용해서 해결
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1260_DFS_BFS {
	
	static int[][] graph;
	static boolean[] isVisited;
	static int N, M, V, v1, v2;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		
		isVisited = new boolean[N+1];
		DFS(V);
		System.out.println();
		isVisited = new boolean[N+1];
		BFS();
		sc.close();
	}
	
	// DFS => Stack 대신 재귀
	private static void DFS(int v) {
		System.out.print(v + " ");
		isVisited[v] = true;
		
		for (int i = 1; i <= N; i++) {
			if(graph[v][i] == 1 && !isVisited[i]) {
				DFS(i);
			}
		}
	}
	
	// BFS => Queue
	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		isVisited[V] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v + " ");
			
			for (int i = 1; i <= N; i++) {
				if(graph[v][i] == 1 && !isVisited[i]) {
					q.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}
}






