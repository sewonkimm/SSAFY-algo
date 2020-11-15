package com.week14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5567_결혼식 {

	static int n, m, count;
	static boolean[][] relationship;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		relationship = new boolean[n+1][n+1];
		visit = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 인접행렬로 친구관계 표시
			relationship[a][b] = true;
			relationship[b][a] = true;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		visit[1] = true;
		for (int i = 2; i <= n; i++) {
			if(relationship[1][i] && !visit[i]) {
				visit[i] = true;
				count++;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 2; i <= n; i++) {
				if(relationship[now][i] && !visit[i]) {
					visit[i] = true;
					count++;
				}
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}
